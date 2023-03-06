/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Avis;
import Models.utilisateur;
import Services.AvisService;
import Services.UtilisateurService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.net.HttpURLConnection ;
//import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class AjouterAvisController implements Initializable {


    @FXML
    private Button add;

    @FXML
    private Label comment;

    @FXML
    private TextField commentfield;

    @FXML
    private RadioButton radioNs;

    @FXML
    private RadioButton radioS;

    @FXML
    private Label roole;

    @FXML
    private TextField roolefield;

    @FXML
    private Label satif;

    AvisService As = new AvisService ();
    UtilisateurService us = new UtilisateurService();
    // utilisateur u ; <-- Vous n'utilisez pas cet utilisateur ici

    HttpServletRequest request; // Déclarez request comme variable de classe pour y accéder depuis d'autres méthodes

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        // Vous pouvez initialiser la variable request dans la méthode initialize
    }

    @FXML
    void Adduser(ActionEvent event) {
       
    Avis A = new Avis();
    A.setRole(roolefield.getText());
    A.setNv_satif("test");
    A.setComment(commentfield.getText());
    verifAvis(A);
    As.AjouterAvis(A);
    reset();
/*
    // Retrieve the session object for the user
    HttpSession session = request.getSession();

    // Retrieve the user ID from the session object
    Integer userID = (Integer) session.getAttribute("userID");

    if (userID != null) {
        // Retrieve the user object from the database using the user ID
        utilisateur user = us.afficherUtilisateur(userID);

        // Set the user object for the Avis object
        A.setUser(user);
    } else {
        // handle case where userID is null
    }*/
}

     private void verifAvis(Avis A) {
        if (radioNs.isSelected()) {
            A.setNv_satif("Non satisfait");
            A.setComment(commentfield.getText());
        } else if (radioS.isSelected()) {
            A.setNv_satif("Satisfait");
            A.setComment(commentfield.getText());
        } else {
            // si aucun radio button n'est sélectionné, on ne fait rien
        }
    }

    private void reset() {
        roolefield.setText("");
        commentfield.setText("");
    }
    
    
    
    
    
    
    
    
    }

   


 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    @FXML
    private Button add;

    @FXML
    private Label comment;

    @FXML
    private TextField commentfield;


  
    @FXML
    private RadioButton radioNs;

    @FXML
    private RadioButton radioS;

    @FXML
    private Label roole;

    @FXML
    private TextField roolefield;

    @FXML
    private Label satif;

    
    
    AvisService As = new AvisService ();
    UtilisateurService us = new UtilisateurService();
    utilisateur u ;

    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   @FXML
void Adduser(ActionEvent event) {

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  

    Avis A = new Avis();
    A.setRole(roolefield.getText());
    A.setNv_satif("test");
    A.setComment(commentfield.getText());
    verifAvis(A);
    As.AjouterAvis(A);
    reset();

    // Retrieve the session object for the user
    HttpSession session = request.getSession();

    // Retrieve the user ID from the session object
    int userID = (int) session.getAttribute("userID");

    // Retrieve the user object from the database using the user ID
    int userId = us.getIDByCin(cin);

    // Set the user object for the Avis object
    A.setUser(new utilisateur(userId,"", "", "", ""));

}


private void verifAvis(Avis A) {

    if (radioNs.isSelected()) {
        A.setNv_satif("Non satisfait");
        A.setComment(commentfield.getText());
    } else if (radioS.isSelected()) {
        A.setNv_satif("Satisfait");
        A.setComment(commentfield.getText());
    } else {
        // si aucun radio button n'est sélectionné, on ne fait rien
    }
}


private void reset() {
    roolefield.setText("");
    commentfield.setText("");
}*/

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*@FXML
    void Adduser(ActionEvent event) {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  
        
        Avis A = new Avis();
        A.setUser(u);
        A.setRole(roolefield.getText());
        A.setNv_satif("test");
        A.setComment(commentfield.getText());
         verifAvis(A);
        As.AjouterAvis(A);
          reset();
    

  // Retrieve the session object for the user
   HttpSession session = request.getSession();
 
  // Retrieve the user ID from the session object
int userID = (int) session.getAttribute("userID");

// Retrieve the user object from the database using the user ID
int userId = us.getIDByCin(userID);

// Set the user object for the Avis object
A.setUser(u);
           
        
    }
     
    
    private void verifAvis(Avis A) {
        
    if(radioNs.isSelected()){
        A.setNv_satif("Non satisfait");
        A.setComment(commentfield.getText());
    } else if (radioS.isSelected()){
        A.setNv_satif("Satisfait");
        A.setComment(commentfield.getText());
    } else {
        // si aucun radio button n'est sélectionné, on ne fait rien
    }
}*/
    
    
     

    
    
    





   
