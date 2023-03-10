    package Entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Categorie {
    private int id_categorie;
    private String Type,nom;

    public Categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Categorie() {
    }

    public Categorie(String Type, String nom) {
        this.Type = Type;
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    

    public Categorie(String Type) {
        this.Type = Type;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
return "Categorie{" + "id_categorie=" + id_categorie + ", Type=" + Type + ", nom=" + nom + "}";
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    
    
    
}
