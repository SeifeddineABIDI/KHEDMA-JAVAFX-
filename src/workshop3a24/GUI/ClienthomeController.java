package workshop3a24.GUI;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import workshop3a24.Entities.Projet;
import workshop3a24.Services.ServiceProjet;
import org.controlsfx.validation.ValidationSupport;
import workshop3a24.Entities.CurrentProjectData;
import workshop3a24.Entities.Tache;
import workshop3a24.Services.ServiceTache;


public class ClienthomeController {
    
    @FXML
    private StackPane stackPane;
    
    @FXML
    private StackPane addProjectPane;
    
    @FXML
    private StackPane viewProjectsPane;
    
    @FXML
    private StackPane modifyProjectPane;
    
    private StackPane dashboardPane;
    @FXML
    private TextField projectNameField;
    @FXML
    private TextField freelancerField;
    @FXML
    private TextField domaineField;
    @FXML
    private TableView<Projet> projectsTable;
    @FXML
    private TableColumn<Projet, Integer> IDColumn;
    @FXML
    private TableColumn<Projet, String> projectNameColumn;
    @FXML
    private TableColumn<Projet, String> domainColumn;
    @FXML
    private TableColumn<Projet, String> FreelancerColumn;
    @FXML
    private TableColumn<Projet, String> ClientrColumn;
    @FXML
    private TableColumn<Projet, Void> TaskColumn;
    @FXML
    private TableColumn<Projet, Void> deleteColumn;
    @FXML
    private TextField modifyProjectIdTextField;
    @FXML
    private TextField modifyProjectNameTextField;
    @FXML
    private TextField modifyProjectFreelancerTextField;
    @FXML
    private TextField modifyProjectDomainTextField;
    @FXML
    private Button modifyProjectButton;
    @FXML
    private Button refreshbutton;
    @FXML
    private TextField clientField;
    private StackPane deleteProjectPane;
    @FXML
    private TextField modifyProjectClientTextField;
    
    private final ValidationSupport validationSupport = new ValidationSupport();
    
    @FXML
    private Button addprojectbutton;
    private StackPane taskPane;
    @FXML
    private TableColumn<Projet, Void> addTaskColumn;
    @FXML
    private ComboBox<Integer> projectIdComboBox;
   
    
    
    
    
   
     public void initialize() {
         
          deleteColumn.setCellFactory(column -> new TableCell<Projet, Void>() {
              
              
           private final ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/delete.png")));
          
            
            private final Button deleteButton = new Button("", deleteIcon);
            

            {   
                
                deleteIcon.setFitWidth(24); 
                deleteIcon.setFitHeight(24);
                deleteButton.setBackground(null);
                deleteButton.setOnAction(event -> {
                    Projet project = getTableView().getItems().get(getIndex());
                    ServiceProjet s= new ServiceProjet();
                    ServiceTache sp= new ServiceTache();
                    sp.supprimer(Integer.toString(project.getId()));
                    s.supprimer(project.getNom());
                  
                    refreshbutton(new ActionEvent());
                    
                     
                });
            }
            

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });
         
          
          
          
          
          
          
          
           TaskColumn.setCellFactory(column -> new TableCell<Projet, Void>() {
            private final ImageView eyeIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/eye.png")));
            private final Button taskButton = new Button("", eyeIcon);

            {
                
                 eyeIcon.setFitWidth(24); 
                eyeIcon.setFitHeight(24);
                taskButton.setBackground(null);
                taskButton.setOnAction(event -> {
                     try {
            Projet project = getTableView().getItems().get(getIndex());
            CurrentProjectData.currentProjectId = project.getId();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Showtasks.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
                    
                     
                });
            }
            

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(taskButton);
                }
            }
        });
          
            addTaskColumn.setCellFactory(column -> new TableCell<Projet, Void>() {
                 private final ImageView addIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/plus.png")));
            private final Button addtaskButton = new Button("", addIcon);

            {
                
                addIcon.setFitWidth(24); 
               addIcon.setFitHeight(24);
                addtaskButton.setBackground(null);
                addtaskButton.setOnAction(event -> {
                     try {
            Projet project = getTableView().getItems().get(getIndex());
            CurrentProjectData.currentProjectId = project.getId();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Addtasks.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
                    
                     
                });
            }
            

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(addtaskButton);
                }
            }
        });
            
            
                   
          
          

    
   
          
         
     }
    
    
    
    @FXML
    void showAddProjectPane(ActionEvent event) {
        stackPane.getChildren().forEach(node -> node.setVisible(false));
        addProjectPane.setVisible(true);
    }

    @FXML
    void showViewProjectsPane(ActionEvent event) {
        stackPane.getChildren().forEach(node -> node.setVisible(false));
        viewProjectsPane.setVisible(true);
        refreshbutton(new ActionEvent());
    }

    @FXML
    void showModifyProjectPane(ActionEvent event) {
        
          ServiceProjet serviceProjet = new ServiceProjet();
         List<Integer> projectIds = serviceProjet.getAllProjectIds();
        ObservableList<Integer> observableProjectIds = FXCollections.observableArrayList(projectIds);
        projectIdComboBox.setItems(observableProjectIds);
        stackPane.getChildren().forEach(node -> node.setVisible(false));
        modifyProjectPane.setVisible(true);
    }

       void showDashboardPane(ActionEvent event) {
        stackPane.getChildren().forEach(node -> node.setVisible(false));
        taskPane.setVisible(true);
    }
    private void showDeletePane(ActionEvent event) {
                stackPane.getChildren().forEach(node -> node.setVisible(false));
        deleteProjectPane.setVisible(true);
    }
    
    void modifyProjectIDButtonClicked(ActionEvent event) {

    
}
    @FXML
void modifyProjectButtonClicked(ActionEvent event) {
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
void refreshbutton(ActionEvent event) {
    
        ServiceProjet s = new ServiceProjet();
    List<Projet> projets = s.afficher();
    ObservableList<Projet> observableProjetList = FXCollections.observableArrayList(projets);
    System.out.println(observableProjetList);
       IDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    projectNameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
    domainColumn.setCellValueFactory(new PropertyValueFactory<>("domaine"));
    FreelancerColumn.setCellValueFactory(new PropertyValueFactory<>("freelancer"));
    ClientrColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
    
    
        projectsTable.setItems(observableProjetList);
       
    
}

    @FXML
    private void addproject(ActionEvent event) {
        
        
    String projectName = projectNameField.getText();
    String freelancer = freelancerField.getText();
    String client = clientField.getText();
    String domaine = domaineField.getText();
    

    // Perform input validation
    if (projectName.trim().isEmpty() || freelancer.trim().isEmpty() || client.trim().isEmpty() || domaine.trim().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("Please enter all the required fields");
        alert.showAndWait();
        return;
    }
        ServiceProjet sp= new ServiceProjet();
       Projet p = new Projet(projectNameField.getText(), clientField.getText(), freelancerField.getText(),domaineField.getText());
       
        sp.add(p);
        projectNameField.clear();
        freelancerField.clear();
        clientField.clear();
        domaineField.clear();
        
    }

  

 
}