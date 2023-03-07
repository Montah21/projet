/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Categorie;
import models.Produit;

/**
 *
 * @author mouty
 */
public interface CategorieInterface {
    public void addCategorie(Categorie c);
    public List<Categorie> fetchCategories();
    public void affecterProduit(Categorie c, Produit p);
    public void afficherCategorieByName(String nom);
     public void deleteCategorie(int id);
     public void modifierCategorie(Categorie c);
    
}
