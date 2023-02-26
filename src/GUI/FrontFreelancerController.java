/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class FrontFreelancerController {

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
    private TextField txt_id;

    @FXML
    void redirectToAnnonce(ActionEvent event) {

    }

    @FXML
    void redirecttoProjet(ActionEvent event) {

    }

    @FXML
    void redirecttocompte(ActionEvent event) {

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
           
    } catch(Exception e) {
        e.printStackTrace();
    }

    }

    @FXML
    void signout(ActionEvent event) {

    }

}
