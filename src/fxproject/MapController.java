/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxproject;

import Models.application;
import com.sun.java.scene.web.WebViewHelper;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import services.applicationDAO;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class MapController implements Initializable {
  
    @FXML
    private WebView map;
    @FXML
    private TextField OvName;
    @FXML
    private TextField OvNum;
    @FXML
    private TextField Doc;
    @FXML
    private ChoiceBox<String> OvRo;
    private String[] Role={"Plombier","Electrecien","Mecanicien","Bricoleur"};
    @FXML
    private TextField OvLoc;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
  

   @Override
public void initialize(URL url, ResourceBundle rb) {
     
    OvRo.getItems().addAll(Role) ; 
    
    File file = new File("src/map/map.html");
    String fileUrl = file.toURI().toString();

    // Load the file into the WebView's engine
    map.getEngine().load(fileUrl);
    map.getEngine().setOnStatusChanged(event -> {
        if (event.getEventType() == WebEvent.STATUS_CHANGED && "READY".equals(event.getData().toString())) {
            // Execute JavaScript code to add event listener to the map
            map.getEngine().executeScript(
                    "var mymap = L.map('mapid');" +
                    "L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {" +
                    "attribution: 'Map data © <a href=\"https://openstreetmap.org\">OpenStreetMap</a> contributors'," +
                    "maxZoom: 18" +
                    "}).addTo(mymap);" +
                    "var marker = L.marker([37.505, 10.09]).addTo(mymap);" +
                    "var center = mymap.getCenter();" +
                    "var lat = center.lat.toFixed(3);" +
                    "var lng = center.lng.toFixed(3);" +
                    "var latLngElem = document.getElementById('latLng');" +
                    "latLngElem.innerHTML = lat + ', ' + lng;" +
                    "window.center = center;" +
                    "window.lat = lat;" +
                    "window.lng = lng;" +
                    "mymap.on('moveend', function(e) {" +
                    "  console.log('Map moved!');" +
                    "  var center = mymap.getCenter();" +
                    "  var lat = center.lat.toFixed(3);" +
                    "  var lng = center.lng.toFixed(3);" +
                    "  latLngElem.innerHTML = lat + ', ' + lng;" +
                    "  window.center = center;" +
                    "  window.lat = lat;" +
                    "  window.lng = lng;" +
                    "});"
            );
        }
    });
}
    @FXML
    private void setlocation(ActionEvent event) throws IOException, SQLException {
        // Retrieve the variables from JavaScript
      //  var center = map.getEngine().executeScript("window.center");
        String a = map.getEngine().executeScript("window.lat").toString();;
       String b = map.getEngine().executeScript("window.lng").toString();
       
        // Print the values to the console
        
        
        String c= a+" ; "+b;
      System.out.println("Center: " + c );
      OvLoc.setText(c);

    }

    @FXML
    private void btnAppliquerClicked(ActionEvent event) { 
        applicationDAO dao = new applicationDAO(); 
        application newApp = new application(1, OvName.getText(), Integer.parseInt(OvNum.getText()),OvRo.getValue() ,OvLoc.getText(), Doc.getText());
      dao.addApplication(newApp);
           
    }
 
}
