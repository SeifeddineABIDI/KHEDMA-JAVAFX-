/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import workshop3a24.Entities.Projet;
import workshop3a24.Entities.Tache;
import workshop3a24.Services.ServiceProjet;
import workshop3a24.Services.ServiceTache;

/**
 * FXML Controller class
 *
 * @author azers
 */
public class ShowtasksController implements Initializable {

    @FXML
    private TableView<Tache> tasktable;
    @FXML
    private TableColumn<Tache, Integer> idColumn;
    @FXML
    private TableColumn<Tache, Integer> projectIdColumn;
    @FXML
    private TableColumn<Tache, String> statusColumn;
    @FXML
    private TableColumn<Tache, String> nameColumn;
    @FXML
    private TableColumn<Tache, String> filesColumn;
    @FXML
    private TableColumn<Tache, String> descriptionColumn;
    @FXML
    private TableColumn<Tache, Integer> priorityColumn;
    @FXML
    private TableColumn<Tache, Integer> estimatedTimeColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceTache s = new ServiceTache();
    List<Tache> taches= s.afficher();
    //System.out.print(taches);
    ObservableList<Tache> observabletasksList = FXCollections.observableArrayList(taches);
    System.out.println(observabletasksList);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));       
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        filesColumn.setCellValueFactory(new PropertyValueFactory<>("Files"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        estimatedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("EstimatedTime"));
    
    
        tasktable.setItems(observabletasksList);
        // TODO
    }    
    
}
