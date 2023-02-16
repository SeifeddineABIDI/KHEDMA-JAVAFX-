/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Safe
 */
public class SousMetier extends Metier {
    private int idsm;

    
    

    public SousMetier( String nom, String type, String description, int id) {
        super(id,nom,type,description);
       
        
    }

    
    
    public SousMetier( int idsm,String nom, String type, String description) {
              
        super(nom,type,description);
        this.idsm = idsm;   
    }
    

    public int getIdsm() {
        return idsm;
    }

    public void setIdsm(int idsm) {
        this.idsm = idsm;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

   @Override
    public String toString() {
       return "SousMetier{" +"idsm="+idsm+ ",nom=" + nom + ", type=" + type + ", description=" + description + ", id=" + id + '}';
    }


    public SousMetier() {
    }
     
    
}
