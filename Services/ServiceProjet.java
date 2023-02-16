
package workshop3a24.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshop3a24.Entities.Personne;
import workshop3a24.Entities.Projet;
import workshop3a24.Utils.MyDB;
import java.util.Scanner;

/**
 *
 * @author Mohamed
 */
public class ServiceProjet implements IService<Projet>{
    Connection cnx;
    @Override
    public void add(Projet t) {
         try {
        String qry ="INSERT INTO `projet`( `nom`, `domaine`, `client`, `freelancer`, `taches`) VALUES ('"+t.getNom()+"','"+t.getDomaine()+"','"+t.getClient()+"','"+t.getFreelancer()+"','"+t.getTaches()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Projet> afficher() {
        List<Projet> projets = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `projet` ";
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
                p.setTaches(rs.getString("taches"));
                projets.add(p);
            }
            return projets;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return projets;
        
    }

    @Override
    public void modifier(String M ,Projet t) {
         try {
       String qry = "UPDATE `projet` SET `nom`='" + t.getNom() + "', `domaine`='" + t.getDomaine() + "', `client`='" + t.getClient() + "', `freelancer`='" + t.getFreelancer() + "', `taches`='" + t.getTaches() + "' WHERE `nom`='" + M + "'";

      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
      }

    @Override
    public void supprimer(String D) {
                 try {
        String qry ="DELETE FROM projet WHERE nom = '" + D+ "'";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
         }
    
   
}