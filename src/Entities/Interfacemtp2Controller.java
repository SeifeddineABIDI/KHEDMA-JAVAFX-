/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author donia
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import sun.security.util.Length;
import Utils.MyDB;
import Services.Servicefreelancer;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class Interfacemtp2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
   
     @FXML
    private TextField textcode;
    Connection cnx ;
    ResultSet rs ;
    PreparedStatement pst = null ;
      @FXML
    private PasswordField passwordfiled1;

     
    personneservice ps = new personneservice();

    
   @FXML
void change(MouseEvent event) throws SQLException {
    String code = textcode.getText();
    if (verife(code)) {
        // Code correct, récupération de l'email associé
        List<String> emails = getEmails();
        String email = getEmailCode(emails, code);
        if (email != null) {
            // Email trouvé, mise à jour des données utilisateur
            updatepassword(email);
            JOptionPane.showMessageDialog(null, "Le mot de passe a été modifié avec succès !");
        } else {
            JOptionPane.showMessageDialog(null, "Aucune adresse e-mail trouvée pour ce code.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Le code email est incorrect.");
    }
}

private List<String> getEmails() throws SQLException {
    List<String> emails = new ArrayList<>();
    String query = "SELECT Email FROM `code` ";
    cnx = MyDB.getInsatnce().getCnx();
    pst = cnx.prepareStatement(query);
    ResultSet rss = pst.executeQuery();
    while (rss.next()) {
        String email = rss.getString("Email");
        emails.add(email);
    }
    return emails;
}

private String getEmailCode(List<String> emails, String code) {
    String email = null;
    int i = 0;
    while (i < emails.size() && email == null) {
        String query = "SELECT Email FROM `code` WHERE email = ? AND codeEmail = ?";
        try {
            cnx = MyDB.getInsatnce().getCnx();
            pst = cnx.prepareStatement(query);
            pst.setString(1, emails.get(i));
            pst.setInt(2, Integer.parseInt(code));
            ResultSet rss = pst.executeQuery();
            if (rss.next()) {
                email = rss.getString("email");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        i++;
    }
    return email;
}
public void updatepassword(String email) {
    try {
        String query = "UPDATE user SET password=? WHERE email=?";
        String pa = passwordfiled1.getText();
        cnx = MyDB.getInsatnce().getCnx();
        pst = cnx.prepareStatement(query);
        pst.setString(1, passwordfiled1.getText()); // mettre à jour le champ "password" avec la valeur saisie dans le champ de mot de passe
        pst.setString(2, email); // filtrer les enregistrements à mettre à jour en utilisant l'adresse e-mail
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Le mot de passe a été mis à jour avec succès !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
public boolean verife(String codeEmail) {
    List<String> emails1 = new ArrayList<>();
    int verife = 0;

    String query = "SELECT * FROM `code` ";
    try {
        cnx = MyDB.getInsatnce().getCnx();
        pst = cnx.prepareStatement(query);
        ResultSet rss = pst.executeQuery();
        while (rss.next()) {
            int x = rss.getInt(1);
            String email = rss.getString("Email");
            emails1.add(email);
            if (x == Integer.parseInt(textcode.getText())) {
                verife++;
            }
        }
        System.out.println(emails1);
        return (verife == 1);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
