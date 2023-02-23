/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Mariem
 */

 
   
   
   

public class LoginController implements Initializable {

     @FXML
    private Button button_log;

    @FXML
    private Button button_sign;

    @FXML
    private TextField iduFiled;

    @FXML
    private ImageView image;

    @FXML
    private ImageView image1;

    @FXML
    private TextField passField;

    
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    


 @FXML
    void Login(ActionEvent event) {

    
    
    
    
    }

    @FXML
    void sign(ActionEvent event) {
        
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AjouterUtilisateur.fxml"));
             
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }




}


