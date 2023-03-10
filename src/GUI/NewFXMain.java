/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image ; 
import javafx.scene.layout.VBox;
import Entities.Classification;

/**
 *
 * @author DELL
 */
public class NewFXMain extends Application {
        private double xOffset = 0; 
        private double yOffset = 0;
        Image image ;
    @Override
    public void start(Stage primaryStage) {
            
        try {
            
            Parent p = FXMLLoader.load(getClass().getResource("AnnonceClient.fxml"));
            
            
            
            primaryStage.initStyle(StageStyle.DECORATED);

             image = new Image("./images/5edma.png") {} ;
          Scene scene = new Scene(p);
         
            primaryStage.getIcons().add(image);
            primaryStage.setTitle("5EDMA");
            primaryStage.setFullScreen(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
