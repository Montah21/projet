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
import java.util.Locale.Category;
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
        // TODO code application logic here
         // service init
        FournisseurInterface ps = new ServiceFournisseur();
        
        //player init
//        Player p = new Player();
//        p.setName("Sadio Mane");
//        p.setNumber(19);
//        p.setAge(28);
//        
//        //add action
//        ps.addPlayer2(p);
        
        //select
        //System.out.println(ps.fetchPlayers());
        Material M = new Material();
        M.setId(2);
        CategoryF C = new CategoryF();
        C.setId(1);
        
        ps.affecterMaterial(M, C);
        
    }
    
}
