/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Metier;
import Services.ServiceMetier;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FrontFreelancerController implements Initializable  {

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
    private ScrollPane scroll_pane;

    @FXML
    private VBox vbox;
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
 @FXML
 private void getcard() throws IOException{
    
      ServiceMetier sm= new ServiceMetier();
        List<String> list = new ArrayList<>();
        list =sm.afficherAllNames();
        for (String metier : list) {
          
    FXMLLoader loader = new FXMLLoader(getClass().getResource("CardView.fxml"));
    Node cardView = loader.load();
            
    
    // Get references to the elements inside the CardView layout
    Label card_nom = (Label) loader.getNamespace().get("card_nom");
    Label card_type = (Label) loader.getNamespace().get("card_type");
            System.out.println(metier);
    // Set the content of the elements based on the data for this CardView
    card_nom.setText(metier);
   // card_type.setText(metier.getDescription());
    
    // Add the loaded CardView layout to the container in SceneBuilder
    vbox.getChildren().add(cardView);
}

// Set the VBox container as the content of the ScrollPane
scroll_pane.setContent(vbox);

    }
     
 
    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        try {
            getcard();
        } catch (IOException ex) {
            Logger.getLogger(FrontFreelancerController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}