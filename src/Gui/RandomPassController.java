/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class RandomPassController implements Initializable {
     @FXML
    private Label email;

    @FXML
    private TextField emailfield;

    @FXML
    private Button nextbutton;

    @FXML
    private Button sendbutton;

    @FXML
    private Label control;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void next(ActionEvent event) throws IOException {
        
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/Password.fxml"));
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

    @FXML
    void send(ActionEvent event)  {

        if (emailfield.getText().isEmpty()){
         control.setText(" Error : field is empty or u haven't respect the number of digits");
        }
        else {
        String newPassword = generateRandomPassword(8); // Generate a random password
        ResetPassApi.sendPasswordResetEmail(emailfield.getText(), newPassword); // Send the password to the user's email address
        UtilisateurService us = new UtilisateurService();
        us.resetPassword(emailfield.getText(), newPassword); // Update the user's password in the database
    }
        
       
 
    }
    
    private static String generateRandomPassword(int length) {
        String alphanumericChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * alphanumericChars.length());
            sb.append(alphanumericChars.charAt(randomIndex));
        }
        return sb.toString();
        
}
    
    
}

