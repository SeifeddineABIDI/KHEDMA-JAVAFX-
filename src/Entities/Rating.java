/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;


public class Rating {
    
    
    
       private int id_evenement, id_Freelancer,rating;

    public Rating(int id_evenement, int id_Freelancer, int rating) {
        this.id_evenement = id_evenement;
        this.id_Freelancer = id_Freelancer;
        this.rating = rating;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getId_Freelancer() {
        return id_Freelancer;
    }

    public void setId_Freelancer(int id_Freelancer) {
        this.id_Freelancer = id_Freelancer;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
       
       
       
    
    
}


