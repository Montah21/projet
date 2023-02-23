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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Emna
 */
public class AjouterMController implements Initializable {

    @FXML
    private TextField AJmatNAME;
    @FXML
    private TextField ajoutmatQUAN;
    @FXML
    private TextField ajoutPRIX;
    @FXML
    private TextField ajoutCAT;
    @FXML
    private Button AJOUmat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
