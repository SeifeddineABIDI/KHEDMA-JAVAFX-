/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author azers
 */

import Services.ServiceProjet;
import GUI.ProjetClientController;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ProjectCard extends VBox {
    
    ActionEvent event = new ActionEvent();
    
    
      public ProjectCard(Projet P) {
        ProjetClientController r = new ProjetClientController();
        // Set up card properties
        setPadding(new Insets(20));
        setSpacing(10);
        setAlignment(Pos.TOP_LEFT);
        setPrefSize(920, 150);
        setBackground(new Background(new BackgroundFill(Color.web("#00B4D8"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Add a drop shadow effect to the card
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        setEffect(dropShadow);

        // Add a border to the ProjectCard
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        // Create labels for project details
        Label nameLabel = new Label("Name: " + P.getNom());
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16;");
        Label domainLabel = new Label("Domain: " + P.getDomaine());
        domainLabel.setStyle("-fx-font-size: 14;");
        Label freelancerLabel = new Label("Freelancer: " + P.getFreelancer());
        freelancerLabel.setStyle("-fx-font-size: 14;");
        Label clientLabel = new Label("Client: " + P.getClient());
        clientLabel.setStyle("-fx-font-size: 14;");

        // Create a button for deleting the project
        Button deleteButton = new Button();
    Image deleteImage = new Image("Images/delete.png");
    ImageView deleteImageView = new ImageView(deleteImage);
    deleteImageView.setFitWidth(16);
    deleteImageView.setFitHeight(16);
    deleteButton.setGraphic(deleteImageView);
        deleteButton.setStyle("-fx-background-color: transparent;");
        
deleteButton.setOnAction(e -> {
    String D = P.getNom();
    ServiceProjet s = new ServiceProjet();

    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog");
    alert.setHeaderText("Delete project: " + D + "?");
    alert.setContentText("Are you sure you want to delete this project?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK){
        s.supprimer(D);
       
        System.out.println("Deleting project: " + D);
    }
});
                Button addtaskButton = new Button("Add Tasks");
    addtaskButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14;");
    addtaskButton.setOnAction(e -> {
         try {
        // Load the FXML file
        CurrentProjectData.currentProjectId = P.getId();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Addtask.fxml"));
        Parent root = loader.load();

        // Create a new scene with the FXML file contents
        Scene scene = new Scene(root);

        // Create a new stage for the scene
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Task");

        // Show the new stage
        stage.show();
    } catch (IOException ex) {
        System.err.println("Error loading addtask.fxml: " + ex.getMessage());
    }
        // TODO: Implement logic for viewing more details about the project
        System.out.println("Viewing more details for project: " + P.getNom());

    });
    Button viewTasksButton = new Button("View Tasks");
viewTasksButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14;");
viewTasksButton.setOnAction(e -> {
    try {
        CurrentProjectData.currentProjectId = P.getId();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ShowtasksClient.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
});
Button githubButton = new Button("Review Tasks on github");
githubButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14;");
githubButton.setOnAction(e -> {
    
    String Repo= P.getNom();
    String url = "https://github.com/Azer-prog/TestAPI/tree/main/"+Repo;
    try {
        Desktop.getDesktop().browse(new URI(url));
    } catch (IOException | URISyntaxException ex) {
        ex.printStackTrace();
    }
});

        // Create an HBox for the labels and button
        HBox detailsBox = new HBox(10);
        detailsBox.setAlignment(Pos.CENTER_LEFT);
        detailsBox.getChildren().addAll(nameLabel, domainLabel, freelancerLabel, clientLabel, deleteButton,addtaskButton,viewTasksButton,githubButton);

        // Add labels and button to card
        getChildren().add(detailsBox);
    }

  
}