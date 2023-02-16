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

/**
 *
 * @author Safe
 */
public class Khedma {

    public static void main(String[] args) {
        //Metier m = new  Metier("test","ok","ok");
        //SousMetier m = new SousMetier(19,"jaaw","welyeey","3bouda");
            //ServiceMetier sm1 = new ServiceMetier();
        ServiceSousMetier sm1 = new ServiceSousMetier();
        System.out.println(sm1.afficherById(16));
        //System.out.println( sm1.afficher());
       // System.out.println(m.toString()); 
    }
    
}
