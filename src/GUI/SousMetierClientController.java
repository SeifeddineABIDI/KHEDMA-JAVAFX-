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
public class SousMetierClientController implements Initializable {
    
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
    private FlowPane flowPane;

    ServiceSousMetier sm = new ServiceSousMetier();
        
        List<SousMetier> lm  = new ArrayList<>() ;
        int column = 0;
        int row=1;
        
    @FXML
    private void redirecttocompte(ActionEvent event) {
    }

    @FXML
    private void redirecttoProjet(ActionEvent event) {
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
        public void setFormations(List<SousMetier> sousmetiers) {
        flowPane.getChildren().clear();
        for (SousMetier item : lm) {
            CardViewSousMetier CardViewSousMetier = new CardViewSousMetier(item);
            
            flowPane.getChildren().add(CardViewSousMetier);

        }
        }
        @FXML
private void redirectToMetierCardView(ActionEvent event) throws Exception {              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MetierClient.fxml"));
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
        SousMetier sm = new SousMetier();
          CardViewSousMetier cvsm =  new CardViewSousMetier(sm);
          ServiceSousMetier ssm = new ServiceSousMetier();
          
          List<SousMetier> lm =ssm.afficherSmByIdMetier(CurrentMetier.CurrentMetier_id);
         flowPane.getChildren().clear();
        for (SousMetier item : lm) {
            CardViewSousMetier cardView = new CardViewSousMetier(item);
            
            flowPane.getChildren().add(cardView);
          
    }
    
    
}}



