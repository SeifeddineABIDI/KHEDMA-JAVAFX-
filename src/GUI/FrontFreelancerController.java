/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.SingleUser;
import Entities.User;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class FrontFreelancerController  implements Initializable {

    @FXML
    private AnchorPane anch;

    @FXML
    private JFXButton ButtonCompte;

    @FXML
    private JFXButton ButtonProjet;

    @FXML
    private JFXButton ButtonMetier;

    @FXML
    private JFXButton ButtonAnnonce;

    @FXML
    private JFXButton ButtonEvenement;

    @FXML
    private JFXButton ButtonSignOut;

    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private VBox vbox;
    @FXML
    private Circle UserLogo;

    @FXML
    void redirectToAnnonce(ActionEvent event) {

    }

    @FXML
    void redirecttoProjet(ActionEvent event) {
    
                  try {
                  final Node source = (Node) event.getSource();

          FXMLLoader fxmlLoader=null;
      
                 fxmlLoader = new FXMLLoader(getClass().getResource("ProjetFreelancer.fxml"));
        
    
      // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjetClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } 
          catch(Exception e) {
        e.printStackTrace();
    }

    }

    @FXML
    void redirecttocompte(ActionEvent event) {
              try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("freelancerPanel.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } 
          catch(Exception e) {
        e.printStackTrace();
    }
        

    }

    @FXML
    void redirecttoevenement(ActionEvent event) {
  

    }

    @FXML
    void redirecttometier(ActionEvent event) {
        
          try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Metier.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } 
          catch(Exception e) {
        e.printStackTrace();
    }

    }

    @FXML
    void signout(ActionEvent event) {

    }
/*public void loadData(){
SingleUser hold = SingleUser.getInstance();
          User u = hold.getUser(); 
              Image img =new Image(u.getImage());
                      UserLogo.setFill(new ImagePattern(img));


    System.out.println(u.getImage());
}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
loadData();
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

