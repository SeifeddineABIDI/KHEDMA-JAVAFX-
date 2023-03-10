



package Services;

import Entities.Evenement;
import Entities.Rating;
import Entities.Rating;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;

/**
 *
 * @author DELL
 */


public class ServiceRating {
    
    
    
    Connection cnx;

    
    public void add(Rating R) {
        try {
            System.out.println(R.toString());
            String qry = "INSERT INTO `rating` (id_evenement,id_Freelancer ,rating) VALUES ('" + R.getId_Freelancer()+ "','" + R.getId_evenement()+ "','" + R.getRating() + "');";
//
            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
            System.out.println("Ajout avec succès!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    

    
        public List<String>afficher(int idFreelancer) {
        List<String> Rating = new ArrayList();
        try {
            String qry = "SELECT `id_evenement`, `id_Freelancer`, `rating` FROM `rating` WHERE id_Freelancer= '"+ idFreelancer+"'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Rating R = new Rating(rs.getInt("id_evenement"), rs.getInt("id_Freelancer"), rs.getInt("rating"));

            }
            return Rating;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Rating;
    }

    public double add(KeyCode keyCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


            public List<String> afficherAllRaiting( Number newValue) {
        
        
               List<String> evenments = new ArrayList();
        try {
            String qry = "SELECT  `rating` FROM `rating` WHERE id_Freelancer= '"+ newValue+"'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                String m =new String();
                
                m=(rs.getString("titre"));
                
                evenments.add(m);
            }
            return evenments;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenments;
    }
    }

    
    
    
    

