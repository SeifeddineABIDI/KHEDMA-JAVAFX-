/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author azers
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.Projet;
import Utils.MyDB;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Entities.Tache;
import Entities.User;
import GUI.ProjetClientController;
import javafx.event.ActionEvent;

/**
 *
 * @author Mohamed
 */
public class ServiceProjet implements IServices<Projet>{
    
    
     ProjetClientController r = new ProjetClientController();
    Connection cnx;
    @Override
    
    public void add(Projet t) {
        
        
    try {
         
        // Check if project with the same name already exists
        String checkQuery = "SELECT * FROM `projet` WHERE `nom` = ?";
        Connection cnx = MyDB.getInstance().getCnx();
        PreparedStatement checkStm = cnx.prepareStatement(checkQuery);
        checkStm.setString(1, t.getNom());
        ResultSet rs = checkStm.executeQuery();
        if (rs.next()) {
            // Project with the same name already exists
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Project already exists");
            alert.setContentText("A project with the name '" + t.getNom() + "' already exists in the database.");
            alert.showAndWait();
            return;
        }
        
        // Project does not exist, insert it into the database
        String insertQuery = "INSERT INTO `projet` (`nom`, `client`, `freelancer`, `domaine`) VALUES (?, ?, ?, ?)";
        PreparedStatement insertStm = cnx.prepareStatement(insertQuery);
        insertStm.setString(1, t.getNom());
        insertStm.setString(2, t.getDomaine());
        insertStm.setString(3, t.getClient());
        insertStm.setString(4, t.getFreelancer());
        int rowsAffected = insertStm.executeUpdate();
        if (rowsAffected == 1) {
            // Project added successfully
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Project added successfully");
            alert.setContentText("The project has been added to the database");
            alert.showAndWait();
        } else {
            // Error occurred while adding project
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to add project");
            alert.setContentText("An error occurred while adding the project to the database");
            alert.showAndWait();
        }
    } catch (SQLException ex) {
        // Exception occurred while accessing database
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Failed to access database");
        alert.setContentText("An error occurred while accessing the database:\n" + ex.getMessage());
        alert.showAndWait();
    }
}


    @Override
    public List<Projet> afficher() {
        List<Projet> projets = new ArrayList<>();
        try {
            User currentUser = User.getCurrentUser();
            String D = currentUser.getNom();
            System.out.print(D);
            
            String qry = "SELECT * FROM `projet` WHERE `archive` = 0 AND `client` = '" + D + "';";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Projet p =new Projet();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setDomaine(rs.getString("domaine"));
                p.setClient(rs.getString("client"));
                p.setFreelancer(rs.getString("freelancer"));
               // p.setTaches(rs.getString("taches"));
                projets.add(p);
            }
            return projets;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return projets;
        
    }
    

   
    public void modifier(Projet t,int ID) {
  try {
        cnx = MyDB.getInstance().getCnx();
        
        // Check if project exists
        String selectQuery = "SELECT COUNT(*) FROM projet WHERE id = ?";
        PreparedStatement selectStatement = cnx.prepareStatement(selectQuery);
        selectStatement.setInt(1, ID);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        
        if (count == 0) {
            Alert alert = new Alert(AlertType.ERROR, "Cannot modify project: Project with ID " + ID + " does not exist");
            alert.showAndWait();
            return;
        }
        
        // Update project
        String updateQuery = "UPDATE projet SET nom = ?, domaine = ?, client = ?, freelancer = ? WHERE id = ?";
        PreparedStatement updateStatement = cnx.prepareStatement(updateQuery);
        updateStatement.setString(1, t.getNom());
        updateStatement.setString(2, t.getDomaine());
        updateStatement.setString(3, t.getClient());
        updateStatement.setString(4, t.getFreelancer());
        updateStatement.setInt(5, ID);
        updateStatement.executeUpdate();
        
        Alert alert = new Alert(AlertType.INFORMATION, "Project with ID " + ID + " has been modified successfully");
        alert.showAndWait();
        
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
      }

    
    public void supprimer(String D) {
                  try {
            String qry="UPDATE `projet` SET `archive` ='" + "1"  + "' WHERE `nom`='" + D + "'";
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
             
            System.out.println("Row Deleted!");
        }   catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
                  
                    
        
         }
    
    public List<Integer> getAllProjectIds() {
    List<Integer> projectIds = new ArrayList<>();
    try {
        String query = "SELECT id FROM projet";
        Connection connection = MyDB.getInstance().getCnx();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            projectIds.add(resultSet.getInt(1));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return projectIds;
}

    @Override
    public void modifier(Projet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Projet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
     public List<Projet> afficherFreelancer() {
        List<Projet> projets = new ArrayList<>();
        try {
            User currentUser = User.getCurrentUser();
            String D = currentUser.getNom();
            System.out.print(D);
            
            String qry = "SELECT * FROM `projet` WHERE `archive` = 0 AND `freelancer` = '" + D + "';";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Projet p =new Projet();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setDomaine(rs.getString("domaine"));
                p.setClient(rs.getString("client"));
                p.setFreelancer(rs.getString("freelancer"));
               // p.setTaches(rs.getString("taches"));
                projets.add(p);
            }
            return projets;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return projets;
        
    }
   
   
}