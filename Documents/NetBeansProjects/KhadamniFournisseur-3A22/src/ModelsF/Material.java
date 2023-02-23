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

    public static void add(Material mt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Att
    
    private int id;
    private String nom;
    private float prix; 
    private int quantity;
    private CategoryF cat ;

    public Material(int id, String nom, float prix, int quantity, CategoryF cat) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantity = quantity;
        this.cat = cat;
    }
   
    

    public Material() {
    }

    public Material( String nom, float prix, CategoryF cat) {
        this.nom = nom;
        this.prix = prix;
        this.cat = cat;
    }

    public Material( int id, String nom, float prix, CategoryF cat) {
       
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.cat = cat; 
    }

    public CategoryF getCat() {
        return cat;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

  

    public void setCat(CategoryF cat) {
        this.cat = cat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantity=" + quantity + ", cat=" + cat + '}';
    }

   

    

}
 
   
    
    
    
    

