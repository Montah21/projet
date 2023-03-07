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
public class Categorie {
    private int idc ;
    private String libelle;
    private int quantite;

    public Categorie() {
    }

    public Categorie(String libelle, int quantite) {
        this.libelle = libelle;
        this.quantite = quantite;
    }
    
    
    
    public Categorie(int idc, String libelle, int quantite) {
        this.idc = idc;
        this.libelle = libelle;
        this.quantite = quantite;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

  

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idcategorie=" + idc+ ", libelle=" + libelle + ", quantite=" + quantite + '}';
    }
    
    
}
