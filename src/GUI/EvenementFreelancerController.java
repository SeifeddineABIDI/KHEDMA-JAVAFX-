/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import Entities.Evenement;
import Services.ServiceEvenement;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class EvenementFreelancerController implements Initializable {

    @FXML
    private AnchorPane anch;
    @FXML
    private JFXButton ButtonCompte;
    @FXML
    private JFXButton ButtonProjet;
    @FXML
    private JFXButton ButtonMetier;
    @FXML
    private JFXButton ButtonEvenement ;
    @FXML
    private JFXButton ButtonAnnonce;
    @FXML
    private JFXButton ButtonSignOut;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane flowPane;
    @FXML
    private JFXButton ButtonProjet1;
    
        @FXML
    private ImageView image_view;

    @FXML
    private JFXTextField txt_keyword;
    @FXML
    private Label filr_path;

    /**
     * Initializes the controller class.
     */
     ServiceEvenement se = new ServiceEvenement();
        List<Evenement > la  = se.afficher();
        int column = 0;
        int row=1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Evenement > listA=FXCollections.observableArrayList(la);
           ListView<Evenement > listView = new ListView<>(listA);
           setFormations(la);
    }    

    @FXML
    private void redirecttocompte(ActionEvent event) {
        try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("freelancerPanel.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void redirecttoProjet(ActionEvent event) {
         try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjetFreelancer.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void redirecttometier(ActionEvent event) {
                 try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MetierClientChart.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    private void redirectToEvenement (ActionEvent event) {
         try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Evenement.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
       
    }

    @FXML
    private void redirecttoevenement(ActionEvent event) {
    }
 private Stage getStage() {
        return (Stage) image_view.getScene().getWindow();
    }




    private void closeStage(ActionEvent event) {
        getStage().close();
    }
    @FXML
    private void signout(ActionEvent event) {
        
        
         try {
                  final Node source = (Node) event.getSource();

          
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root)); 
            stage.show();
             closeStage( event);
    } catch(Exception e) {
        e.printStackTrace();
    }

   
    }
    
    
    
    
    
    
    
    
    
    
    
    
        @FXML
    private void redirectToAnnonce(ActionEvent event) {
           try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Annonce.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
    }


     public void setFormations(List<Evenement > annonces) {
        flowPane.getChildren().clear();
        for (Evenement  item : la) {
            CardViewEvenement  cardView = new CardViewEvenement (item);
        
            
            flowPane.getChildren().add(cardView);

        }
        
        
        
        
        
        
   
}
     
     
     
     
     

     
     
     
     
     
     
     
     
        @FXML
    private void insertImage(ActionEvent event) {
         FileChooser open = new FileChooser();
        
        Stage stage = (Stage)anch.getScene().getWindow();
        
        File file = open.showOpenDialog(stage);
        
        if(file != null){
            
            String path = file.getAbsolutePath();
            
            path = path.replace("\\", "\\\\");
            
            filr_path.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);
            
            image_view.setImage(image);
            
        }else{
            
            System.out.println("NO DATA EXIST!");
            
        }
    }
    
    
    
    
    
       @FXML
    

    private void redirectToEvenements (ActionEvent event) {
         try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EvenementClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
       
    }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}













