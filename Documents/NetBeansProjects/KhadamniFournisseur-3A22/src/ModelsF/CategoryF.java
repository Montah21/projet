/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsF;

/**
 *
 * @author Emna
 */
public class CategoryF {
     //att
    private int id,quantite;
    private String nom;
    private String[] Type={"Accessoire","Protection","outilMeca","outilElec","outilPlomb","ConstructionMP"};
    private boolean ProUsage;

//const

    public CategoryF() {
    }

    public CategoryF(int id, int quantite, String nom, boolean ProUsage) {
        this.id = id;
        this.quantite = quantite;
        this.nom = nom;
        this.ProUsage = ProUsage;
    }
    //Getters

    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getNom() {
        return nom;
    }

    public String[] getType() {
        return Type;
    }

    public boolean isProUsage() {
        return ProUsage;
    }
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String[] Type) {
        this.Type = Type;
    }

    public void setProUsage(boolean ProUsage) {
        this.ProUsage = ProUsage;
    }
    //Display

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}



