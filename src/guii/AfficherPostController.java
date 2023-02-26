/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guii;

import Gui.NewFXMain;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.event.DocumentEvent.EventType;
import sun.reflect.misc.MethodUtil;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class AfficherPostController implements Initializable {

    @FXML
    private Label Publicaton;
    @FXML
    private AnchorPane Accueil;
    @FXML
    private ListView<String> MyListView;
    @FXML
    private Label NomProduitLabel;
    @FXML
    private Button ajouterPublicationButton;
    @FXML
    private Button publicationListViewButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Accueil(MouseEvent event) {
    }




    @FXML
    private void MyIListViewOpened(KeyEvent event) {
    }

    @FXML
    private void MyAjouterPublicationInterfaceOpened(MouseEvent event) {
       try {
             Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("AjoutPost.fxml"));
        // borderpane.setCenter(signUpPage);
        Scene scene = new Scene(signUpPage);
        stage = (Stage)ajouterPublicationButton.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showView(Stage primaryStage,String fileXmlName,String title ){
         
    }

    @FXML
    private void publicationListViewAction(MouseEvent event) {
        try {
             Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("listandDetailsPublications.fxml"));
        // borderpane.setCenter(signUpPage);
        Scene scene = new Scene(signUpPage);
        stage = (Stage)ajouterPublicationButton.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
