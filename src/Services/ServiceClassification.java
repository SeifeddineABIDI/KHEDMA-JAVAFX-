/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utils.MyDB;
import Entities.Annonce;
import Entities.Classification;

/**
 *
 * @author DELL
 */
public class ServiceClassification implements IServices<Classification> {
    Connection cnx;
    
    
    
    public void add(Classification t) {
         try {
        String qry ="INSERT INTO `classification`( `nom`, `domaine`) VALUES ('"+t.getNom()+"','"+t.getDomaine()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            System.out.println("Ajout avec succès!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

    public List<Classification> afficher() {
        List<Classification> classifications = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `classification` WHERE `archive`='"+0+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Classification c =new Classification();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString("nom"));
          
                c.setDomaine(rs.getString("domaine"));
                classifications.add(c);
            }
            return classifications;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return classifications;
        
    }
    
    public List<String> afficherAllNames(){
        
        List<String> classifications= new ArrayList();
        
        try {
            String qry ="SELECT * FROM `classification` WHERE `archive`='"+0+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                String c = new String();
                c =(rs.getString("nom"));
                classifications.add(c);
           }
            return classifications;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return classifications;
        
        
    }
    int res;
    public int getIdByNom(String s){
       //  List<Classification> classifications = new ArrayList<>();
           System.out.println("hello");

        try {
            String qry ="SELECT id FROM `classification` WHERE `archive`='"+0+"' AND `nom`='"+s+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
      System.out.println(qry);
            if(rs.next()){
               // Classification c =new Classification();
              System.out.println("hello world");  
               res=Integer.parseInt(rs.getString("id"));
                
               
            }
             System.out.println(res);
            return res;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res=1;
        }
        return res;
      
        
    }
    
    
    
        public String afficherById(int idc) {
        try {
            System.out.println("idc= "+idc);
            String qry ="SELECT * FROM `classification` WHERE `archive`='"+0+"' AND `id`='"+idc+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                
                
               return rs.getString("nom");
          
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }
        
        public List<Annonce> afficherByNomClassification(String val) {
            int test = 0;
        List<Annonce> ls = new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        try {
            String qry ="SELECT a.id, a.titre, a.date, a.id_client, a.id_c, a.archive, CONCAT(c.nom,' ',c.prenom) AS nom FROM classification INNER JOIN annonce a ON classification.id = a.id_c INNER JOIN user c ON c.id = a.id_client WHERE classification.nom = '"+val+"' ";
           
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
           
            while(rs.next()){
           // res=rs.getInt(1);  
             //  list.add(res);
            Annonce a = new Annonce();
               /* a.setId(rs1.getInt(1));
                a.setTitre(rs1.getString(2));
                a.setNom_client(rs1.getString(3));
                a.setDates(rs1.getDate(4));
                a.setId_c(rs1.getInt(5));
                */
               a.setId(rs.getInt(1));
                a.setTitre(rs.getString("titre"));
                a.setDates(rs.getDate("date"));
                a.setId_client(rs.getInt("id_client"));
                a.setId_c(rs.getInt("id_c"));
                a.setNom_client(rs.getString("nom"));
               ls.add(a);
            }
          /*  String sql ="SELECT a.id,a.titre,a.date,a.id_client,a.id_c,a.archive,CONCAT(c.nom,' ',c.prenom) AS nom FROM annonce a INNER JOIN client c ON c.id = a.id_client WHERE `archive`='"+0+"' AND `id_c`='8' AND `archive`='"+0+"' " ;
            
            ResultSet rs1 = stm.executeQuery(sql);
            while(rs1.next()){    
                
            }
           */ 
            return ls ;
           
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ls;
    }
        
             /*  public List<Classification> afficherScByIdAnnonce(int val) {
        List<Classification> ls = new ArrayList<>();
        try {
            String qry ="SELECT nom,domaine FROM `classification` WHERE `id`='"+val+"'AND `archive`='"+0+"'  ";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
    
            while(rs.next()){     
                Classification c = new Classification();
                c.setNom(rs.getString(1));
                c.setDomaine(rs.getString(2));
                ls.add(c);
            }
            return ls ;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ls;
    }*/

    public void modifier(Classification t) {
          try {
       String qry = "UPDATE `classification` SET `nom`='" + t.getNom()   +  "', `domaine`='" + t.getDomaine()   +  "' WHERE `id`='" + t.getId()+ "'";

      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
             System.out.println("Modification avec succès!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
      }

    public void supprimer(Classification t) {
         try {
        String qry = "UPDATE `classification` SET archive ='" + "1"  + "' WHERE id='" + t.getId()+ "' ";

      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            System.out.println("Colomne supprimée!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
         }
   public ObservableList<Classification> afficherData() {
        ObservableList<Classification> classifications = FXCollections.observableArrayList();
        try {
            PreparedStatement qry =cnx.prepareStatement("SELECT * FROM `classification` WHERE `archive`='"+0+"'  ");
            cnx = MyDB.getInstance().getCnx();
           
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Classification c =new Classification();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString("nom"));
                c.setDomaine(rs.getString(3));
                
                classifications.add(c);
            }
            return classifications;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return classifications;
    }

    @Override
    public void modifierr(int id, Classification entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}

