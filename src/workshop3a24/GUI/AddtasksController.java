/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import workshop3a24.Entities.CurrentProjectData;
import workshop3a24.Entities.Tache;
import workshop3a24.Services.ServiceTache;

/**
 * FXML Controller class
 *
 * @author azers
 */
public class AddtasksController implements Initializable {

    @FXML
    private TextField tasknameField;
    private TextField statusField;
    @FXML
    private TextField filesField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField priorityField;
    @FXML
    private TextField estimatedTimeField;
    @FXML
    private Button addTaskButton;
    @FXML
    private ComboBox<?> statusComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addTask(ActionEvent event) {
        int D = CurrentProjectData.currentProjectId;
    String taskName = tasknameField.getText();
    String taskDescription = descriptionField.getText();
    String taskfiles = filesField.getText();
    String taskStatus = (String) statusComboBox.getValue();
    String taskPriority = priorityField.getText();
    String taskDuration = estimatedTimeField.getText();
  
    // Perform input validation
    if (taskName.trim().isEmpty() || taskDescription.trim().isEmpty() || taskDuration.trim().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("Please enter all the required fields");
        alert.showAndWait();
        return;
    }
    
    int estimatedTime;
    try {
        estimatedTime = Integer.parseInt(taskDuration);
    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("Estimated time should be a valid integer");
        alert.showAndWait();
        return;
    }
     int priority;
    try {
        priority = Integer.parseInt(taskPriority);
    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("Priority should be an integer");
        alert.showAndWait();
        return;
    }


    ServiceTache st = new ServiceTache();
    Tache t = new Tache(D,taskName,taskStatus,taskfiles, taskDescription, taskPriority, estimatedTime);  
    System.out.print(t);
    st.add(t);
         
    tasknameField.clear();
    descriptionField.clear();
    filesField.clear();
    priorityField.clear();
    estimatedTimeField.clear();

}

    }
    

