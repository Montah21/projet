/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxproject;

import Models.service;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import services.serviceDAO;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class JointureController implements Initializable {

    @FXML
    private ListView<String> tab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceDAO dao = new serviceDAO();
        List<service> services = null;
        try {
            services = dao.Jointure();
        } catch (SQLException ex) {
            Logger.getLogger(JointureController.class.getName()).log(Level.SEVERE, null, ex);
        }
     //tab.setText(dao.FetchByRole(rl.getText()).toString());
        // TODO
        ObservableList<String> items = FXCollections.observableArrayList();
    for (service service : services) {
        String item = service.getLocation() + " - " +service.getClientPhone() + " - " + service.getServiceName() ;
        items.add(item);
        tab.setItems(items);
        // TODO
    }    
    
}}
