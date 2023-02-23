/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Models.utilisateur;
import java.util.List;

/**
 *
 * @author Mariem
 */
public interface User {
    
    // public void ajouterUtilisateur( utilisateur u);
    
    //1.1:Create methode2
    public void ajouterUtilisateur2(utilisateur u);
    //2: Read
    public List<utilisateur > afficherUtilisateur();
    //3: modifier 
    public void modifierUtilisateur(utilisateur u);
    
    //4: supprimer 
     public void supprimerUtilisateur(utilisateur u); 
     
     // 5: affichage d'un seul user Get by id //
     
    public utilisateur afficherUtilisateur(int idu ); 
     
    // 6: filter //
    
   public List<utilisateur> afficherUsersByRoole(String role); 
      
}

    
    

