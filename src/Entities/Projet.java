/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author azers
 */
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Task;

/**
 *
 * @author azers
 */
public class Projet {
    
    private int id ;
    private String nom,domaine,client,freelancer;
     

 
    public Projet() {
    }

    public Projet(String nom, String domaine, String client,String freelancer){
        this.nom = nom;
        this.domaine = domaine;
        this.client = client;
        this.freelancer = freelancer;
        
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(String freelancer) {
        this.freelancer = freelancer;
    }
     



    @Override
    public String toString() {
        return "Projet{"+ "ID :"+id + ", nom=" + nom + ", domaine=" + domaine + ", client=" + client + ", freelancer=" + freelancer + "\n}";
    }
    
    
}



