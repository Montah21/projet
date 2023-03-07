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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class AfficherUtilisateurController implements Initializable {
   
    
    @FXML
    private Label control;

    
    @FXML
    private ListView<String> Listusers;

    @FXML
    private Button back;

    @FXML
    private Button delete;
   
    UtilisateurService us = new UtilisateurService();
         
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //UtilisateurService us = new UtilisateurService();
 
         List<utilisateur> users = us.afficherUtilisateur();

           ObservableList<String> items = FXCollections.observableArrayList();
           
           for (utilisateur u : users ) {
        String item = u.getId()+ " - " + u. getCin() + " - " + u.getNom() + " - " + u.getPrenom() + " - " + u.getPassword() + " - " + u.getRole()+ " - " + u.getTel();
        items.add(item);
    }    
    Listusers.setItems(items);   
    
    
        }


    @FXML
    void returntoAdd(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/AjouterUtilisateur.fxml"));
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

    }
    
      @FXML
    void removeUser(MouseEvent event) {
    
        
      String selectedItem = Listusers.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        int id = Integer.parseInt(selectedItem.split(" - ")[0]);
        utilisateur user = us.afficherUtilisateur( id);
        us.supprimerUtilisateur(user);
        Listusers.getItems().remove(selectedItem);
         control.setText("User deleted successfully!");
    } else {
         control.setText("Please select a user to delete!");
    }





    }
}   

   
    
    
    
    
  



    



    
   
