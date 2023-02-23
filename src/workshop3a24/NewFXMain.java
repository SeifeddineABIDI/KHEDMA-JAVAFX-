/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
            Parent root=FXMLLoader.load(getClass().getResource("../workshop3a24/GUI/LoginPage.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("5edma");
            primaryStage.setScene(scene);
                    Image icon = new Image(getClass().getResourceAsStream("../images/5edma.png"));
        primaryStage.getIcons().add(icon);
            primaryStage.show();

            
        } catch (IOException ex) {
            System.out.println("Err"+ex.getMessage());
        }
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
