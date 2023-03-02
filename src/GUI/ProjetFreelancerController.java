/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.ProjectCard;
import Entities.ProjectCardFreelancer;
import Entities.Projet;
import Services.ServiceProjet;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author azers
 */
public class ProjetFreelancerController implements Initializable {

    @FXML
    private AnchorPane anch;
    @FXML
    private Button ButtonCompte;
    @FXML
    private Button ButtonProjet;
    @FXML
    private Button ButtonMetier;
    @FXML
    private Button ButtonAnnonce;
    @FXML
    private Button ButtonEvenement;
    @FXML
    private Button ButtonSignOut;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane addProjectPane;
    @FXML
    private TextField projectNameField;
    @FXML
    private TextField freelancerField;
    @FXML
    private TextField domaineField;
    @FXML
    private Button addprojectbutton;
    @FXML
    private AnchorPane modifyProjectPane;
    @FXML
    private ComboBox<?> projectIdComboBox;
    @FXML
    private TextField modifyProjectNameTextField;
    @FXML
    private TextField modifyProjectFreelancerTextField;
    @FXML
    private TextField modifyProjectDomainTextField;
    @FXML
    private TextField modifyProjectClientTextField;
    @FXML
    private Button modifyProjectButton;
    @FXML
    private AnchorPane reviewProjectPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane projectCardsPane;
    @FXML
    private Button ReviewProjectButton;
    @FXML
    private Button ModifyProjectButton;
    @FXML
    private Button refreshbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void addproject(ActionEvent event) {
    }

    @FXML
    private void modifyProjectButtonClicked(ActionEvent event) {
    }


    @FXML
    private void tableupdate(ActionEvent event) {
    }

    @FXML
    private void ShowTasksList(ActionEvent event) {
    }

    @FXML
    private void showProjectList(ActionEvent event) {

               
                reviewProjectPane.getChildren().clear();
                stackPane.getChildren().forEach(node -> node.setVisible(false));
                reviewProjectPane.setVisible(true);
                 
                FlowPane flowPane = new FlowPane();
                ServiceProjet s = new ServiceProjet();
                List<Projet> projets = s.afficherFreelancer();
    ObservableList<Projet> observableProjetList = FXCollections.observableArrayList(projets);

// set the spacing between cards
flowPane.setHgap(10);
flowPane.setVgap(10);

// iterate through each project in the list
for (Projet project : projets) {
    // create a new ProjectCard with project details
    ProjectCardFreelancer projectCard = new ProjectCardFreelancer(project);
         

    // add the ProjectCard to the FlowPane
    flowPane.getChildren().add(projectCard);
}

// add the FlowPane to the reviewProjectPane
reviewProjectPane.getChildren().add(flowPane);
 // wrap the FlowPane in a ScrollPane
    ScrollPane scrollPane = new ScrollPane(flowPane);

    // set the preferred size of the ScrollPane
    scrollPane.setPrefSize(935, 504);

    // add the ScrollPane to the reviewProjectPane
    reviewProjectPane.getChildren().add(scrollPane);
    }

    }
    

