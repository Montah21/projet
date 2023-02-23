/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.Avis;
import java.util.List;

/**
 *
 * @author Mariem
 */
public interface Aviss {
    
    //ajout 
    public void AjouterAvis(Avis A);
    //2: afficher tt les avis 
    public List<Avis > AfficherAvis();
    //3: modifier 
   public void ModifierAvis(Avis A);
    
    //4: supprimer 
   public void SupprimerAvis(Avis A); 
     
   //5: Get by id ( affichage d un seul avis par le cin donnée) 
  // public Avis AfficherAvis(int cinn); 
   
   //6: filter : afficher les avis d un user selon son role donnée
   
   public List<Avis> afficherAvisbyroles(String role);

}


