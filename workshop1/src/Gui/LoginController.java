/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.utilisateur;
import Services.UtilisateurService;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Mariem
 */

 
 

public class LoginController implements Initializable {

    
    
    UtilisateurService us = new UtilisateurService(); 
     
     @FXML
    private Button Password;

    @FXML
    private Button button_log;

    @FXML
    private Button button_sign;

    @FXML
    private TextField cinField;

    @FXML
    private Label cinLabel;

    @FXML
    private TextField passField;

    @FXML
    private Label passwordLabel;
    
    @FXML
    private Label control;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @FXML
     void login(ActionEvent event) throws IOException {
    String cin = cinField.getText();
    String password = passField.getText();

    if (cin.isEmpty() || password.isEmpty()) {
        control.setText("One or more fields are empty");
        return;
    }

    // Retrieve the user with the given cin from the database
    utilisateur  user = us.getUtilisateurByCin(Integer.parseInt(cin));

    if (user == null) {
        control.setText("Invalid cin or password");
        return;
    }

    // Compare the entered password with the stored password
    if (user.getPassword().equals(password)) {
        control.setText("Login successful");
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/AjouterUtilisateur.fxml"));
      
    } else {
        control.setText("Invalid cin or password");
    }
}
    
        
        
    

    @FXML
    void forgetPass(ActionEvent event) throws IOException {

         FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/password.fxml"));
                                    Parent root = loader.load();
                                 Scene scene = new Scene(root);  
                                  Stage primaryStage = new Stage();
                                 primaryStage.setScene(scene);  
                                 primaryStage.setTitle("password forgot");  
                                 primaryStage.centerOnScreen();  
                                 primaryStage.setResizable(false);  
                                 primaryStage.setOpacity(1);  
                                 primaryStage.show();  
                                 Node node = (Node) event.getSource();
                                 Stage stage = (Stage) node.getScene().getWindow();
                                 stage.close();
        
        
        
      }

    @FXML
    void sign(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/AjouterUtilisateur.fxml"));
                                  Parent root = loader.load();
                                 Scene scene = new Scene(root);  
                                 Stage primaryStage = new Stage();
                                 primaryStage.setScene(scene);  
                                 primaryStage.setTitle("User Login");  
                                 primaryStage.centerOnScreen();  
                                 primaryStage.setResizable(false);  
                                 primaryStage.setOpacity(1);  
                                 primaryStage.show();  
                                 Node node = (Node) event.getSource();
                                 Stage stage = (Stage) node.getScene().getWindow();
                                 stage.close();
        
        
    }
    

    
  
}

    
    
    
    
    

     

    
    

   /*   @FXML
    void sign(ActionEvent event) {
        
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AjouterUtilisateur.fxml"));
             
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } */

    







