/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.utilisateur;
import Services.UtilisateurService;
import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class ModifierUtilisateurController implements Initializable {
    
    
     @FXML
    private Label Role;

    @FXML
    private Label cin;

    @FXML
    private TextField cinField;

    @FXML
    private Label control;

    @FXML
    private Button myButton;

      @FXML
    private TextField rooleField;

    @FXML
    private Label nom;

    @FXML
    private TextField nomField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label password;

    @FXML
    private Label prenom;

    @FXML
    private TextField prenomField;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Label tel;

    @FXML
    private TextField telField;

   
    
   UtilisateurService us = new UtilisateurService();
    
      
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
        
    }
    
    @FXML
    void modify(ActionEvent event) {
        
       if (cinField.getText().isEmpty()|| nomField.getText().isEmpty()||prenomField.getText().isEmpty()|| passField.getText().isEmpty()||telField.getText().isEmpty()){
                  control.setText("field is empty");
          }
        else{
        
        utilisateur u = new utilisateur(Integer.parseInt(cinField.getText()),nomField.getText(),prenomField.getText(),passField.getText(),rooleField.getText(),Integer.parseInt(telField.getText()));
       
        us.modifierUtilisateur(u);
        reset();
    }

    }
    
    
    private void reset() {
         
        nomField.setText("");
        prenomField.setText("");
        cinField.setText("");
        rooleField.setText("");
        passField.setText("");
        telField.setText("");
        
    }
 
   
    
    
}    
    

         
    


    

