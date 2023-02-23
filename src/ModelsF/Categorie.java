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
public class Categorie {
    private int id ;
    private String libelle;
    private String ref;
    private int quantite;

    public Categorie() {
    }

    public Categorie(String libelle, String ref) {
        this.libelle = libelle;
        this.ref = ref;
        this.quantite = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", libelle=" + libelle + ", ref=" + ref + ", quantite=" + quantite + '}';
    }
    
    
}
