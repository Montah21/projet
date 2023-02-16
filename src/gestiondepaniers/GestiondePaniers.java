/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondepaniers;

import InterfaceF.PanierInterface;
import ModelsF.Categorie;
import ModelsF.Produit;
import ServicesPannier.ServicePanier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mouty
 */
public class GestiondePaniers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ServicePanier ps = new ServicePanier();
        
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
       // Produit p = new Produit("mannet",20);
       // Produit p1 = new Produit("pale",30);
       // Produit p2 = new Produit("fourchette",50);
        
       // ps.addProduit(p);
        //ps.addProduit(p1);
        //ps.addProduit(p2);
        //List<Produit> Produits = new ArrayList<>();
       // Produits=ps.fetchProduit();
        //System.out.println(Produits);
         
        Produit p = new Produit();
        p.setId(2);
        
       Categorie c = new Categorie();
       
        c.setId(1);
        
        ps.affecterProduit(p, c);
        
        
       
        
       // ps.affecterMaterial(M, C);
        // TODO code application logic here
    }
    
}
