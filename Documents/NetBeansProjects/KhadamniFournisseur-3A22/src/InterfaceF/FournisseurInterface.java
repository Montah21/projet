/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceF;
import java.util.List;
import ModelsF.CategoryF;
import ModelsF.Material;
import Services.serviceCategorie;
import Services.ServiceMateriel;
import Util.MaConnexion;
import Services.ServiceFournisseur;
/**
 *
 * @author Emna
 */
public interface FournisseurInterface {
   
    
    //add
//    public void addMaterial(Material M);
    public void addMaterial2(Material M);
    
    //list : select
//    public List<Material> fetchMaterial();
    
    //affectation
//    public void affecterMaterial(Material M, CategoryF C);

    public void deleteMaterial(Material M);

    public void addCategory(CategoryF c);

   
   
     public List <Material>AfficherMaterial();
   public void ModifierMateriel(Material M);
    
//    public List<CategoryF> fetchCategoryF();
    
   
   

    public void deleteCategory(int idC);
    public void Modifiercategorie(CategoryF c);
   
    public List<CategoryF> AfficherCategorie();
}
