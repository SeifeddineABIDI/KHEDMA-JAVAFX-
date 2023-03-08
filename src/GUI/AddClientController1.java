/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.Serviceclient;
import Services.Servicefreelancer;
import Entities.User;
import Entities.client;
import Entities.freelancer;
import Services.ServiceUser;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author donia
 */
public class AddClientController1 implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField cin;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField mdp;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField nom;
     Boolean IsEditibale = false ;
     String role = "client";
     Serviceclient sf = new Serviceclient();
     int id ;
    @FXML
    private JFXTextField domaine;
boolean ok = true;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
        public void inflateUI(client place) {

    }
        
                
    

    @FXML
    private void LoadCancel(ActionEvent event) {
        closeStage();
    }
    public void closeStage() {
        ((Stage) adresse.getScene().getWindow()).close();
    }

    @FXML
    private void LoadAddAdmin(ActionEvent event) {
        
      
                String anom = nom.getText() ;
        String aprenom = prenom.getText() ;
        int acin = Integer.parseInt(cin.getText()) ;
        String amail = mail.getText() ;
          int aphone = Integer.parseInt(phone.getText()) ;
        String amdp =  doHashing(mdp.getText() );
        String adr = adresse.getText() ;
        String adomaine = domaine.getText() ;
        if ( anom.isEmpty() || aprenom.isEmpty()  || amail.isEmpty() || amdp.isEmpty() || adr.isEmpty()|| adomaine.isEmpty()   ){
        JOptionPane.showMessageDialog(null, " champs obligatoire !");
        return ;
        }
          if ( amail.isEmpty() || (amail.matches("^(.+)@(.+)$")==false) ){
        JOptionPane.showMessageDialog(null, " Invalid Email");
        return ;
        }
        if ((acin < 10000000 && aphone < 100000000) || (aphone < 10000000 && aphone < 100000000) ){
        JOptionPane.showMessageDialog(null, " champs doit avoir 8 caracteres !");
        }
         if ((acin > 10000000 && aphone > 100000000) || (aphone > 10000000 && aphone > 100000000) ){
        JOptionPane.showMessageDialog(null, " champs doit avoir 8 caracteres !");
        }
         
        if (IsEditibale) {
            handleEditOperation();
            return;
        }    
        client pv = new client(anom, aprenom,acin,adomaine,role, amail, amdp,adr ,aphone) ; 
         sf.add(pv);
         closeStage();
    }
private void handleEditOperation(){
    client us = new client(id ,nom.getText(), prenom.getText(),Integer.parseInt(cin.getText()),domaine.getText(),role ,mail.getText(),mdp.getText(),adresse.getText(),Integer.parseInt(phone.getText())) ;

    System.out.println(us.toString());
    sf.modifier(us);
    JOptionPane.showMessageDialog(null, " Success");
    closeStage();
}

    void infalteUI(client place) {
        nom.setText(place.getNom());
        prenom.setText(place.getPrenom());
        cin.setText(String.valueOf(place.getCin()));
        mail.setText(place.getEmail());
        mdp.setText(place.getMdp());
        adresse.setText(place.getAdresse());
        phone.setText(String.valueOf(place.getTelephone()));
                domaine.setText(place.getDomaine());

        id = place.getId() ;

       IsEditibale = Boolean.TRUE;    }

  
    
    
    public static String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();
 
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
}
