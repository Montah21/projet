/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mouty
 */
public class Produit {
    private int id;
    private String nom;
    private float prix;
   private Categorie idc;
   private String ref;
   private int stock;
   private int quantity;

    public Produit() {
    }

    public Produit( String nom, float prix,  String ref, int stock) {
   
        this.nom =nom;
        this.prix =prix;
        this.ref =ref;
        this.stock =stock;
    }


    public Produit(int id, String nom, float prix, Categorie idc, String ref, int stock) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.idc = idc;
        this.ref = ref;
        this.stock = stock;
        this.quantity = 0;
    }

    public Produit(int id, String nom, int prix, String idc, int ref, int stock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
      }
    
    public void setref(String ref) {
        this.ref = ref;
}
       public String getref() {
        return ref;
    }
   public int getstock() {
        return stock;
    }

    public void setstock(int Stock) {
        this.stock = Stock;
    }
    //public Categorie getCategorie() {
        //return categorie;
    //}

   // public void setCategorie(Categorie categorie) {
       // this.categorie = categorie;
    //}
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setIdc(Categorie idc) {
        this.idc = idc;
    }

    public Categorie getIdc() {
        return idc;
    }

 
    

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", idc=" + idc + "," + "quantity=" + quantity + ", ref=" + ref + ", stock=" + stock + '}';
    }

   
    
}
