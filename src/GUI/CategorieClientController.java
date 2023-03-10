/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categorie;
import Entities.Evenement;
import Services.ServiceCategorie;
import Services.ServiceCategorie;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class CategorieClientController implements Initializable {

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
    @FXML
    private JFXButton ButtonProjet1;

    /**
     * Initializes the controller class.
     */
    
    
       ServiceCategorie se = new ServiceCategorie();
        List<Categorie > la  = se.afficher();
        int column = 0;
        int row=1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Categorie > listA=FXCollections.observableArrayList(la);
           ListView<Categorie > listView = new ListView<>(listA);
           setFormations(la);
    }    

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
    
    
    
    
    
    
    
    
    
    
    
     public void setFormations(List<Categorie > annonces) {
        flowPane.getChildren().clear();
        for (Categorie  item : la) {
            CardViewCategorie cardView = new CardViewCategorie (item);
        
            
            flowPane.getChildren().add(cardView);

        }
        
        
        
        
        
        
   
}
}
