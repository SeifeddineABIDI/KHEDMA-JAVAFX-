/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Date;
import java.time.LocalDate;
import Services.ServiceAnnonce;
import Services.ServiceClassification;

/**
 *
 * @author DELL
 */
public class Annonce {
    private int id,id_c,id_client;
    private String titre,nom_client;
    private Date date;

    

    public Annonce() {
    }
public Annonce(int id,String titre, String nom_client, Date date,int id_c){
        this.id = id;
        this.titre = titre;
        this.nom_client = nom_client;
        this.date = date;
        this.id_c = id_c;
}
    public Annonce(String titre, String nom_client, Date date,int id_c) {
        this.titre = titre;
        this.nom_client = nom_client;
        this.date = date;
        this.id_c = id_c;
        
    }

    public Annonce(int id_c, int id_client, String titre, String nom_client, Date date) {
        this.id_c = id_c;
        this.id_client = id_client;
        this.titre = titre;
        this.nom_client = nom_client;
        this.date = date;
     
    }
    
    

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public Date getDate() {
        return date;
    }

    public void setDates(Date date) {
        this.date = date;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }



    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + ", id_c=" + id_c + ", id_client=" + id_client + ", titre=" + titre + ", nom_client=" + nom_client + ", date=" + date + '}';
    }

    
    

   
    
    
    
}
