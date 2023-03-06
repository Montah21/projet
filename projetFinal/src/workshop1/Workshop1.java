/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import Models.Avis;
import Models.utilisateur;
import Services.AvisService;
import Services.UtilisateurService;



/**
 *
 * @author Mariem
 */
public class Workshop1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UtilisateurService us = new UtilisateurService();
        //utilisateur u1 = new utilisateur(130237,"azouzzi", "helaa","mdp","plombier",205197496);
        //utilisateur u2 = new utilisateur(1,130237,"mabrouki","hayfa","mdp2","admin",97605480);
        //utilisateur u3 = new utilisateur(4,70450,"hhihi", "loulou","mdp40","client",66605480);
        //***************** tester l ajout user *****************///
        
        // us.ajouterUtilisateur2(u3);
          
        //************* tester la modifcation de user ******************************//
            
           //us.modifierUtilisateur(u2);
       
         
        
             // ************** test de supprimer user *****************//
         
                   //  us.supprimerUtilisateur(u3);
       
        // **************** ***** test de l'affichage **************//
           //us.afficherUtilisateur().forEach(System.out::println);
        
           
        //********************** test de l'affichage par id ***********//
        
        //System.out.println(us.afficherUtilisateur(2));
        
          /****************** test afficher par role : filter ******************/// 
        
        //System.out.println(us.afficherUsersByRoole("plombier"));
        
        
        //*********** changer le mot de passe *********************************//
         // us.resetPassword( 4, "hello kity");
          
       




        //2nd entity 
        
        //AvisService As = new AvisService();
        //Avis a1 = new Avis (u3,"cliente"," non_satisfait","mauvais_service");
       // System.out.println(a1);
       // Avis a2 = new Avis (u3,"client","satisfait","bonne_service");

       ///////////// ajouter avis ///////////////
        //As.AjouterAvis(a2);
       
       
       //***************************modifier avis********************************* //
       //As.ModifierAvis(a1);
       
       // ***************** afficher lavis **************************//
         //As.AfficherAvis().forEach(System.out::println);
       
      //********************** test de l'affichage par id ***********//
        
        //System.out.println(us.AfficherAvis(2));
        
          /****************** test afficher par role : filter ******************/// 
        
        //System.out.println(us.afficherUsersByRoole("plombier"));   
         
     //************************* supprimer Avis **********************//
       //  As.SupprimerAvis(a1);

       
     //************************* filtrer  Avis **********************//
         
      // System.out.println(As.afficherAvisbyroles("client"));
     
       //************************* Get Avis by id  **********************//
       
     // System.out.print(As.afficherAvis());
      
       
       
    }
    
    
}
