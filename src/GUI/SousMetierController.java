/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Metier;
import Entities.SousMetier;
import Services.ServiceMetier;
import Services.ServiceSousMetier;
import Utils.MyDB;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.*;
import java.util.stream.Collectors;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * FXML Controller class
 *
 * @author Safe
 */
public class SousMetierController implements Initializable {
    @FXML
    private TableView<SousMetier> table;
    @FXML
    private TableColumn<SousMetier, Integer> col_id;
    @FXML
    private TableColumn<SousMetier, String> col_libelle;
    @FXML
    private TableColumn<SousMetier, String> col_domaine;
    @FXML
    private TableColumn<SousMetier, Integer> col_metier;
    @FXML
    private TextField txt_libelle;

    @FXML
    private TextField txt_domaine;

    @FXML
    private TextField txt_id;

    @FXML
    private ComboBox<String> combo_metier;
    @FXML
    private Text msg;
        @FXML
    private JFXTextField txt_field;


    int index= -1;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    ServiceMetier sm;
    /**
     * Initializes the controller class.
     */
       public void clearTextField(){
        txt_id.clear();
        txt_libelle.clear();
        txt_domaine.clear();
       
    }
        public void formControl(String rep){
            msg.setText(rep);
        }
        public void getSelected(){
         
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());

        txt_libelle.setText(col_libelle.getCellData(index).toString());
        txt_domaine.setText(col_domaine.getCellData(index).toString());
        
               

    }
        Boolean verif=false;
    String nom_sousmetier;
    public void add_SousMetier(){
        conn=MyDB.getInstance().getCnx();
        String qry ="INSERT INTO `sous-metier`(id, `libelle`, `domaine`, `m-id`) VALUES (?,?,?,?)";
         if ((txt_libelle.getText().isEmpty())) {
             formControl("Champ Libelle est obligatoire!");
             
            return;
            
          }
          if ((txt_libelle.getText().matches("[\\W]*"))) {
             formControl("Champ libelle doit avoir seulement des lettres!");
             
            return;
            
          }
           ServiceSousMetier ssm =new ServiceSousMetier();
       List<String> lst=new ArrayList<>();
       lst=ssm.afficherAllNames();
       nom_sousmetier=txt_libelle.getText();
       verif=lst.contains(nom_sousmetier);
        System.out.println(verif);
       if (verif==true){
            JOptionPane.showMessageDialog(null, "Nom doit etre unique");
            clearTextField();
            return;
            
       }
          if ((txt_domaine.getText().isEmpty())) {
             formControl("Champ domaine est obligatoire!");
             
            return;
            
          }
           if ((txt_domaine.getText().matches("[\\W]*"))) {
             formControl("Champ domaine doit avoir seulement des lettres!");
             
            return;
            
          }
        try {
            ServiceMetier sm = new ServiceMetier();
            pst=conn.prepareStatement(qry);
                 pst.setInt(1, 0);
                 
            pst.setString(2, txt_libelle.getText());
            pst.setString(3, txt_domaine.getText());
            pst.setInt(4, sm.getIdByNom(combo_metier.getValue()));
      
            pst.execute();
            UIManager.put("OptionPane.minimumSize",new Dimension(500,200)); 
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
          "Arial", Font.BOLD, 30)));
            JOptionPane.showMessageDialog(null, "Sous metier ajouté avec succés", "Succès!", JOptionPane.INFORMATION_MESSAGE);

            clearTextField();
            updateTable();
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    public void edit_SousMetier(){
              
         ServiceSousMetier ssm =new ServiceSousMetier();
       List<String> lst=new ArrayList<>();
       nom_sousmetier=txt_libelle.getText();
       lst=ssm.afficherAllNamesExcept(nom_sousmetier);
       
       verif=lst.contains(nom_sousmetier);
        System.out.println(verif);
       if (verif==true){
                      UIManager.put("OptionPane.minimumSize",new Dimension(500,200)); 
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
          "Arial", Font.BOLD, 30)));
            JOptionPane.showMessageDialog(null, "Nom doit etre unique");
            clearTextField();
            return;
            
       }
        try {
            conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
           
            String value3 = txt_domaine.getText();
            String value4 = combo_metier.getValue();
            String sql="UPDATE `sous-metier` SET  `domaine`='" + value3 + "' WHERE `id`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            UIManager.put("OptionPane.minimumSize",new Dimension(500,200)); 
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
          "Arial", Font.BOLD, 30)));
            JOptionPane.showMessageDialog(null, "Sous metier modifié avec succés", "Succès!", JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
            updateTable();

                        
        } catch (Exception e) {
                        UIManager.put("OptionPane.minimumSize",new Dimension(500,200)); 
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
          "Arial", Font.BOLD, 30)));
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } 
    }
        public void supprimer(){
        try {
            conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String sql="UPDATE `sous-metier` SET `archive`='" + 1 + "' WHERE `id`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
                        UIManager.put("OptionPane.minimumSize",new Dimension(500,200)); 
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
          "Arial", Font.BOLD, 30)));
            JOptionPane.showMessageDialog(null, "Sous metier supprimé avec succés", "Succès!", JOptionPane.INFORMATION_MESSAGE);
                        clearTextField();

            updateTable();
            

                        
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } 
    }
           @FXML
public void redirectToMetier(ActionEvent event) throws Exception {              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Metier.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    public void comboBoxList(){
          ServiceMetier serviceProjet = new ServiceMetier();
         List<String> metiers = serviceProjet.afficherAllNames();
        ObservableList<String> observableMetiers = FXCollections.observableArrayList(metiers);
        combo_metier.setItems(observableMetiers);
    }
     public void updateTable(){
         
        
        String val = combo_metier.getValue();
        ServiceSousMetier sm = new ServiceSousMetier();
        List<SousMetier> sousmetiers = sm.afficherByIdMetier(val);
        ObservableList<SousMetier> listM=FXCollections.observableArrayList(sousmetiers);
       col_id.setCellValueFactory(new PropertyValueFactory<SousMetier,Integer>("id"));
        col_libelle.setCellValueFactory(new PropertyValueFactory<SousMetier,String>("libelle"));
        col_domaine.setCellValueFactory(new PropertyValueFactory<SousMetier,String>("domaine"));
        table.setItems(listM);
        FilteredList<SousMetier> filteredData= new FilteredList<>(listM,b->true);
  txt_field.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredData.setPredicate( metier ->{
                if(newvalue.isEmpty() || newvalue == null){return true; }
                String search = newvalue.toLowerCase();
                if(metier.getLibelle().toLowerCase().indexOf(search) != -1){
                    return true;
                } else if(metier.getDomaine().toLowerCase().indexOf(search) != -1)  {return true;}
          
                return false;
            });
    });
        SortedList<SousMetier> sortedData= new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
        
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxList();
                col_libelle.prefWidthProperty().bind(table.widthProperty().divide(2)); // w * 1/2
                col_domaine.prefWidthProperty().bind(table.widthProperty().divide(2.02)); // w * 1/4
        
    }    
    
}
