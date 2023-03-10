/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Services.ServiceCategorie;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Evenement {
    private int id;
    private String titre,description,Lieu,image;
    private Date date;
    private int id_categorie,prix ;

    
    



    public Evenement() {
    }

    public Evenement(String titre, String description, String Lieu, Date date, int id_categorie, int prix, String image) {
        this.titre = titre;
        this.description = description;
        this.Lieu = Lieu;
        this.date = date;
        this.id_categorie = id_categorie;
        this.prix = prix;
        this.image = image;

    }

    public Evenement(int id, String titre, String description, String Lieu, Date date, int id_categorie, int prix) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.Lieu = Lieu;
        this.date = date;
        this.id_categorie = id_categorie;
        this.prix = prix;
    }

    public Evenement(int id, String titre, String description, String Lieu, Date date, int id_categorie, int prix, String image) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.Lieu = Lieu;
        this.image = image;
        this.date = date;
        this.id_categorie = id_categorie;
        this.prix = prix;
        this.image = image;
    }



    public Evenement(String titre, Date sqlDate, String descp, int prix, int txtcat , String txtlieu) {
     this.titre = titre;
        this.description = descp;
        this.Lieu = txtlieu;
        this.date = sqlDate;
        this.id_categorie = txtcat;    }

    Evenement(String titre_1, LocalDate now, String description_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }




    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }



    
    
    
 
    

 



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDate21() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", Lieu=" + Lieu + ", image=" + image + ", date=" + date + ", id_categorie=" + id_categorie + ", prix=" + prix + ", image=" + image +'}';
    }



   

    public void setDates21(Date date) {
this.date = date;    }



    

   

    
    
}
