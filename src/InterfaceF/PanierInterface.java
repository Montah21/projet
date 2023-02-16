/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceF;

import ModelsF.Categorie;
import ModelsF.Produit;
import java.util.List;

/**
 *
 * @author mouty
 */
public interface PanierInterface {
     public void addProduit(Produit p);
   
    
    //list : select
    public List<Produit> fetchProduit();
    
    //affectation
    public void affecterProduit(Produit p,Categorie c);
}
