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
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;

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
    private ChoiceBox<String> OuvrierNum;
    private ArrayList<String> OvNum = new ArrayList<String>();
    @FXML
    private TextField ClientNum;
    @FXML
    private WebView map;
    /**
     * Initializes the controller class.
     */
    
    public void  setText(String text) throws SQLException {
        
          
      File file = new File("src/map/map1.html");
    String fileUrl = file.toURI().toString();

    map.getEngine().load(fileUrl); // Load the HTML file into the WebView

    // Define the JavaScript function to add a marker to the map
    String script = "function addMarker(lat, lng, iconUrl, iconSize, iconAnchor, message) {" +
                    "    var icon = L.icon({ iconUrl: iconUrl, iconSize: iconSize, iconAnchor: iconAnchor });" +
                    "    var marker = L.marker([lat, lng], { icon: icon }).addTo(mymap);" +
             "    marker.bindPopup(message);" +
                    "}";

    // Wait for the HTML page to finish loading
    
        
        
     
        
        
        
        x=text;
   applicationDAO dao = new applicationDAO();
        List<application> applications=dao.FetchByRole(x);
     //tab.setText(dao.FetchByRole(rl.getText()).toString());
        // TODO
        ObservableList<String> items = FXCollections.observableArrayList();
    for (application application : applications) {
        String item = application.getName() + "   -    " + application.getNum() ;
        items.add(item);
        tab.setItems(items);
        String[] parts = application.getLocation().split(";");
        double firstDouble = Double.parseDouble(parts[0].trim());
double secondDouble = Double.parseDouble(parts[1].trim());
System.out.println("First Double: " + firstDouble);
System.out.println("Second Double: " + secondDouble);
OvNum.add(Integer.toString(application.getNum()));

   map.getEngine().getLoadWorker().stateProperty().addListener(
        (observable, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                // Execute the JavaScript function to add the marker
                map.getEngine().executeScript(script + "addMarker("+firstDouble+","+ secondDouble+", 'marker-icon.png', [20, 30], [15, 15], 'Nom :  "+application.getName()+"  Num Telephone :  "+application.getNum()+"');");
            }
        }
    );
   
    }   
    
   OuvrierNum.getItems().addAll(OvNum) ; 
 
   } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    
  
        
 
    }   

    @FXML
    private void btnAppliquerClicked(ActionEvent event) throws SQLException {
         applicationDAO dao = new applicationDAO();
        serviceDAO t=new serviceDAO();
       
        
       
      service p= new service(Client_ID.getText(),Loc.getText(),x,Integer.parseInt(ClientNum.getText()), dao.FetchIDByNum(Integer.parseInt(OuvrierNum.getValue())));
    t.addService(p);
        
    }
    
    
}
