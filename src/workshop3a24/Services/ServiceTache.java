/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.Alert;
import workshop3a24.Entities.Tache;
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
import workshop3a24.Entities.Personne;
import workshop3a24.Entities.Projet;
import workshop3a24.Utils.MyDB;
import java.util.Scanner;
import javafx.scene.control.Alert;
import workshop3a24.Entities.CurrentProjectData;
import workshop3a24.Entities.Tache;


/**
 *
 * @author azers
 */

public class ServiceTache implements IService<Tache> {

    
    Connection cnx = MyDB.getInstance().getCnx();

  
    @Override
    public void add(Tache t) {
        try {
            String query = "INSERT INTO tache (project_id, nom, status, files, description, priority, estimated_time) VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, t.getProjectId());
            statement.setString(2, t.getNom());
            statement.setString(3, t.getStatus());        
            statement.setString(4, t.getFiles());
            statement.setString(5, t.getDescription());
            statement.setString(6, t.getPriority());
            statement.setInt(7, t.getEstimatedTime());
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
                p.setFiles(rs.getString("files"));
                p.setDescription(rs.getString("description"));
                p.setPriority(rs.getString("priority"));
                p.setEstimatedTime(rs.getInt("estimated_time"));

               // p.setTaches(rs.getString("taches"));
                taches.add(p);
                System.out.print(taches);
            }
            return taches;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return taches;
        
    }
    

    @Override
    public void modifier(Tache t, int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
}