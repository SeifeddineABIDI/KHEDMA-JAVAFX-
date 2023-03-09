/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khedma;
import Entities.SousMetier;
import Entities.User;
import GUI.CardViewSousMetier;
import GUI.CardViewSousMetierUsers;
import GUI.SousMetierUsersController;
import Services.ServiceMetier;
import Services.ServiceSousMetier;
import Services.Servicefreelancer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Safe
 */
public class Khedma {

    public static void main(String[] args) {
        //Metier m = new  Metier(7,"abo maheer","ok","oui","C:\\Users\\Safe\\Documents\\NetBeansProjects\\khedma\\src\\Images\\logo 5edma tr.png");
       SousMetier sousmetier = new SousMetier();
            ServiceSousMetier sm1 = new ServiceSousMetier();
        //SousMetierUsersController s = new SousMetierUsersController();
       // System.out.println(sm1.afficherAllNames());
      //  System.out.println(sm1.afficherAllNamesExcept("manar"));
       
       
        System.out.println( sm1.countFreelancerBySousMetier(sm1.getIdByNom("Architecture interieur et decoration")));
    }
    
}
