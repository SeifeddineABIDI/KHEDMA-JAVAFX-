/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;

import workshop3a24.Entities.Personne;
import workshop3a24.Entities.Projet;
import workshop3a24.Services.ServicePersonne;
import workshop3a24.Services.ServiceProjet;
import workshop3a24.Utils.MyDB;
import java.util.Scanner;



/**
 *
 * @author Mohamed
 */public class Workshop3A24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        ServiceProjet sp = new ServiceProjet();
            while (true) {
      System.out.println("--- Menu ---");
      System.out.println("1. Add a project");
      System.out.println("2. Modify a project");
      System.out.println("3. Display projects");
      System.out.println("4. Delete a project");
      System.out.println("5. Exit");

      int option = sc.nextInt();
      sc.nextLine();

      switch (option) {
          case 1:
  
  System.out.println("Enter the name of the project: ");
  String nom = sc.nextLine();
  System.out.println("Enter the domain of the project: ");
  String domaine = sc.nextLine();
  System.out.println("Enter the name of the client: ");
  String client = sc.nextLine();
  System.out.println("Enter the name of the freelancer: ");
  String freelancer = sc.nextLine();
  System.out.println("Enter the tasks of the project: ");
  String taches = sc.nextLine();
  
  Projet p = new Projet(nom, domaine, client, freelancer, taches);
  sp.add(p);
  break;
        case 2:
        
        System.out.print("Enter the name of the project you want to modify: ");
        String M = sc.nextLine();
        System.out.println("Enter the domain of the project: ");
        String mdomaine = sc.nextLine();
        System.out.println("Enter the name of the client: ");
        String mclient = sc.nextLine();
        System.out.println("Enter the name of the freelancer: ");
        String mfreelancer = sc.nextLine();
        System.out.println("Enter the tasks of the project: ");
        String mtaches = sc.nextLine();
        Projet m = new Projet(M, mdomaine, mclient, mfreelancer, mtaches);
          sp.modifier(M,m);
          
          
  break;
  
        case 3:
          System.out.println(sp.afficher());
 break;
          
          
        case 4:
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the project you want to delete: ");
        String D = scanner.nextLine();
         sp.supprimer(D);
  break;
          
          
        case 5:
          System.exit(0);
          
          
          
        default:
          System.out.println("Invalid option");
          break;
      }
    }

    }
    
}
