/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationalinfo5;

import interfaces.CategorieInterface;
import interfaces.PanierInterface;
import java.util.List;
import models.Produit;
import models.Categorie;
import services.ServicePanier;
import services.ServiceCategorie;
/**
 *
 * @author admin
 */
public class JavaApplicationALINFO5 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
   
   Produit p;
   Categorie c = new Categorie(1,"hhhh",52);
    p = new Produit(5,"jiji",17,c,"h78",150);
ServicePanier sp = new ServicePanier();
ServiceCategorie cs = new ServiceCategorie();

 
sp.addProduit(p);
}

}
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
     
    
 
