/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khadamnifournisseur.pkg3a22;
import InterfaceF.FournisseurInterface;
import java.util.List;
import ModelsF.CategoryF;
import ModelsF.Material;
import Services.ServiceFournisseur;
import Util.MaConnexion;
import Services.ServiceMateriel;
import Services.serviceCategorie;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Ajouter matériels (id nom catégories *****ajouter catégorie matériels(3-4)

*/
/**
 *
 * @author Emna
 */
public class KhadamniFournisseur3A22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection cnx = MaConnexion.getInstance().getCnx();
        // TODO code application logic here
        MaConnexion mc = new MaConnexion();
         // service init
        FournisseurInterface f = new ServiceFournisseur();
        FournisseurInterface fm = new ServiceMateriel();
        FournisseurInterface fc = new serviceCategorie();
        //player init
         Material M = new Material();
          Material m = new Material();
          CategoryF c= new CategoryF();
          //M
     M.setNom("poignet");
      M.setId(225);
        M.setPrix(2800);
        //c
         c.setIdC(0);
        c.setNomC("paint");
        c.setDescription("chnia manedrouch");
        c.setProUsage(false);
//        C.setType("Accessoire");
        fc.addCategory(c);
        //m
        m.setId(0);
       
        m.setNom("ampoule");
        m.setPrix(5000);
        m.setQuantity(20);
        m.setCat(c);
       
       //add action
//       fm.addMaterial2(M);
       fm.addMaterial2(m);
        //select
        System.out.println(fm.AfficherMaterial());
//        Material M = new Material();
        M.setId(2);
        CategoryF C = new CategoryF();
//        C.setId(1);
 
//        Material M2 = new Material();
        fm.deleteMaterial(m);
        fm.ModifierMateriel(m);
      
        c.setIdC(0);
        c.setNomC("paint");
        c.setProUsage(false);
//        C.setType("Accessoire");
        fc.addCategory(c);
        
        fc.deleteCategory(2);
        fc.Modifiercategorie(c);
        System.out.println(fc.AfficherCategorie());
//        f.affecterMaterial(M, c);

        
    }
    
}
