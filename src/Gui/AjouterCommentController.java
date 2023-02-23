/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.User;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class AjouterCommentController implements Initializable {
    private Button btn_cmnt;
    private TextField content;
    private TextField post;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btn_cmnt.setOnAction(event -> {
            
            User u= new User(content.getText(), post.getText());
            //PersonneDao pdao = PersonneDao.getInstance();
            //pdao.insert(p);
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(" Comment Added  successfully!");
        alert.show();
        post.setText("");
        content.setText("");
        });
        
    }    
    
}
