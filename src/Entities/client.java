/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author DELL
 */
public class client extends User {
    private String domaine;

    public String getDomaine() {
        return domaine;
    }
 
    
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String toString() {
                return "Client{" + "id=" + getId() +  ", telephone=" + getTelephone() + ", cin=" + getCin() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", adresse=" + getAdresse() + ", email=" + getEmail() +", domaine="+domaine+ '}';

    }

    public client(String domaine, String nom, String prenom, int cin, String role, String email, String mdp, String adresse, int telephone , String img,String gname) {
        super(nom, prenom, cin, role, email, mdp, adresse, telephone,img , gname);
        this.domaine = domaine;
    }

    public client(String domaine, int id, String nom, String prenom, int cin, String email, String mdp, String adresse, int telephone, String img,String gname) {
        super(id, nom, prenom, cin, email, mdp, adresse, telephone,img , gname);
        this.domaine = domaine;
    }

 public client(String domaine, int id, String nom, String prenom, int cin, String email, String mdp, String adresse, int telephone) {
        super(id, nom, prenom, cin, email, mdp, adresse, telephone);
        this.domaine = domaine;
    }
    

    public client() {
    }

    public client( int id, String nom, String prenom, int cin,String domaine, String email, String mdp, String adresse, int telephone, String img,String gname) {
        super(id, nom, prenom, cin, email, mdp, adresse, telephone,  img, gname);
        this.domaine = domaine;
    }

    public client( int id, String nom, String prenom, int cin,String domaine, String role, String email, String mdp, String adresse, int telephone, String img,String gname) {
        super(id, nom, prenom, cin, role, email, mdp, adresse, telephone,  img, gname);
        this.domaine = domaine;
    }

    public client(int id) {
        super(id);
    }

    
     public client( int id, String nom, String prenom, int cin,String domaine, String role, String email, String mdp, String adresse, int telephone) {
        super(id, nom, prenom, cin, role, email, mdp, adresse, telephone);
        this.domaine = domaine;
    }
    
       public client(  String nom, String prenom, int cin,String domaine, String role, String email, String mdp, String adresse, int telephone) {
        super( nom, prenom, cin, role, email, mdp, adresse, telephone);
        this.domaine = domaine;
    }
    
    public client( String nom, String prenom, int cin, String domaine,String role, String email, String mdp, String adresse, int telephone, String img,String gname) {
        super(nom, prenom, cin, role, email, mdp, adresse, telephone,  img, gname);
        this.domaine = domaine;
    }
    
}
