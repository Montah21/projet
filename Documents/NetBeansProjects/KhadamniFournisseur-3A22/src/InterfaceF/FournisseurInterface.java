/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceF;
import java.util.List;
import ModelsF.CategoryF;
import ModelsF.Material;
/**
 *
 * @author Emna
 */
public interface FournisseurInterface {
   
    
    //add
    public void addMaterial(Material M);
    public void addMaterial2(Material M);
    
    //list : select
    public List<Material> fetchMaterial();
    
    //affectation
    public void affecterMaterial(Material M, CategoryF C);
}
