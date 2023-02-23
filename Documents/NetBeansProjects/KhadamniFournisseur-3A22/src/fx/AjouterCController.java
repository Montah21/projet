/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Emna
 */
public class AjouterCController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField NOMajouC;
    @FXML
    private TextArea AJOUdescription;
    @FXML
    private RadioButton radioAJOUC;
    @FXML
    private Button AJOUTC2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
