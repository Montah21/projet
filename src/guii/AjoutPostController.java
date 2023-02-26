/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guii;

import Gui.NewFXMain;
import interfaces.PostService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Post;
import models.User;
import services.PostImp;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class AjoutPostController implements Initializable {

    @FXML
    private TextArea content;
    @FXML
    private Button PublierButton;
    @FXML
    private Button PrecedentButton;
    private PostService PostService=new PostImp();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PublierAction(MouseEvent event) {
        Post p =new Post();
        p.setContent(content.getText());
        p.setImageUrl("image");
        p.setUser(new User(1));
        PostService.addPost(p);
        try {
             Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("ListandDetailsPublications.fxml"));
        // borderpane.setCenter(signUpPage);
        Scene scene = new Scene(signUpPage);
        stage = (Stage)PublierButton.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return;
    }

    @FXML
    private void PrecedentAction(MouseEvent event) {
        try {
             Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("AfficherPost.fxml"));
        // borderpane.setCenter(signUpPage);
        Scene scene = new Scene(signUpPage);
        stage = (Stage)PrecedentButton.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
