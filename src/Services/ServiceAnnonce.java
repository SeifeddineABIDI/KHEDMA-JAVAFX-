/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import com.sun.security.ntlm.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
public class ServiceAnnonce implements IServices<Annonce> {

    Connection cnx;

    public void add(Annonce t) {
        try {
            String qry = "INSERT INTO `annonce`( `titre`, `id_client`, `date`,`id_c`) VALUES ('" + t.getTitre() + "','8','" + t.getDate() + "','" + t.getId_c() + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
            System.out.println("Ajout avec succès!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Annonce> afficher() {
        List<Annonce> annonces = new ArrayList<>();
        try {
            String qry = "SELECT a.id,a.titre,a.date,a.id_client,a.id_c,a.archive,CONCAT(c.nom,' ',c.prenom) AS nom FROM annonce a INNER JOIN user c ON c.id = a.id_client WHERE role='Client' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Annonce a = new Annonce();
                a.setId(rs.getInt(1));
                a.setTitre(rs.getString("titre"));
                a.setDates(rs.getDate("date"));
                a.setId_client(rs.getInt("id_client"));
                a.setId_c(rs.getInt("id_c"));
                a.setNom_client(rs.getString("nom"));
                annonces.add(a);
                      System.out.println(annonces);

            }
            return annonces;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return annonces;
        

    }

    public List<Annonce> filterById_c(String c) {
        List<Annonce> annonces = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `annonce` WHERE `archive`='" + 0 + "' ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Annonce a = new Annonce();
                a.setId(rs.getInt(1));
                a.setTitre(rs.getString("titre"));

                annonces.add(a);
            }
            return annonces;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return annonces;

    }

    public void modifier(Annonce t) {
        try {
            String qry = "UPDATE `annonce` SET `titre`='" + t.getTitre() + "', `nom_client`='" + t.getNom_client() + "', `date`='" + t.getDate() + "', `id_c`='" + t.getId_c() + "' WHERE `id`='" + t.getId() + "'";

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
            System.out.println("Modification avec succès!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Annonce t) {
        try {
            String qry = "UPDATE `annonce` SET archive ='" + "1" + "' WHERE id='" + t.getId() + "' ";

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
            System.out.println("Colomne supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<Annonce> afficherData() {
        ObservableList<Annonce> annonces = FXCollections.observableArrayList();
        try {
            PreparedStatement qry = cnx.prepareStatement("SELECT * FROM `annonce` WHERE `archive`='" + 0 + "'  ");
            cnx = MyDB.getInstance().getCnx();

            ResultSet rs = qry.executeQuery();
            while (rs.next()) {
                Annonce a = new Annonce();
                a.setId(rs.getInt("id"));
                a.setTitre(rs.getString("titre"));
                a.setNom_client(rs.getString("nom_client"));
                a.setDates(rs.getDate("date"));
                a.setId_c(rs.getInt("id_c"));
                annonces.add(a);
            }
            return annonces;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return annonces;
    }

    public List<Annonce> selectAll() throws SQLException {
        //LIST
        List<Annonce> annonces = new ArrayList<>();
        //request 
        cnx = MyDB.getInstance().getCnx();
  /*      PreparedStatement qry = cnx.prepareStatement("SELECT * FROM `annonce` WHERE `archive`='" + 0 + "'  ");

        //insert
        Statement stm = cnx.createStatement();
        ResultSet rs = qry.executeQuery();
 
        while (rs.next()) {
            Annonce a = new Annonce();

            a.setId(rs.getInt(1));
            a.setTitre(rs.getString("titre"));
            a.setDates(rs.getDate("date"));
            a.setId_client(rs.getInt("id_client"));
            PreparedStatement qry1 = cnx.prepareStatement("SELECT * FROM user WHERE 'id'= '"+rs.getInt("id_client")+"' AND `archive`='" + 0 + "'  ");

            Statement stm1 = cnx.createStatement();
            ResultSet rs1 = qry1.executeQuery();
            a.setId_c(rs.getInt("id_c"));
            System.out.println(rs1.getString("nom"));
                       a.setNom_client(rs1.getString("nom"));

            annonces.add(a);

            // annonces.add(new Annonce(rs.getInt("id"),rs.getString("titre"),rs.getString("nom_client"),rs.getDate("date"),rs.getInt("id_c")));
        }*/
                        String req1 = "SELECT * FROM `annonce` WHERE `archive`= ?";

        PreparedStatement pst1;
         try {
            pst1 = cnx.prepareStatement(req1);
            pst1.setInt(1, 0);
            ResultSet result = pst1.executeQuery();
            while (result.next()) {
          Annonce a = new Annonce();

            a.setId(result.getInt("id"));
                System.out.println("id ="+result.getInt("id"));
            a.setTitre(result.getString("titre"));
            System.out.println("titre ="+result.getString("titre"));
            a.setDates(result.getDate("date"));
            System.out.println("date ="+result.getDate("date"));
            a.setId_client(result.getInt("id_client"));
            System.out.println(result.getInt("id_client"));
            a.setId_c(result.getInt("id_c"));
                String req = "SELECT * FROM `user` where `id` = ?";
                PreparedStatement pst;
                    pst = cnx.prepareStatement(req);
                    pst.setInt(1, result.getInt("id_client"));
                    ResultSet result1 = pst.executeQuery();
                                while (result1.next()) {

                                a.setNom_client(result1.getString("nom"));
                                System.out.println("le nom "+result1.getString("nom"));
                    System.out.println(a.toString());
                                                annonces.add(a);

                                }


            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return annonces;

    }

    @Override
    public void modifierr(int id, Annonce entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
