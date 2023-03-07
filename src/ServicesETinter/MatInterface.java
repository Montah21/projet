/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesETinter;

import java.util.List;
import static javafx.scene.input.KeyCode.V;

/**
 *
 * @author Emna
 */
public interface MatInterface<M> {
    
     public void AjouterMat(M m);
    public void ModifierMat(M m);
    public void SupprimerMat(int ID);
    public List<M>RecupererMat();
    public List<M>RecupererMatTrieNom();  //exemple trie 
    public List<M>RechercheMat(String Dest);  
    public List<M>RecupererMatDisponible();  
    public List<M>RecupererMatNonDisponible();  
    public List<M>RecupererMatBientotdisponible();  
    public List<M>listeMat();  
    
}
