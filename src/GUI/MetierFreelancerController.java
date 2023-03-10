/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Metier;
import Entities.SingleUser;
import Services.ServiceMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Safe
 */
public class MetierFreelancerController implements Initializable {
    
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
    private ScrollPane scrollPane;
    @FXML
    public FlowPane flowPane;

    ServiceMetier sm = new ServiceMetier();
        
        List<Metier> lm  = sm.afficher();
        int column = 0;
        int row=1;
        
    @FXML
    private void redirecttocompte(ActionEvent event) {
          try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientPanel.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void redirecttoProjet(ActionEvent event) {
        SingleUser su = new SingleUser();
        String role= su.getUser().getRole().toString();
        System.out.println(role );
        if (role=="Freelancer"){
              try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjetFreelancer.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
        }
        else{
          try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjetClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
        }
    }

    @FXML
    private void redirecttometier(ActionEvent event) {
    }

    @FXML
    private void redirectToAnnonce(ActionEvent event) {
          try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnnonceClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void redirecttoevenement(ActionEvent event) {
      try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EvenementClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }}

    @FXML
    private void signout(ActionEvent event) {
              try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
        public void setFormations(List<Metier> metiers) {
        flowPane.getChildren().clear();
        for (Metier item : lm) {
            CardView cardView = new CardView(item);
            
            flowPane.getChildren().add(cardView);

        }
        }
        @FXML
private void redirectToMetierChart(ActionEvent event) throws Exception {              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MetierClientChart.fxml"));
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
           ObservableList<Metier> listM=FXCollections.observableArrayList(lm);
           ListView<Metier> listView = new ListView<>(listM);
           setFormations(lm);
    }
    
    
}



