/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import Entities.freelancer;
import Utils.MyDB;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Safe
 */
public class SousMetierUsersController implements Initializable {

    @FXML
    private AnchorPane anch;
    @FXML
    private JFXButton ButtonCompte;
    @FXML
    private JFXButton ButtonProjet;
    @FXML
    private JFXButton ButtonMetier;
    @FXML
    private JFXButton ButtonAnnonce;
    @FXML
    private JFXButton ButtonEvenement;
    @FXML
    private JFXButton ButtonSignOut;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane flowPane;
    @FXML
    private JFXButton ButtonProjet1;

    /**
     * Initializes the controller class.
     */
     private Connection cnx;
     private Statement ste;
     
        public List<freelancer> afficherById(int Id) {
        List<freelancer> freelancers = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `user` WHERE `archive`='" + 0 + "'AND `role`='freelancer' AND `id`='"+Id+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                freelancer p = new freelancer();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setTelephone(rs.getInt("telephone"));
                p.setAdresse(rs.getString("adresse"));
                p.setRole(rs.getString("role"));
                p.setMdp(rs.getString("mdp"));
                p.setCin(rs.getInt("cin"));
                p.setEmail(rs.getString("email"));
                p.setMetier(rs.getString("metier"));
                freelancers.add(p);
            }
            return freelancers;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return freelancers;
    }
               public List<Number> GetIdUsersBySousMetier(Number val) {
        List<Number> ls = new ArrayList<>();
        try {
            String qry ="SELECT id_user FROM `user_sousmetier` WHERE `id_sm`='"+val+"'  ";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
    
            while(rs.next()){     
                int sm ;
                sm=rs.getInt(1);
                
                ls.add(sm);
            }
            return ls ;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ls;
    }
               
               
    public User GetFreelancerById(Number idf) {
        User p = new User();
        try {
            String qry = "SELECT * FROM `user` WHERE `archive`='" + 0 + "' AND id='"+idf+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setTelephone(rs.getInt("telephone"));
                p.setAdresse(rs.getString("adresse"));
                p.setEmail(rs.getString("email"));

                
            }
            return p;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }         
        public List<User> GetFreelancersByIdSousMetier(Number idf) {
            List<User> freelancers = new ArrayList<>();
            List<Number> ids = new ArrayList<>();
            ids=GetIdUsersBySousMetier(idf);
            User u = new User();
            for (Number item:ids){
                freelancers.add(GetFreelancerById(item));
            }
        
       
        return freelancers;
    }                 
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = new User();
            CardViewSousMetierUsers card = new CardViewSousMetierUsers(user);
            List<User> lu = new ArrayList<>();
            System.out.println("");
            lu = GetFreelancersByIdSousMetier(CurrentSousMetier.CurrentSousMetier_id);
            System.out.println(CurrentSousMetier.CurrentSousMetier_id);
           flowPane.getChildren().clear();
            for (User item : lu) {
            CardViewSousMetierUsers cardView = new CardViewSousMetierUsers(item);
               
            flowPane.getChildren().add(cardView);
        }   
    }

    @FXML
    private void redirecttocompte(ActionEvent event) {
    }

    @FXML
    private void redirecttoProjet(ActionEvent event) {
    }

    @FXML
    private void redirecttometier(ActionEvent event) {
    }

    @FXML
    private void redirectToAnnonce(ActionEvent event) {
    }

    @FXML
    private void redirecttoevenement(ActionEvent event) {
    }

    @FXML
    private void signout(ActionEvent event) {
    }
@FXML
 private void redirectToSousMetierCardView(ActionEvent event) throws Exception {              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SousMetierClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    
}
