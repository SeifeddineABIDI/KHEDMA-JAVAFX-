/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static Entities.GHAPI.createFolderInRepo;
import static Entities.GHAPI.inviteCollaboratorByEmail;
import Entities.ProjectCard;
import Entities.Projet;
import Entities.CurrentUser;
import Entities.Globals;
import Services.ServiceMetier;
import Services.ServiceProjet;
import GUI.LoginController;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author azers
 */
public class ProjetClientController implements Initializable {

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
    private StackPane ReviewProjectPane;
    private StackPane ModifyProjectPane;
    private StackPane AddProjectPane;
    @FXML
    private AnchorPane addProjectPane;
    @FXML
    private AnchorPane modifyProjectPane;
    @FXML
    private AnchorPane reviewProjectPane;
    @FXML
    private Button addProjectButton;
    @FXML
    private Button ReviewProjectButton;
    @FXML
    private Button ModifyProjectButton;
    @FXML
    private TextField freelancerField;
    @FXML
    private TextField projectNameField;
    private TextField domaineField;
    @FXML
    private Button addprojectbutton;
    @FXML
    private ComboBox<Integer> projectIdComboBox;
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
    private ScrollPane scrollPane;
    @FXML
    private FlowPane projectCardsPane;
    @FXML
    private Button refreshbutton;
    @FXML
    private TextField searchfiled;
    /**
     * Initializes the controller class.
     */
    public ObservableList<Projet> observableProjetList;
    @FXML
    private ComboBox<String> DomaineBox;
    


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        
        
             // Add the FlowPane to the ScrollPane
       

        // Set the vertical scrollbar policy of the ScrollPane
       
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
        try {       
            Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
             Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("5edma");
            stage.setScene(new Scene(root));
            stage.show();
              
    }   catch (IOException ex) {
           System.out.println("Err"+ex.getMessage());
        }
    }


    @FXML
    private void showAddProjectPane(Event event) {
        stackPane.getChildren().forEach(node -> node.setVisible(false));
        addProjectPane.setVisible(true);  
                ServiceMetier serviceMetier = new ServiceMetier();
         List<String> ListMetier = serviceMetier.afficherAllNames();
         System.out.println(ListMetier);
         ObservableList<String> observableMetierNames = FXCollections.observableArrayList(ListMetier);
        DomaineBox.setItems(observableMetierNames);
        //stackPane.getChildren().setAll(addProjectPane);
    }

    
    @FXML
    public void showReviewProjectPane(Event event) {
        
         String searchQuery = searchfiled.getText().trim();

    // Filter the list of all projects using the search query
    ServiceProjet s = new ServiceProjet();
    List<Projet> filteredProjects = s.afficher().stream()
        .filter(p -> 
            p.getClient().contains(searchQuery) || 
            p.getNom().contains(searchQuery) || 
            p.getDomaine().contains(searchQuery) || 
            p.getFreelancer().contains(searchQuery)
            // add more checks for other attributes as needed
        )
        .collect(Collectors.toList());

        
                        reviewProjectPane.getChildren().clear();
                stackPane.getChildren().forEach(node -> node.setVisible(false));
                reviewProjectPane.setVisible(true);
                 
                FlowPane flowPane = new FlowPane();
               
    
    //List<Projet> projets = s.afficher();
 //   ObservableList<Projet> observableProjetList = FXCollections.observableArrayList(projets);

// set the spacing between cards
flowPane.setHgap(10);
flowPane.setVgap(10);

// iterate through each project in the list
for (Projet project : filteredProjects) {
    // create a new ProjectCard with project details
    ProjectCard projectCard = new ProjectCard(project);
         

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

    @FXML
    private void showModifyProjectPane(Event event) {
        
        
        ServiceProjet serviceProjet = new ServiceProjet();
         List<Integer> projectIds = serviceProjet.getAllProjectIds();
        ObservableList<Integer> observableProjectIds = FXCollections.observableArrayList(projectIds);
        projectIdComboBox.setItems(observableProjectIds);
                    stackPane.getChildren().forEach(node -> node.setVisible(false));
        modifyProjectPane.setVisible(true);
        
    }

    @FXML
    private void addproject(ActionEvent event) throws Exception {
        
String Usernom = Globals.currentUser.getCurrentUserName();
/*String email = Globals.currentUser.getEmail();*/
String gUserName = Globals.currentUser.getCurrentUserGithub();
        
     
    String projectName = projectNameField.getText();
    String freelancer = freelancerField.getText();
//    String client = clientField.getText();
    String domaine = DomaineBox.getValue();    

    // Perform input validation
    if (projectName.trim().isEmpty() || freelancer.trim().isEmpty() || domaine.trim().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("Please enter all the required fields");
        alert.showAndWait();
        return;
    }
        ServiceProjet sp= new ServiceProjet();
        
        ///////////////////
       Projet p = new Projet(projectNameField.getText(),domaine,Usernom,freelancerField.getText());
       System.out.println(p);
        sp.add(p);
        String Repo = projectNameField.getText();
        createFolderInRepo(Repo);
        try {
    inviteCollaboratorByEmail(gUserName, "write");
} catch (Exception e) {
    System.err.println("Error inviting collaborator: " + e.getMessage());
}
        projectNameField.clear();
        freelancerField.clear();
        //clientField.clear();
        //domaineField.clear();
        
    }

    @FXML
    private void modifyProjectButtonClicked(ActionEvent event) {
        ServiceProjet s= new ServiceProjet();
    String projectName = modifyProjectNameTextField.getText().trim();
    String projectClient = modifyProjectClientTextField.getText().trim();
    String projectFreelancer = modifyProjectFreelancerTextField.getText().trim();
    String projectDomain = modifyProjectDomainTextField.getText().trim();
      
    if (projectName.isEmpty() || projectClient.isEmpty() || projectFreelancer.isEmpty() || projectDomain.isEmpty() ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("All fields are required");
        alert.showAndWait();
    } else {
        Projet p = new Projet(projectName, projectClient, projectFreelancer, projectDomain);
        int M = projectIdComboBox.getValue();
        System.out.println(M);
        s.modifier(p,M);
        modifyProjectNameTextField.clear();
        modifyProjectClientTextField.clear();
        modifyProjectFreelancerTextField.clear();
        modifyProjectDomainTextField.clear();
    }

    
    }

    @FXML
    public void tableupdate(ActionEvent event) {
          
                FlowPane flowPane = new FlowPane();
                ServiceProjet s = new ServiceProjet();
                List<Projet> projets = s.afficher();
            ObservableList<Projet> observableProjetList = FXCollections.observableArrayList(projets);

// set the spacing between cards
    flowPane.setHgap(10);
    flowPane.setVgap(10);

// iterate through each project in the list
    for (Projet project : projets) {
    // create a new ProjectCard with project details
    ProjectCard projectCard = new ProjectCard(project);
         

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

    /*@FXML
    private void search(ActionEvent event) {
        
        String query = searchfiled.getText().toLowerCase();
    List<Projet> filteredList = projets.stream()
                                          .filter(project -> project.getNom().toLowerCase().contains(query))
                                          .collect(Collectors.toList());
    // Update the UI to display the filtered list of projects
    }*/

    public void search(ActionEvent event) {
    // Get the search query from the search field
    String searchQuery = searchfiled.getText().trim();

    // Filter the list of all projects using the search query
    ServiceProjet s = new ServiceProjet();
    List<Projet> filteredProjects = s.afficher().stream()
        .filter(p -> 
            p.getNom().contains(searchQuery) || 
            p.getDomaine().contains(searchQuery) || 
            p.getFreelancer().contains(searchQuery)
            // add more checks for other attributes as needed
        )
        .collect(Collectors.toList());

    // Call the showReviewProjectPane method with the filtered list of projects
    
    System.out.print(filteredProjects);
    observableProjetList = FXCollections.observableArrayList(filteredProjects);
      //showReviewProjectPane(Event event) {
}
    

}



    

