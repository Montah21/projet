/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guii;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class DetailsPublicationsController implements Initializable {

    @FXML
    private Label Content;
    @FXML
    private Button PrecedentButton;
    @FXML
    private Button ModifierButton;
    @FXML
    private Button SupprimerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PrecedentAction(MouseEvent event) {
    }

    @FXML
    private void ButtonModifierClicked(ActionEvent event) {
    }

    @FXML
    private void buttonSupprimerClicked(ActionEvent event) {
    }
    
}
