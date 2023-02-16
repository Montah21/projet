/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsF;

/*
Ajouter matériels (id nom catégories *****ajouter catégorie matériels(3-4)

*/

/**
 *
 * @author Emna
 */
public class Material {
    //Att
   
    private int id;
    private String nom;
    private float prix;
    private CategoryF categorie;
//Const
    public Material() {
    }

    public Material(int id, String nom, float prix, CategoryF categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
    }
//Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public CategoryF getCategorie() {
        return categorie;
    }
    
    //Setters 

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setCategorie(CategoryF categorie) {
        this.categorie = categorie;
    }
    //Display

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
