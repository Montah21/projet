/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mouty
 */
public class MainFXMLController implements Initializable {

    @FXML
    private Label titre;
    @FXML
    private TextField tfrecherche;
    @FXML
    private ListView<?> tab1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAjouterClicked(ActionEvent event) {
     
    }

    @FXML
    private void clicktopass(ActionEvent event) {
    
    }

    @FXML
    private void btnChercherClicked(ActionEvent event) {
    }
    }
    

