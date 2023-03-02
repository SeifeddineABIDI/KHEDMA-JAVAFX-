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
import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.Alert;
import Entities.Tache;
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
import Entities.CurrentProjectData;
import Entities.Tache;


/**
 *
 * @author azers
 */

public class ServiceTache implements IServices<Tache> {

    
    Connection cnx = MyDB.getInstance().getCnx();

  
    @Override
    public void add(Tache t) {
        try {
            String query = "INSERT INTO tache (project_id, nom, status, description, priority, estimated_time) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, t.getProjectId());
            statement.setString(2, t.getNom());
            statement.setString(3, t.getStatus());        
            
            statement.setString(4, t.getDescription());
            statement.setString(5, t.getPriority());
            statement.setInt(6, t.getEstimatedTime());
            statement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Task added successfully");
            alert.setContentText("The Task has been added to the database");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println("Error while adding task: " + ex.getMessage());
        }
    }

   
    @Override
    public List<Tache> afficher() {
        int D = CurrentProjectData.currentProjectId;
        List<Tache> taches = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `tache` where project_id = '" +D+ "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Tache p =new Tache();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setStatus(rs.getString("status"));              
                p.setDescription(rs.getString("description"));
                p.setPriority(rs.getString("priority"));
                p.setEstimatedTime(rs.getInt("estimated_time"));

               // p.setTaches(rs.getString("taches"));
                taches.add(p);
                
            }
            return taches;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return taches;
        
    }
    

    
   

    
    public void supprimer(String D) {
        int d =Integer.parseInt(D);
          try {
              
        String qry ="DELETE FROM tache WHERE project_id = '" +d+ "'";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
         
  
    }
    
 @Override
public void modifier(Tache t) {
    try {
        String query = "UPDATE `tache` SET `status` = ? WHERE `tache`.`id` = ?;";
        PreparedStatement statement = cnx.prepareStatement(query);
        statement.setString(1, t.getStatus());
        statement.setInt(2, t.getId());
        statement.executeUpdate();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Task updated successfully");
        alert.setContentText("The task status has been updated");
        alert.showAndWait();
    } catch (SQLException ex) {
        System.out.println("Error while updating task: " + ex.getMessage());
    }
}

    @Override
    public void supprimer(Tache t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}