/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Metier;
import Entities.SousMetier;
import Entities.freelancer;
import Services.ServiceMetier;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Safe
 */
public class ServiceSousMetier implements IServices<SousMetier> {
    Connection cnx;
    @Override
    public void add(SousMetier t) {
         
         try {
        String qry ="INSERT INTO `sous-metier`( `libelle`, `domaine`,`m-id`) VALUES ('"+t.getLibelle()+"','"+t.getDomaine()+"','"+t.getIdm()+"')";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
             System.out.println("Sous metier successfully Added!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
   
    public ObservableList<SousMetier> afficherData() {
        ObservableList<SousMetier> sm = FXCollections.observableArrayList();
        try {
            PreparedStatement qry =cnx.prepareStatement("SELECT * FROM `sous-metier` WHERE `archive`='"+0+"'  ");
            cnx = MyDB.getInstance().getCnx();
           
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                SousMetier m =new SousMetier();
                m.setId(rs.getInt(1));
                m.setLibelle(rs.getString("libelle"));
                m.setDomaine(rs.getString(3));
                m.setIdm(rs.getInt(4));
                sm.add(m);
            }
            return sm;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sm;
    }
    int res;
      public List<SousMetier> afficherByIdMetier(String val) {
        List<SousMetier> ls = new ArrayList<>();
        try {
            String qry ="SELECT id FROM `metier` WHERE `nom`='"+val+"'AND `archive`='"+0+"'  ";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while(rs.next()){
            res=rs.getInt(1);  
               
            }
            String sql ="SELECT id,libelle,domaine FROM `sous-metier` WHERE `m-id`='"+res+"'AND `archive`='"+0+"'  ";
            ResultSet rs1 = stm.executeQuery(sql);
            while(rs1.next()){     
                SousMetier sm = new SousMetier();
                sm.setId(rs1.getInt(1));
                sm.setLibelle(rs1.getString(2));
                sm.setDomaine(rs1.getString(3));
                
                ls.add(sm);
            }
            return ls ;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ls;
    }
       public List<SousMetier> afficherSmByIdMetier(int val) {
        List<SousMetier> ls = new ArrayList<>();
        try {
            String qry ="SELECT id,libelle,domaine FROM `sous-metier` WHERE `m-id`='"+val+"'AND `archive`='"+0+"'  ";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
    
            while(rs.next()){     
                SousMetier sm = new SousMetier();
                sm.setId(rs.getInt(1));
                sm.setLibelle(rs.getString(2));
                sm.setDomaine(rs.getString(3));
                ls.add(sm);
            }
            return ls ;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ls;
    }
            public int CountSmByIdm(int val) {
        int sum=0;
        try {
            String qry ="SELECT count(*) FROM `sous-metier` WHERE `m-id`='"+val+"'AND `archive`='"+0+"'  ";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while(rs.next()){
            sum=rs.getInt(1);  
               
            }
           
            return sum ;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sum;
    }
        public int getIdByNom(String a) {
        int sum=0;
        try {
            String qry ="SELECT id FROM `sous-metier` WHERE libelle='"+a+"'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            System.out.println(a);
            ResultSet rs = stm.executeQuery(qry);
            
            while(rs.next()){
            sum=rs.getInt(1);  
               
            }
           
            return sum ;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sum;
    }
                        public int CountSmByNom(String val) {
        int sum=0;
        try {
            String qry ="SELECT count(id_user) FROM `user_sousmetier` WHERE `id_sm`='"+getIdByNom(val)+"' ";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while(rs.next()){
            sum=rs.getInt(1);  
               
            }
           
            return sum ;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sum;
    }
   @Override
    public List<SousMetier> afficher() {
        List<SousMetier> sm = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `sous-metier` WHERE `archive`='"+0+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                SousMetier m =new SousMetier();
                m.setIdm(rs.getInt(4));
                
                m.setLibelle(rs.getString(2));
                m.setDomaine(rs.getString(3));
                
                
                sm.add(m);
            }
            return sm;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sm;
    }
      public List<SousMetier> filterByDomaine(String s) {
        List<SousMetier> sm = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `sous-metier` WHERE domaine= '"+ s +"'" ;
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                SousMetier m =new SousMetier();
                m.setIdm(rs.getInt(4));
                
                m.setLibelle(rs.getString(2));
                m.setDomaine(rs.getString(3));
                
                
                sm.add(m);
            }
            return sm;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sm;
    }
 
    @Override
    public void modifier(SousMetier m) {
       try {
      String qry = "UPDATE `sous-metier` SET `libelle`='" + m.getLibelle()+ "', `domaine`='" + m.getDomaine()  + "' WHERE `id`='" + m.getId()+ "'";

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
            String qry="UPDATE `sous-metier` SET `archive` ='" + "1"  + "' WHERE `id`='" + m.getId()+ "'";
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            System.out.println("Row Deleted!");
        }   catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
           public List<String> afficherAllNames() {
        List<String> metiers = new ArrayList();
        try {
            String qry ="SELECT libelle FROM `sous-metier` WHERE `archive`='"+0+"'  ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                String m =new String();
                
                m=(rs.getString("libelle"));
                
                metiers.add(m);
            }
            return metiers;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return metiers;
    }
              public List<String> afficherAllNamesExcept(String str) {
        List<String> metiers = new ArrayList();
        try {
            String qry ="SELECT libelle FROM `sous-metier` WHERE `archive`='"+0+"'  ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                String m =new String();
                
                m=(rs.getString("libelle"));
                
                metiers.add(m);
            }
                metiers.remove(str);
            return metiers;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return metiers;
    }
         public int countSousMetiersByMetier(String str) {
             int m = 0;
             ServiceMetier sm = new ServiceMetier();
             int id = sm.getIdByNom(str);
        List<String> metiers = new ArrayList();
        try {
            String qry ="SELECT count(*) FROM `sous-metier` WHERE `archive`='"+0+"' AND `m-id`='"+id+"'  ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
              
                
                m=(rs.getInt(1));
                
               
            }
              
            return m;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }
         int val;
              public int countFreelancerBySousMetier(int sm) {
        
        try {
            String qry = "SELECT count(id_user) FROM `user_sousmetier` WHERE `id_sm`='"+sm+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                freelancer p = new freelancer();
                val=rs.getInt(1);
                
                
            }
            return val;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return val;
    }

    @Override
    public void modifierr(int id, SousMetier entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
}
