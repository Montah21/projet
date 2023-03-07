/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxproject;
import services.applicationDAO;
import Models.application;
import Models.service;
import services.serviceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;
import Interface.ApplicationInterface;
import Interface.ServiceInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FXMLController implements Initializable {


  
    @FXML
    private TextField ID_Ov;
    @FXML
    private TextField OvName;
    @FXML
    private TextField OvNum;
    @FXML
    private TextField Doc;
    @FXML
     TextField OvLoc;
    @FXML
    private ChoiceBox<String> OvRo;
    private String[] Role={"Plombier","Electrecien","Mecanicien","Bricoleur"};
    @FXML
     Pane Prv;
    @FXML
    private Label Rs;
    @FXML
    private Button Loc;
    

    /**
     * Initializes the controller class.
     */
 
 public void  setText(String text) throws SQLException {
     OvLoc.setText(text);
 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   OvRo.getItems().addAll(Role) ; 
   
  //   MapController.setloc(x);
  //   OvLoc.setText(s);
    }    

    @FXML
    private void btnAppliquerClicked(ActionEvent event) {
        applicationDAO dao = new applicationDAO(); 
        application newApp = new application(1, OvName.getText(), Integer.parseInt(OvNum.getText()),OvRo.getValue() ,OvLoc.getText(), Doc.getText());
      dao.addApplication(newApp);
           
        Rs.setText("Ajout Terminé");
       
    }

    @FXML
    private void btnEffacerClicked(ActionEvent event) {
    /*    ID_Ov.setText("");
        OvName.setText("");
        OvNum.setText("");
      
        OvLoc.setText("");
        Doc.setText("");
        Rs.setText("Effacé!");*/
    }

   /* @FXML
    private void location(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("map.fxml"));
        Parent root = loader.load();
        MapController mapController = loader.getController();
       //bsh tpassi valeur mn interface ll interface taamel haka w fl interface the taamel public function t affecty feha 
     
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        
       OvLoc.setText("15");
         
    }*/
    @FXML
private void location(ActionEvent event) throws IOException {
  /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("map.fxml"));
    Parent root = loader.load();
    MapController mapController = loader.getController();
     
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
    
  // wait for the user to set the location
    
    // Set the center value to the text field

  */
}







    
}
