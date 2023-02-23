/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;

import java.util.List;
import workshop3a24.Entities.Tache;

/**
 *
 * @author Mohamed
 */
public interface IService<T> {
    public void add(T t);
    public List<T> afficher();
    public void modifier(T t,int ID);
    public void supprimer(String D);
    
}
