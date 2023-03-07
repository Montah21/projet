/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxproject;
import services.applicationDAO;
import Models.application;
import Models.service;
import services.serviceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;
import Interface.ApplicationInterface;
import Interface.ServiceInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.P;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FXML1Controller implements Initializable {

    @FXML
    private ChoiceBox<String> rl;
   private String[] Role={"Plombier","Electrecien","Mecanicien","Bricoleur"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rl.getItems().addAll(Role) ; 
        // TODO
    }    
    public String getSourceText() {
        return rl.getValue();
    }

    @FXML
    private void btnChercherClicked(ActionEvent event) throws SQLException {
  try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheRole.fxml"));
        Parent root = loader.load();
       //bsh tpassi valeur mn interface ll interface taamel haka w fl interface the taamel public function t affecty feha 
        AfficheRoleController AfficheRoleController = loader.getController();
            AfficheRoleController.setText(rl.getValue());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
     //   primaryStage.setTitle("Hello World!");
      //  primaryStage.setScene(scene);
     //   primaryStage.show();//applicationDAO dao = new applicationDAO();
     //tab.setText(dao.FetchByRole(rl.getText()).toString());
   
    }
    
}
