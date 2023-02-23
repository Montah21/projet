/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.User;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class AfficherCommentController implements Initializable {
     @FXML
    private Label nomLabel;
    @FXML
    private TextField content;
    @FXML
   private Button btn_cmnt;
   
   private ListView<String> listView = new ListView<>();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      // Créer une Label
    Label label = new Label("Ajouter Commentaire");

        // Ajouter la Label à un conteneur
    Pane pane = new Pane();
    pane.getChildren().add(label);


    }    

   
    
}
