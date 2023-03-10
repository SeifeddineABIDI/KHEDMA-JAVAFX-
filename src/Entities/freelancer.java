/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author DELL
 */
public class freelancer extends User  {
    private String metier  ;

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public freelancer() {
        super();
    }

    
    
  public freelancer( int id, String nom, String prenom, int cin , String metier, String email, String mdp, String adresse, int telephone) {
        super(id ,nom, prenom, cin,  email, mdp, adresse, telephone);
        this.metier = metier;
    }
    public freelancer(  String nom, String prenom, int cin , String metier,String role, String email, String mdp, String adresse, int telephone) {
        super(nom, prenom, cin,role,  email, mdp, adresse, telephone);
        this.metier = metier;
    }
  
  
  
  
    public freelancer( int id, String nom, String prenom, int cin , String metier,String role, String email, String mdp, String adresse, int telephone) {
        super(id ,nom, prenom, cin,role,  email, mdp, adresse, telephone);
        this.metier = metier;
    }
  
    public freelancer(String metier, String nom, String prenom, int cin, String role, String email, String mdp, String adresse, int telephone,String img , String gname) {
        super(nom, prenom, cin, role, email, mdp, adresse, telephone,img , gname);
        this.metier = metier;
    }
    
  
  public freelancer(String metier, String nom, String prenom, int cin, String role, String email, String mdp, String adresse, int telephone) {
        super(nom, prenom, cin, role, email, mdp, adresse, telephone);
        this.metier = metier;
    }
    
    public freelancer(String metier, int id, String nom, String prenom, int cin, String role, String email, String mdp, String adresse, int telephone,String img , String gname) {
        super(id,nom, prenom, cin, role, email, mdp, adresse, telephone,img , gname);
        this.metier = metier;
    }   
    
    
       public freelancer(String metier, int id, String nom, String prenom, int cin, String role, String email, String mdp, String adresse, int telephone) {
        super(id,nom, prenom, cin, role, email, mdp, adresse, telephone);
        this.metier = metier;
    }   
    
    
    
    public freelancer(String metier, int id, String nom, String prenom, int cin, String email, String mdp, String adresse, int telephone,String img , String gname) {
        super(id,nom, prenom, cin, email, mdp, adresse, telephone,img , gname);
        this.metier = metier;
    }
    
  public freelancer(String metier, int id, String nom, String prenom, int cin, String email, String mdp, String adresse, int telephone) {
        super(id,nom, prenom, cin, email, mdp, adresse, telephone);
        this.metier = metier;
    }
  

   
    public freelancer( int id, String nom, String prenom, int cin, String metier ,String email, String mdp, String adresse, int telephone,String img , String gname) {
        super(id,nom, prenom, cin,  email, mdp, adresse, telephone,img , gname);
        this.metier = metier;
    }

    @Override
    public String toString() {
        return "freelancer{"+ super.toString() + "metier=" + metier + '}';
    }
    
}
