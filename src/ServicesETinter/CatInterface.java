/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesETinter;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Emna
 */
public interface CatInterface<C> {
     public void AjouterCat(C c);
     public void ModifierCat(C c);
     public void Supprimercat(int idc);
     public List<C> RecupererCat();
//      public List<String> getAll();
       public ObservableList<C> chercherCat(String chaine);       
             
             
             
             
}
