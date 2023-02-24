/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import Services.ServiceMetier;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
                    /**
 *
 * @author Safe
 */
public class SousMetier   {
    private int id,idm;
    private String libelle,domaine;
    
    public SousMetier(int id,String libelle, String domaine) {
       this.id = id;
       this.domaine = domaine;
       this.libelle = libelle;
          }
    
    

    public SousMetier( String libelle, String domaine,int idm) {
       this.idm = idm;
       this.domaine = domaine;
       this.libelle = libelle;
          }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }
    
    
    public SousMetier() {
    }
    @Override
    public String toString() {
            ServiceMetier sm = new ServiceMetier();
            return "SousMetier{" +"id="+id+ ", Libelle=" + libelle + ", domaine=" + domaine +", Nom_Metier=" + sm.afficherById(idm) +  '}';
        

 
}
}
