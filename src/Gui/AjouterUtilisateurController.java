/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.utilisateur;
import Services.UtilisateurService;
import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import static java.awt.SystemColor.control;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class AjouterUtilisateurController implements Initializable {
    
   UtilisateurService us = new UtilisateurService();
   
     @FXML
    private Label discin;

    @FXML
    private Label disid;

    @FXML
    private Label disnom;

    @FXML
    private Label dispass;

    @FXML
    private Label disprenom;

    @FXML
    private Label disrole;

    @FXML
    private Label distel;
    
   
   
    @FXML
    private Button show;
   
    @FXML
    private Button afficherbtn;
    
     @FXML
    private Button myButton;
    
       @FXML
    private Label control;

    
    @FXML
    private Label cin;

    @FXML
    private TextField cinFiled;


    private TextField idField;

   

    @FXML
    private Label nom;

    @FXML
    private TextField nomField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label password;
    @FXML
    private Label mail;

    @FXML
    private TextField mailField;

    @FXML
    private Label prenom;

    @FXML
    private TextField prenomField;

    @FXML
    private Label role;

    @FXML
    private TextField roleField;

    @FXML
    private Label tel;

    @FXML
    private TextField telField;
    @FXML
    private ImageView image;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }
   
    
    
    @FXML
    void afficherUtilisateur(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/AfficherUtilisateur.fxml"));
                                 Parent root = loader.load();
                                 Scene scene = new Scene(root);  
                                  Stage primaryStage = new Stage();
                                 primaryStage.setScene(scene);  
                                 primaryStage.setTitle("Fiche patient");  
                                 primaryStage.centerOnScreen();  
                                 primaryStage.setResizable(false);  
                                 primaryStage.setOpacity(1);  
                                 primaryStage.show();  
                                 Node node = (Node) event.getSource();
                                 Stage stage = (Stage) node.getScene().getWindow();
                                 stage.close();
                                 //rechercher(ab);
            
  

    }

    
    
    @FXML
    void sign_up(ActionEvent event) {

         if (cinFiled.getText().length() !=8|| nomField.getText().isEmpty()||prenomField.getText().isEmpty()||mailField.getText().isEmpty()|| passField.getText().isEmpty()||roleField.getText().isEmpty()||telField.getText().length() > 10){
         control.setText(" Error : field is empty or u haven't respect the number of digits");
        }
        
          else{
       
        utilisateur u = new utilisateur();
        u.setCin(Integer.parseInt(cinFiled.getText()));
        u.setNom(nomField.getText());
        u.setPrenom(prenomField.getText());
        u.setMail(mailField.getText());
        u.setPassword(passField.getText());
        u.setRole(roleField.getText());
        u.setTel(Integer.parseInt(telField.getText()));
        us.ajouterUtilisateur2(u);
        reset();
    }}
            
         private void reset() { 
        nomField.setText("");
        prenomField.setText("");
        mailField.setText("");
        cinFiled.setText("");
        passField.setText("");
        roleField.setText("");
        telField.setText("");
        
         }
       
        
     @FXML
    void displayAction(ActionEvent event) {
        
      // disid.setText(u.getId()); 
       discin.setText(cinFiled.getText());
       disnom.setText(nomField.getText());  
       disprenom.setText(prenomField.getText());
       dispass.setText(passField.getText());
       disrole.setText(roleField.getText());
       distel.setText(telField.getText());
    }
    
}
    

