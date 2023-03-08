/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Safe
 */
public class FrontClientController {

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
    private void redirecttocompte(ActionEvent event) {
              try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clientPanel.fxml"));
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
    private void redirecttoProjet(ActionEvent event) {
                      try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjetClient.fxml"));
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
    private void redirecttometier(ActionEvent event) {
    }

    @FXML
    private void redirectToAnnonce(ActionEvent event) {
    }

    @FXML
    private void redirecttoevenement(ActionEvent event) {
    }

    @FXML
    private void signout(ActionEvent event) {
    }
    
}
