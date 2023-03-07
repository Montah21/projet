/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import models.Produit;
import java.util.List;
import models.Categorie;

/**
 *
 * @author mouty
 */

/**
 *
 * @author wiemhjiri
 */

public interface PanierInterface {
public void addProduit(Produit p);
public void modifierProduit(Produit p);
public void deleteProduit(Produit p);
 public List<Produit> fetchProduitbyname(String nom); 
public List<Produit> fetchProduit();
public void affecterProduit(Produit p,Categorie c);
List<Produit> fetchProduitByCategory(int idc);

}

