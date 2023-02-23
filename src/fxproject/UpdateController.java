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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class UpdateController implements Initializable {

    @FXML
    private TextField ID_Ov;
    @FXML
    private TextField OvName;
    @FXML
    private TextField OvNum;
    @FXML
    private TextField Doc;
    @FXML
    private TextField OvLoc;
    @FXML
    private TextField OvRo;
    @FXML
    private Pane Prv;
    @FXML
    private Label Rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAppliquerClicked(ActionEvent event) {
                applicationDAO dao = new applicationDAO(); 
        application newApp = new application(ID_Ov.getText(), OvName.getText(), Integer.parseInt(OvNum.getText()),OvRo.getText() ,OvLoc.getText(), Doc.getText());
    dao.affecterApplication(newApp);
    }

    @FXML
    private void btnEffacerClicked(ActionEvent event) {
        
    }
    
}
