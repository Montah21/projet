/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Avis;
import Services.AvisService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class AjouterAvisController implements Initializable {

    
    @FXML
    private Button add;

    @FXML
    private Label comment;

    @FXML
    private TextField commentfield;

    @FXML
    private TextField idAfield;

    @FXML
    private TextField idUfield;

    @FXML
    private Label id_avis;

    @FXML
    private Label iduser;

    @FXML
    private RadioButton radioNs;

    @FXML
    private RadioButton radioS;

    @FXML
    private Label roole;

    @FXML
    private TextField roolefield;

    @FXML
    private Label satif;

    
    
    AvisService As = new AvisService ();
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    void Adduser(ActionEvent event) {
        
        Avis A = new Avis();
       // A.setId_avis((idAfield.getText()));
      // A.setUser(Integer.parseInt(idUfield.getText()));
        A.setRole(roolefield.getText());
        A.setComment(commentfield.getText());
        
            As.AjouterAvis(A);
          //  reset();
        
    }
     
     private void reset() {
        idAfield.setText("");
        roolefield.setText("");
        commentfield.setText("");
    }
    
}
    
    
    
    
    





   
