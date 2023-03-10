/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Categorie;
import Entities.Evenement;
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



public class ServiceCategorie {
    
  Connection cnx;

    public void add(Categorie t) {
        try {
String qry = "INSERT INTO `categorie`(`nom`, `type`) VALUES ('" + t.getType() + t.getNom() + "')";

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Categorie> afficher() {
        List<Categorie> Categories = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `categorie`WHERE `archive`='"+0+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Categorie p = new Categorie();
                p.setId_categorie(rs.getInt(1));

                p.setNom(rs.getString("nom"));

                p.setType(rs.getString("type"));


                Categories.add(p);
            }
            return Categories;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Categories;

    }
        public String afficherById(int idc) {
            String res="";
            try {
            String qry = "SELECT * FROM `categorie`WHERE `archive`='"+0+"' AND `id_categorie`='"+idc+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                res=(rs.getString(2));
            }
            return res;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
        
    }
        
        
        
        
                    int res;
        public int getIdByNom(String s){
       //  List<Classification> classifications = new ArrayList<>();
           System.out.println("hello");

        try {
            String qry ="SELECT id_categorie FROM `categorie` WHERE `archive`='"+0+"' AND `nom`='"+s+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
     
            if(rs.next()){
               // Classification c =new Classification();
              
               res=Integer.parseInt(rs.getString("id_categorie"));
                
               
            }
             System.out.println(res);
            return res;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res=1;
        }
        return res;
      
        
    }
        
                
    public List<Categorie> afficherAllNames(){
        
        List<Categorie> categories= new ArrayList();
        
        try {
            String qry ="SELECT id_categorie,nom FROM `categorie` WHERE `archive`='"+0+"' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Categorie c = new Categorie();
                c.setId_categorie(rs.getInt(1));
                c.setNom(rs.getString(2));
                
                categories.add(c);
           }
            return categories;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categories;
        
        
    }

    public void modifier(Categorie t) {

        try {
String qry = "UPDATE `categorie` SET `type`='" + t.getType() + "' WHERE `id_categorie`=2";

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void supprimer(Categorie t) {

        try {
            String qry = "UPDATE `categorie` SET archive ='" + "1"  + "'   WHERE `id_categorie`='"+t.getId_categorie()+ "'";

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
       public ObservableList<Categorie> afficherData() {
        ObservableList<Categorie> classifications = FXCollections.observableArrayList();
        try {
            PreparedStatement qry =cnx.prepareStatement("SELECT * FROM `categorie` WHERE `archive`='"+0+"'  ");
            cnx = MyDB.getInstance().getCnx();
           
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Categorie c =new Categorie();
                c.setId_categorie(rs.getInt(1));
                c.setNom(rs.getString("nom"));
                c.setType(rs.getString(3));
                
                classifications.add(c);
            }
            return classifications;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return classifications;
    }
   
    
    
    
    
    

}
