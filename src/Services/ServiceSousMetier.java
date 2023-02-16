/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.SousMetier;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Safe
 */
public class ServiceSousMetier implements IServices<SousMetier> {
    Connection cnx;
    @Override
    public void add(SousMetier t) {
         
         try {
        String qry ="INSERT INTO `sous-metier`( `nom`, `type`, `description`,`m-id`) VALUES ('"+t.getNom()+"','"+t.getType()+"','"+t.getDescription()+"','"+t.getId()+"')";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    
   @Override
    public List<SousMetier> afficher() {
        List<SousMetier> sm = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `sous-metier` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                SousMetier m =new SousMetier();
                m.setIdsm(rs.getInt(1));
                m.setNom(rs.getString(2));
                m.setType(rs.getString(3));
                m.setDescription(rs.getString(4));
                m.setId(rs.getInt(5));
                sm.add(m);
            }
            return sm;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sm;
    }
    public List<SousMetier> afficherById(int m) {
        List<SousMetier> sousMetiers = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `sous-metier` where id='"+ m +"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                SousMetier sm =new SousMetier();
                sm.setIdsm(rs.getInt(1));
                sm.setNom(rs.getString(2));
                sm.setType(rs.getString(3));
                sm.setDescription(rs.getString(4));
                sm.setId(rs.getInt(5));
                sousMetiers.add(sm);
            }
            return sousMetiers;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sousMetiers;
    }

    @Override
    public void modifier(SousMetier m) {
       try {
       String qry = "UPDATE `sous-metier` SET `nom`='" + m.getNom() + "', `type`='" + m.getType() + "', `description`='" + m.getDescription() + "' WHERE `id`='" + m.getIdsm()+ "'";

      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            System.out.println("Success Modification!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(SousMetier m) {
          try {
            String qry ="DELETE FROM `sous-metier` WHERE id = '" + m.getIdsm()+ "'";
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            System.out.println("Row Deleted!");
        }   catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
}
