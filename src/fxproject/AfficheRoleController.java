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
import Interface.ApplicationInterface;
import Interface.ServiceInterface;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class AfficheRoleController implements Initializable {

    @FXML
    private ListView<String> tab;
    String x;
    
    @FXML
    private TextField Client_ID;
    @FXML
    private TextField Loc;
    @FXML
    private TextField OuvrierNum;
    @FXML
    private TextField ClientNum;
    /**
     * Initializes the controller class.
     */
    
    public void  setText(String text) throws SQLException {
        x=text;
   applicationDAO dao = new applicationDAO();
        List<application> applications=dao.FetchByRole(x);
     //tab.setText(dao.FetchByRole(rl.getText()).toString());
        // TODO
        ObservableList<String> items = FXCollections.observableArrayList();
    for (application application : applications) {
        String item = application.getName() + " - " + application.getLocation() + " - " + application.getNum() ;
        items.add(item);
        tab.setItems(items);
    }     
          
// applicationDAO dao = new applicationDAO();
       // List<application> applications=dao.FetchByRole(x);
    }
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
     
 
    }   

    @FXML
    private void btnAppliquerClicked(ActionEvent event) throws SQLException {
         applicationDAO dao = new applicationDAO();
        serviceDAO t=new serviceDAO();
       
        
       
      service p= new service(Client_ID.getText(),Loc.getText(),x,Integer.parseInt(ClientNum.getText()), dao.FetchIDByNum(Integer.parseInt(OuvrierNum.getText())));
    t.addService(p);
        
    }
    
    
}
