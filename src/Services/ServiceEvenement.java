/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Evenement;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceEvenement implements IServices<Evenement> {

    Connection cnx;

    @Override
    public void add(Evenement t) {
        try {
            System.out.println(t.toString());
            String qry = "INSERT INTO `evenement` (titre,description ,Lieu,date, id_categorie,prix,image) VALUES ('" + t.getTitre() + "','" + t.getDescription() + "','" + t.getLieu() + "','" + t.getDate21() + "','" + t.getId_categorie() + "','" + t.getPrix() + "','"+t.getImage()+"');";
            cnx = MyDB.getInstance().getCnx();
//
            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
            System.out.println("Ajout avec succès!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Evenement t) {

        try {
            String qry = "UPDATE `evenement` SET `titre`='" + t.getTitre() + "', `description`='" + t.getDescription() + "', `Lieu`='" + t.getLieu() + "', `Date`='" + t.getDate21() + "', `id_categorie`='" + t.getId_categorie() + "', `prix`='" + t.getPrix() + "', `image`='" + t.getImage()+  "' WHERE `id`=2";

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
            System.out.println("Modification avec succées");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Evenement t) {

        try {
            String qry = "UPDATE `evenement` SET archive ='" + "1" + "' WHERE id='" + t.getId() + "' ";

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
            System.out.println("Suppression avec succées ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Evenement> afficher() {
        List<Evenement> Evenements = new ArrayList();
        try {
            String qry = "SELECT * FROM evenement WHERE `archive`='" + 0 + "'  ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Evenement e = new Evenement(rs.getInt("id"), rs.getString("titre"), rs.getString("description"), rs.getString("Lieu"), rs.getDate("date"), rs.getInt("id_categorie"), rs.getInt("prix"), rs.getString("image"));

                Evenements.add(e);
            }
            return Evenements;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Evenements;
    }

    int res;

    public List<Evenement> afficherByNomCategorie(String val) {
        List<Evenement> ls = new ArrayList<>();

        try {
            String qry = "SELECT id_categorie FROM `categorie` WHERE `nom`='" + val + "'AND `archive`='" + 0 + "'  ";

            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()) {
                res = rs.getInt(1);

            }
            System.out.println(res);
            String sql = "SELECT id,titre,description,Lieu,date,prix,image FROM `evenement` WHERE `id_categorie`='" + res + "'AND `archive`='" + 0 + "'  ";
            ResultSet rs1 = stm.executeQuery(sql);
            while (rs1.next()) {
                Evenement sm = new Evenement();
                sm.setId(rs1.getInt(1));
                sm.setTitre(rs1.getString(2));
                sm.setDescription(rs1.getString(3));
                sm.setLieu(rs1.getString(4));
                sm.setDates21(rs1.getDate(5));
                sm.setPrix(rs1.getInt(6));
                sm.setImage(rs1.getString(7));
                ls.add(sm);
            }
            return ls;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ls;
    }

    public List<String> afficherAllNames( ) {
        
        
               List<String> evenments = new ArrayList();
        try {
            String qry ="SELECT titre FROM `evenement` WHERE `archive`='"+0+"'  ";
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

    @Override
    public void modifierr(int id, Evenement entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }


