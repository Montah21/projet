/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.utilisateur;
import Services.UtilisateurService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.runtime.Debug.id;
import sun.security.util.Password;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class PasswordController implements Initializable {
     
   @FXML
    private Label Npassword;

    @FXML
    private Label id;

    @FXML
    private TextField idField;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField passwordField; 

    @FXML
    private Button reinstall;
    
      @FXML
    private Label message;
    

     UtilisateurService us = new UtilisateurService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
  
      
        // on doit crée une méthode rest dans le service utilisateur 
    
        
  @FXML
   void reinstallPassword(ActionEvent event) {
    int idu = Integer.parseInt(idField.getText());
    String newPassword = passwordField.getText();
    boolean success = resetPassword(idu,newPassword);
    if (success) {
        message.setText("Le mot de passe est changé avec succées .");
    } else {
        message.setText("ce user n'existe pas dans notre système.");
    }
}

private boolean resetPassword(int id, String Password) {
    return us.resetPassword(id, Password);
}
    
    
    
    
 }
    
    





    
    
    

