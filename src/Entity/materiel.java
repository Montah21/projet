/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Emna
 */
public class materiel {
    int idm;
    String nomM;
    float prix;
    int quantite;
    String valabilite;
    String image;

    public materiel(String nomM, float prix, int quantite, String valabilite, String image) {
        this.nomM = nomM;
        this.prix = prix;
        this.quantite = quantite;
        this.valabilite = valabilite;
        this.image = image;
    }

    public materiel(int idm, String nomM, float prix, int quantite, String valabilite, String image) {
        this.idm = idm;
        this.nomM = nomM;
        this.prix = prix;
        this.quantite = quantite;
        this.valabilite = valabilite;
        this.image = image;
    }

    public materiel() {
    }

    @Override
    public String toString() {
        return "materiel{" + "idm=" + idm + ", nomM=" + nomM + ", prix=" + prix + ", quantite=" + quantite + ", valabilite" + valabilite + ", image=" + image + '}';
    }

    public int getIdm() {
        return idm;
    }

    public String getNomM() {
        return nomM;
    }

    public float getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getValabilite() {
        return valabilite;
    }

    public String getImage() {
        return image;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setValabilite(String valabilite) {
        this.valabilite = valabilite;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idm;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final materiel other = (materiel) obj;
        return this.idm == other.idm;
    }
    
    
    
    
    
    
}
