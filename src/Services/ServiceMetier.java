/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Metier;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Safe
 */
public class ServiceMetier implements IServices<Metier>{
    Connection cnx;
    @Override
    public void add(Metier t) {
         try {
        String qry ="INSERT INTO `metier`( `nom`, `type`, `description`) VALUES ('"+t.getNom()+"','"+t.getType()+"','"+t.getDescription()+"')";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Metier> afficher() {
        List<Metier> metiers = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `metier` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Metier m =new Metier();
                m.setId(rs.getInt(1));
                m.setNom(rs.getString("nom"));
                m.setType(rs.getString(3));
                m.setDescription(rs.getString("Description"));
                metiers.add(m);
            }
            return metiers;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return metiers;
    }

    @Override
    public void modifier(Metier m) {
       try {
       String qry = "UPDATE `metier` SET `nom`='" + m.getNom() + "', `type`='" + m.getType() + "', `description`='" + m.getDescription() + "' WHERE `id`='" + m.getId()+ "'";

      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            System.out.println("Success!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Metier m) {
          try {
            String qry ="DELETE FROM metier WHERE nom = '" + m.getNom()+ "'";
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        }   catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
}
