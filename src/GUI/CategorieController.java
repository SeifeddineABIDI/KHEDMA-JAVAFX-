/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categorie;
import Services.ServiceCategorie;
import Utils.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class CategorieController implements Initializable {
    
    
      @FXML
              private Button add_Categorie;
              @FXML
               private Button edit;
                @FXML
                private Button supprimer;

    @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie, Integer> col_id;
    @FXML
      private TableColumn<Categorie, String>  col_nom;
    @FXML
      private TableColumn<Categorie, String> col_type;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_type;
    @FXML
    private TextField txt_id;
    
    
    
    
    int index= -1;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    Services.ServiceCategorie se;
    /**

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
    
    public void clearTextField(){
        txt_id.clear();
        txt_nom.clear();
        txt_type.clear();
        
    }
    
    
    
    
    
    
    
    
      
    
    
        public void redirectToEvenement(ActionEvent event) throws Exception {              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Evenement.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
}
  
    
    
    
    
    
    
    
    

    @FXML
    private void getSelected(MouseEvent event) {
        
         index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_nom.setText(col_nom.getCellData(index).toString());
        txt_type.setText(col_type.getCellData(index).toString());

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
     
    try{
            
            
         conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String value2 = txt_nom.getText();
            String value3 = txt_type.getText();
           
            String sql="UPDATE `categorie` SET `archive`='" + 1 + "' WHERE `id_categorie`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Categorie supprimé");
                        clearTextField();

        
    
    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } }
    
        
       
    
    
    
    
    
    
    
    
    
        
        
    
    

    @FXML
    private void add_Categorie(ActionEvent event) throws Exception{
     
        conn=MyDB.getInstance().getCnx();
        
        
            if (txt_nom.getText().toString().trim().length()==0){
         JOptionPane.showMessageDialog(null, "Textfield can't be empty");
        
     } 
     
     else if (txt_type.getText().toString().trim().length()==0){
          JOptionPane.showMessageDialog(null, "Textfield can't be empty");
     }
     else{ 

        
        
        String qry ="INSERT INTO `categorie`(id_categorie, `nom`, `type`) VALUES (?,?,?)";
        try {
            pst=conn.prepareStatement(qry);
                 pst.setInt(1, 0);

            pst.setString(2, txt_nom.getText());
            pst.setString(3, txt_type.getText());
            
      
            pst.execute(); 
            JOptionPane.showMessageDialog(null, "Categorie ajoutée avec succès");
            clearTextField();
            updateTable();
            
            
    
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        }
   
    }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        public void updateTable(){
        Services.ServiceCategorie sc = new ServiceCategorie();
        List<Categorie> Categories = sc.afficher();
        ObservableList<Categorie> listC=FXCollections.observableArrayList(Categories);
       col_id.setCellValueFactory(new PropertyValueFactory<Categorie,Integer>("id_categorie"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nom"));
        col_type.setCellValueFactory(new PropertyValueFactory<Categorie,String>("type"));
        
        listC=sc.afficherData();
        table.setItems(listC);
    }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    

    @FXML
    private void edit(ActionEvent event) {
        try {
            conn=MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String value2 = txt_nom.getText();
            String value3 = txt_type.getText();
           
            String sql="UPDATE `categorie` SET `nom`='" + value2 + "', `type`='" + value3 + "' WHERE `id_categorie`='" + value1+ "'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modifier");
            clearTextField();
            updateTable();

                        
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

        } 
    }
    

}