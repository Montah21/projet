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
public class CategorieController implements Initializable {

    @FXML
    private TextField searchCat;
    @FXML
    private Button CATaj;
    @FXML
    private Button CATmod1;
    @FXML
    private Button CATdelet1;
    @FXML
    private Button CATshow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
