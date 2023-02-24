/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khedma;

import Entities.Metier;
import Entities.SousMetier;
import Services.ServiceMetier;
import Services.ServiceSousMetier;
import javafx.collections.ObservableList;

/**
 *
 * @author Safe
 */
public class Khedma {

    public static void main(String[] args) {
        //Metier m = new  Metier(7,"abo maheer","ok","oui","C:\\Users\\Safe\\Documents\\NetBeansProjects\\khedma\\src\\Images\\logo 5edma tr.png");
       //SousMetier m = new SousMetier(25,"aaa","aaaa");
            ServiceSousMetier sm1 = new ServiceSousMetier();
        //ServiceMetier sm1 = new ServiceMetier();
       
        System.out.println(sm1.afficherAllNames());
        System.out.println(sm1.afficherAllNamesExcept("manar"));
       // System.out.println(m.toString()); 
    }
    
}
