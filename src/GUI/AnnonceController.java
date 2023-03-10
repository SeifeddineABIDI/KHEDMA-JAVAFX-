/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import Utils.MyDB;
import Entities.Annonce;
import Services.ServiceAnnonce;
import Services.ServiceClassification;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/*import sample.model.ExportToPdf;*/
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AnnonceController implements Initializable {

    @FXML
    private TableView<Annonce> table;
    @FXML
    private TableColumn<Annonce,Integer> col_id;
    @FXML
    private TableColumn<Annonce,String> col_titre;
    @FXML
    private TableColumn<Annonce,String> col_nomclient;
    @FXML
    private TableColumn<Annonce,LocalDate> col_date;
    @FXML
    private TextField txt_titre;
    private TextField txt_nomclient;
    @FXML
    private TextField txt_id;
    @FXML
    private DatePicker inputdate;

     @FXML
     private JFXTextField txt_keyword;
     @FXML
    private Label filr_path;
       
    @FXML
    private ComboBox<String> combo_c;
    @FXML
    private AnchorPane anch;
int index= -1;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    ServiceClassification sa=new ServiceClassification();
    ServiceAnnonce s1;
   public String path;
    private List<Annonce> annonces = new ArrayList<>();
    @FXML
    private Button btnnotif;
    /**
     * Initializes the controller class.
     */
    
 public void clearTextField(){
        txt_id.clear();
        txt_titre.clear();
        txt_nomclient.clear();
      //  txt_idc.clear();
    }
 

    @FXML
    private void getSelected(MouseEvent event) {
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }

        txt_id.setText(col_id.getCellData(index).toString());
        txt_titre.setText(col_titre.getCellData(index).toString());
        txt_nomclient.setText(col_nomclient.getCellData(index).toString());
        inputdate.setValue(col_date.getCellData(index));
         //txt_idc.setText(col_idc.getCellData(index).toString());
    }

    @FXML
    private void supprimer(ActionEvent event) {
          try {
            conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
           // String value2 = txt_titre.getText();
           // String value3 = txt_nomclient.getText();
          //  LocalDate value4 = inputdate.getValue();
          //  String value5 = txt_idc.getText();
           
            String sql="UPDATE `annonce` SET `archive`='" + 1 + "' WHERE `id`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Annonce supprimée");
                        clearTextField();

            updateTable();
            

                        
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } 
    }

    
    @FXML
 public void add_annonce() {
        System.out.println(inputdate.getValue());
     if (txt_titre.getText().toString().trim().length()==0){
         JOptionPane.showMessageDialog(null, "Textfield can't be empty");
        
     } 
   
     
     else if (combo_c.getValue()==null){
          JOptionPane.showMessageDialog(null, "ComboBox can't be empty");
     }
     
      else if (inputdate.getValue()==null){
          JOptionPane.showMessageDialog(null, "Date can't be empty");
     }
     
     
     else{
               ZoneId defaultZoneId = ZoneId.systemDefault();

        Date date = Date.from(inputdate.getValue().atStartOfDay(defaultZoneId).toInstant());
       
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        conn=MyDB.getInstance().getCnx();

       String qry ="Insert into annonce (id,titre,id_client,date,id_c) values (null, '"+txt_titre.getText()+"','8','"+sqlDate+"',"+sa.getIdByNom(combo_c.getValue())+")";
       System.out.println(qry);
       try {
            pst=conn.prepareStatement(qry);

            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Annonce ajoutée avec succès");
            clearTextField();
            updateTable();
        } catch (Exception e) {
           System.out.println( e);
              JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    }
    
    
    @FXML
    public void updateTable(){
        String val=combo_c.getValue();
        ServiceClassification sa = new ServiceClassification();
        List<Annonce> annonces = sa.afficherByNomClassification(val);
        ObservableList<Annonce> listA=FXCollections.observableArrayList(annonces);
       col_id.setCellValueFactory(new PropertyValueFactory<Annonce,Integer>("id"));
        col_titre.setCellValueFactory(new PropertyValueFactory<Annonce,String>("titre"));
        col_nomclient.setCellValueFactory(new PropertyValueFactory<Annonce,String>("nom_client"));
         col_date.setCellValueFactory(new PropertyValueFactory<Annonce,LocalDate>("date"));

        table.setItems(listA);
                FilteredList<Annonce> filteredData= new FilteredList<>(listA,b->true);
        txt_keyword.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredData.setPredicate( annonce ->{
                if(newvalue.isEmpty() || newvalue == null){return true; }
                String search = newvalue.toLowerCase();
                if(annonce.getTitre().toLowerCase().indexOf(search) != -1){
                    return true;
                } else if(String.valueOf(annonce.getDate()).indexOf(search) != -1)  {return true;}
             
                else if(String.valueOf(annonce.getId_c()).indexOf(search) != -1)  {return true;}
                return false;
            });
    });
        SortedList<Annonce
                > sortedData= new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
    


    @FXML
private void redirectToClassification(ActionEvent event) throws Exception {              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Classification.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    
    @FXML
private void exportpdf(ActionEvent event){              
   PDF pd=new PDF();
        try{
        pd.GeneratePdf("Liste des annonces");
            System.out.println("impression done");
        } catch (Exception ex) {
            Logger.getLogger(ServiceAnnonce.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    @FXML
private void notifier(ActionEvent event){  
Notifications.create()
          .title("Notification")
          .text("Votre annonce sera publiée")
          .position(Pos.BOTTOM_RIGHT)
          .hideAfter(Duration.seconds(5))
          .showInformation();
}
    @FXML
    private void edit(ActionEvent event) {
        try {
            conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String value2 = txt_titre.getText();
           // String value3 = txt_nomclient.getText();
            LocalDate value4 = inputdate.getValue();
         //   String value5 = combo_c.getValue();
          String value5 ="";
            String sql="UPDATE `annonce` SET `titre`='" + value2 + "',`date`='" + value4 + "' WHERE `id`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Annonce modifiée");
            clearTextField();
            updateTable();

                        
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } 
    }

    
    public void comboBoxList(){
    ServiceClassification sa=new ServiceClassification();
    List<String>annonces=sa.afficherAllNames();
    ObservableList<String> observableAnnonce=FXCollections.observableArrayList(annonces);
    combo_c.setItems(observableAnnonce);
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       comboBoxList();
        col_titre.prefWidthProperty().bind(table.widthProperty().divide(3)); // w * 1/4
        col_nomclient.prefWidthProperty().bind(table.widthProperty().divide(3)); // w * 1/2
        //col_nomclient.prefWidthProperty().bind(table.widthProperty().divide(3));
        col_date.prefWidthProperty().bind(table.widthProperty().divide(3));
        //col_idc.prefWidthProperty().bind(table.widthProperty().divide(3));
        updateTable();
    } 
 private Stage getStage() {
        return (Stage) txt_keyword.getScene().getWindow();
    }
    
        private void closeStage(ActionEvent event) {
        getStage().close();
    }
    @FXML
    private void retern(ActionEvent event) {
         try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FrontClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             closeStage(event);
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    
    
    
}
