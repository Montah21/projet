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
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.PostImp;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class ListPublicationController implements Initializable {

    @FXML
    private ListView<String> listPublications;
    private PostService postService= new PostImp();
    @FXML
    private AnchorPane listPublicationAnchorPane;
    @FXML
    private Button PrecedentButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> itemsList=postService.getPostByIdUser(1).stream().map(p->p.getContent()).collect(Collectors.toList());;
        listPublications.getItems().addAll(itemsList);
        listPublications.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listPublications.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
        // TODO
    }    
    private  void selectionChanged(ObservableValue<? extends String> observable,String oldVal,String newVal){
        ObservableList<String> selectedItems=listPublications.getSelectionModel().getSelectedItems();
        String getSelectionItem=(selectedItems.isEmpty()) ? "no item ":selectedItems.toString();
    }

    @FXML
    private void PrecedentAction(MouseEvent event) {
         try {
             Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("listPublications.fxml"));
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
    
    

