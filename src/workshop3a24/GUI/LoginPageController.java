/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package workshop3a24.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author azers
 */
public class LoginPageController implements Initializable {

    @FXML
    private TextField usernamefield;
    @FXML
    private TextField passwordfield;
    @FXML
    private Button loginbutton;
    @FXML
    private TextField errorfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
public void login(ActionEvent event) {
    
    String username = usernamefield.getText();
    String password = passwordfield.getText();
    final String CLIENT_USERNAME = "";
    final String CLIENT_PASSWORD = "";
    final String FREELANCER_USERNAME = "freelancer";
    final String FREELANCER_PASSWORD = "freelancer";
    
     if (username.equals(CLIENT_USERNAME) && password.equals(CLIENT_PASSWORD)) {
        // Load the client home FXML file if the entered credentials match the client username/password
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("clienthome.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
                        stage.setTitle("5edma");
           
        Image icon = new Image(getClass().getResourceAsStream("5edma.png"));
       
        stage.getIcons().add(icon);
            stage.show();
            
            ((Stage) usernamefield.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else if (username.equals(FREELANCER_USERNAME) && password.equals(FREELANCER_PASSWORD)) {
        // Load the freelancer home FXML file if the entered credentials match the freelancer username/password
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("freelancerhome.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) usernamefield.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        // Display an error message if the entered credentials do not match either username/password
        //errorfield.setText("Invalid username or password.");
    }
    
    
}
    
  
        
    
    
}


