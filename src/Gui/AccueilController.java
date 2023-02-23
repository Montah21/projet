/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class AccueilController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private Button btn_add;
    @FXML
    private Button btn_display;
    
    public void initialize(URL url, ResourceBundle rb) {
        // TOO
    
      
    btn_add.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/AjouterComment.fxml"));
                Scene scene = new Scene(page1);
            } catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_display.setOnAction(event -> {
            try {FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Accueil.fxml"));
                Parent page2 = FXMLLoader.load(getClass().getResource("/AccueilController.fxml"));
                // Give the controller access to the main app.
//                AfficherPersonneController controller =loader.getController();
//                controller.setListData(new ListData());
                Scene scene = new Scene(page2);
               
            } catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); }    

    
    }
