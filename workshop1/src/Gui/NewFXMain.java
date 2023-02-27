package Gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class NewFXMain extends Application {

 
    @Override
    public void start(Stage primaryStage) throws Exception {
      // Parent root = FXMLLoader.load(getClass().getResource("../Gui/AjouterUtilisateur.fxml"));
       //Parent root = FXMLLoader.load(getClass().getResource("../Gui/AfficherUtilisateur.fxml"));
       //Parent root = FXMLLoader.load(getClass().getResource("ModifierUtilisateur.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("../Gui/Login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../Gui/Password.fxml"));
        Scene scene = new Scene(root,600,400); 
        primaryStage.setTitle("Gérer ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


       /*
      public void signUp(Stage stage ){
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign_up");
        alert.setHeaderText("you are about to register ");
        alert.setContentText("Do you agree that you enter a correct informations ?!!");
        
        if(alert.showAndWait().get()== ButtonType.YES){
            System.out.println("you have been successfully added to our application thank u !");
            stage.close();}
     }*/



}




        //alert sur le butn cancel
        
        /*
        stage.setOnCloseRequest(event -> {
            event.consume();
            signUp(stage);
            });
     
        
        
        /*interface Modifier ******************************/ 
      /*  @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("Gui/ModifierUtilisateur.fxml"));
        Scene scene = new Scene(root,600,400); 
        primaryStage.setTitle("MOdifier Utilisateurs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
        
     
     
     
    
    
    
    
    
        
    
   
    
   
    

