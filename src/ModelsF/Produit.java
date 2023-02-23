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
public class Produit {
    private int id;
    private String nom;
    private float prix;
   private int id_categorie;
   private String ref;
   private int stock;

    public Produit() {
    }

    public Produit( String nom, float prix, int id, String ref, int id_categorie, int stock) {
        
        this.nom = nom;
        this.prix = prix;
        this.id_categorie=0;
       
    }

    public Produit(String fenetre, int i) {
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

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    

   // @Override
   // public String toString() {
       // return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", categorie=" + categorie + '}';
    //}

    
    
    
}
