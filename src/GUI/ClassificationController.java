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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import Utils.MyDB;
import Entities.Classification;
import Services.ServiceClassification;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ClassificationController implements Initializable {

    @FXML
    private TableView<Classification> table;
    @FXML
    private TableColumn<Classification, Integer> col_id;
    @FXML
    private TableColumn<Classification, String> col_nom;
    @FXML
    private TableColumn<Classification, String> col_domaine;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_domaine;
    @FXML
    private TextField txt_id;
     @FXML
     private JFXTextField txt_keyword;
     @FXML
    private Label filr_path;
int index= -1;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    ServiceClassification sm;
    /**
     * Initializes the controller class.
     */
    public void clearTextField(){
        txt_id.clear();
        txt_nom.clear();
        txt_domaine.clear();
        
    }
      

    @FXML
    private void getSelected(MouseEvent event) {
         index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString()); 
        txt_nom.setText(col_nom.getCellData(index).toString());
        txt_domaine.setText(col_domaine.getCellData(index).toString());
    }

    @FXML
    private void supprimer(ActionEvent event) {
         try {
            conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String value2 = txt_nom.getText();
            String value3 = txt_domaine.getText();
           
            String sql="UPDATE `classification` SET `archive`='" + 1 + "' WHERE `id`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Classification supprimé");
                        clearTextField();

            updateTable();
            

                        
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } 
    }

    @FXML
    private void add_Classification(ActionEvent event) {
        
        if (txt_nom.getText().toString().trim().length()==0){
         JOptionPane.showMessageDialog(null, "Textfield can't be empty");
        
     } 
     
     else if (txt_domaine.getText().toString().trim().length()==0){
          JOptionPane.showMessageDialog(null, "Textfield can't be empty");
     }
     else{ 
                conn=MyDB.getInstance().getCnx();
        String qry ="INSERT INTO `classification`(id, `nom`, `domaine`) VALUES (?,?,?)";
        try {
            pst=conn.prepareStatement(qry);
                 pst.setInt(1, 0);

            pst.setString(2, txt_nom.getText());
            pst.setString(3, txt_domaine.getText());
            
      
            pst.execute();
            JOptionPane.showMessageDialog(null, "Classification ajoutée avec succès");
            clearTextField();
            updateTable();
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    }
    public void updateTable(){
        ServiceClassification sc = new ServiceClassification();
        List<Classification> classifications = sc.afficher();
        ObservableList<Classification> listC=FXCollections.observableArrayList(classifications);
       col_id.setCellValueFactory(new PropertyValueFactory<Classification,Integer>("id")); //lier val de colonne avec propriete d'obj
        col_nom.setCellValueFactory(new PropertyValueFactory<Classification,String>("nom"));
        col_domaine.setCellValueFactory(new PropertyValueFactory<Classification,String>("domaine"));
        
        listC=sc.afficherData();
        table.setItems(listC);
        FilteredList<Classification> filteredData= new FilteredList<>(listC,b->true);
 txt_keyword.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredData.setPredicate( annonce ->{
                if(newvalue.isEmpty() || newvalue == null){return true; }
                String search = newvalue.toLowerCase();
                if(annonce.getNom().toLowerCase().indexOf(search) != -1){
                    return true;
                } else if(annonce.getDomaine().toLowerCase().indexOf(search) != -1)  {return true;}
          
                return false;
            });
    });
        SortedList<Classification> sortedData= new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    private void edit(ActionEvent event) {
        try {
            conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String value2 = txt_nom.getText();
            String value3 = txt_domaine.getText();
           
            String sql="UPDATE `classification` SET `nom`='" + value2 + "', `domaine`='" + value3 + "' WHERE `id`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modifier");
            clearTextField();
            updateTable();

                        
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } 
    }
    @FXML
public void redirectToAnnonce(ActionEvent event) throws Exception {              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Annonce.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_nom.prefWidthProperty().bind(table.widthProperty().divide(3)); // w * 1/4
        col_domaine.prefWidthProperty().bind(table.widthProperty().divide(3)); // w * 1/2
        
        updateTable();
    } 
    
}
