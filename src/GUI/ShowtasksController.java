package GUI;

import Entities.Tache;
import Services.ServiceProjet;
import Services.ServiceTache;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;



public class ShowtasksController implements Initializable {
    
        @FXML private ListView<String> todoListView;
    @FXML private ListView<String> doingListView;
    @FXML private ListView<String> doneListView;
    @FXML private ListView<String> reviewingListView;
    @FXML private ListView<String> acceptedListView;
    
    private String dragItem;
    ServiceTache serviceTache = new ServiceTache();
    List<Tache> tasks = serviceTache.afficher();
@Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create some dummy tasks
        



ObservableList<String> todoList = FXCollections.observableArrayList();
ObservableList<String> doingList = FXCollections.observableArrayList();
ObservableList<String> doneList = FXCollections.observableArrayList();
ObservableList<String> reviewList = FXCollections.observableArrayList();
ObservableList<String> acceptedList = FXCollections.observableArrayList();


for (Tache task : tasks) {
    if (task.getStatus().equals("TODO")) {
        todoList.add(task.getNom());
    }
    if (task.getStatus().equals("DOING")) {
        doingList.add(task.getNom());
    }
    if (task.getStatus().equals("DONE")) {
        doneList.add(task.getNom());
    }
    if (task.getStatus().equals("REVIEWING")) {
        reviewList.add(task.getNom());
    }
    if (task.getStatus().equals("ACCEPTED")) {
        acceptedList.add(task.getNom());
    }
}
todoListView.setItems(todoList);
doingListView.setItems(doingList);
doneListView.setItems(doneList);
reviewingListView.setItems(reviewList);
acceptedListView.setItems(acceptedList);
        
        
        
        todoListView.setOnDragDetected(this::handleDragDetected);
        
        
doingListView.setOnDragDetected(this::handleDragDetected);
doneListView.setOnDragDetected(this::handleDragDetected);
reviewingListView.setOnDragDetected(this::handleDragDetected);


todoListView.setOnDragOver(this::handleDragOver);
doingListView.setOnDragOver(this::handleDragOver);
doneListView.setOnDragOver(this::handleDragOver);
reviewingListView.setOnDragOver(this::handleDragOver);


todoListView.setOnDragDropped(this::handleDragDropped);
doingListView.setOnDragDropped(this::handleDragDropped);
doneListView.setOnDragDropped(this::handleDragDropped);
reviewingListView.setOnDragDropped(this::handleDragDropped);

acceptedListView.setDisable(true);

    }

    
    

    @FXML
    private void handleDragDetected(MouseEvent event) {
        ListView<String> listView = (ListView<String>) event.getSource();
        dragItem = listView.getSelectionModel().getSelectedItem();
        if (dragItem != null) {
            Dragboard dragboard = listView.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(dragItem);
            dragboard.setContent(content);
            event.consume();
        }
        
    }

    @FXML
    private void handleDragOver(DragEvent event) {
          if (event.getGestureSource() != event.getSource() && event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.MOVE);
            event.consume();
        }
    }

    @FXML
private void handleDragDropped(DragEvent event) {
    
    ListView<String> sourceListView = (ListView<String>) event.getGestureSource();
    ListView<String> targetListView = (ListView<String>) event.getGestureTarget();
    
    // Get the dropped task's name
    Dragboard dragboard = event.getDragboard();
    String taskName = dragboard.getString();
    
    // Find the Tache object that corresponds to the dropped task
    Tache tache = null;
    for (Tache task : tasks) {
        if (task.getNom().equals(taskName)) {
            tache = task;
            break;
        }
    }
    
    if (tache != null) {
        // Update the status of the Tache object based on the target list view
        switch (targetListView.getId()) {
            case "todoListView":
                tache.setStatus("TODO");
               
                break;
            case "doingListView":
                tache.setStatus("DOING");
                
                break;
            case "doneListView":
                tache.setStatus("DONE");
                break;
            case "reviewingListView":
                tache.setStatus("REVIEWING");
                break;
            case "acceptedListView":
                tache.setStatus("ACCEPTED");
                break;
        }
        
        // Update the Tache object in the database
        serviceTache.modifier(tache);
        
        // Remove the task from the source list view
        sourceListView.getItems().remove(taskName);
        
        // Add the task to the target list view
        targetListView.getItems().add(taskName);
        
        event.setDropCompleted(true);
    }
    
    event.consume();
}
    private ServiceTache getServiceTache() {
    return new ServiceTache();
}
}

   
