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
    private Categorie categorie;

    public Produit() {
    }

    public Produit( String nom, float prix,Categorie categorie) {
        
        this.nom = nom;
        this.prix = prix;
        this.categorie=categorie;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", categorie=" + categorie + '}';
    }

    
    
    
}
