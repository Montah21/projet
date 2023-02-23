/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsF;

/**
 *
 * @author mouty
 */
public class Produitaffecte {
    private int idpoduit;
    private String nom;
    private float prix;
   private String ref;
   private int stock;

    public Produitaffecte() {
    }

    public Produitaffecte( String nom, float prix, int id, String re, int stock) {
        
        this.nom = nom;
        this.prix = prix;
       
    }

    public Produitaffecte(String fenetre, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdproduit() {
        return idpoduit;
    }

    public void setIdproduit(int id) {
        this.idpoduit = idpoduit;
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

    public void setPrix(float prix) {
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


}
