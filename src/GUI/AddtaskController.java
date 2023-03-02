/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.CurrentProjectData;

import Entities.Tache;
import Services.ServiceTache;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author azers
 */

public class AddtaskController implements Initializable {

    @FXML
    private TextField tasknameField;
    private TextField statusField;
    private TextField filesField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField priorityField;
    @FXML
    private TextField estimatedTimeField;
    @FXML
    private Button addTaskButton;
    //private ComboBox<?> statusComboBox;

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
    //String taskfiles = filesField.getText();
    //String taskStatus = (String) statusComboBox.getValue();
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
    String Taskstatus = "TODO";
    Tache t = new Tache(D,taskName,Taskstatus,taskDescription, taskPriority, estimatedTime);  
    System.out.print(t);
    st.add(t);
         
    tasknameField.clear();
    descriptionField.clear();
    //filesField.clear();
    priorityField.clear();
    estimatedTimeField.clear();

}
    
    /*private void handleUploadButtonAction() {
        // Create a file chooser object and configure it
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a File");

        // Show the file chooser dialog and get the selected file
        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Update the label to display the selected file name
            System.out.print(selectedFile.getAbsolutePath());
            String Pathtofile = selectedFile.getAbsolutePath();
               try {
            createFileInRepo(Pathtofile);
        } catch (Exception e) {
            e.printStackTrace();
        }
            // TODO: upload the file to the server or perform some other action
        }
    }*/
    

    }

    
