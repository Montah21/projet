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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Emna
 */
public class MaterielController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button MaterAJ;
    @FXML
    private Button MODFmat;
    @FXML
    private Button DELETmat;
    @FXML
    private TextField serachMAT;
    @FXML
    private Button searchMATB;
    @FXML
    private ListView<String> listMat1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
