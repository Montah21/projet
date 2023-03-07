/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import ServicesETinter.ServiceC;
import Entity.categorie;
import java.lang.*;
import ServicesETinter.serviceControlMAt;
import Util.MyDB;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Emna
 */
public class CatController implements Initializable {
    ObservableList<categorie>  listC = FXCollections.observableArrayList();

    @FXML
    private TextField catQUALIT;
    @FXML
    private ComboBox<String> comboNOMC;
    @FXML
    private ComboBox<String> comboPRO;
    @FXML
    private Button BackCHOME;
    @FXML
    private Button ClearC;
    @FXML
    private Button ajoutC;
    @FXML
    private Button RC;
    @FXML
    private Button MC;
    @FXML
    private Button DC;
    @FXML
    private TextField searchCAT;
    @FXML
    private Label catlab;
    @FXML
    private Label ulab;
    @FXML
    private Label qlab;
    @FXML
    private TableColumn<categorie, String> NomC;
    @FXML
    private TableColumn<categorie, String> upro;
    @FXML
    private TableColumn<categorie, String> qual;
    @FXML
    private TableView<categorie> tablC;
    private Statement ste;
    private categorie c;
    String query = null;
    Connection connection = null;
    Connection cnx = MyDB.getInsatnce().getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    categorie CAT = null;
    @FXML
    private TableColumn<categorie, Integer> idcc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Electricité","peinture","sanitaire","mecanique","construction");
        comboNOMC.setItems(list);
        loadC();
        refresh();
    }  
    private void refresh() {
        try {
            listC.clear();
            
        String query ="select categorie.fournisseur,materiel.nom ,categorie.matID,categorie.idc, categorie.nomc, categorie.usagePro, categorie.qualite from categorie INNER JOIN materiel on categorie.matID =voyage.id ";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
              listC.add(new  categorie(
                        resultSet.getInt("fournisseur"),
                        resultSet.getInt("matid"),
                        resultSet.getInt("idc"),
                        resultSet.getString("nomc"),
                        
                        resultSet.getString("usagePro"),
                        resultSet.getString("qualite")
                        
                        )); 
               tablC.setItems(listC);
            }
        } catch (SQLException ex) {
    System.err.println("SQLException: " + ex.getMessage());
    System.err.println("SQLState: " + ex.getSQLState());
    System.err.println("VendorError: " + ex.getErrorCode()); 
        }      
    }
     private void loadC() {

            ServiceC v=new ServiceC();
            connection= MyDB.getInsatnce().getConnection();
            refresh();
//            NomC.setCellValueFactory(new PropertyValueFactory<>("catégorie"));
            qual.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
            
            comboNOMC.setItems(FXCollections.observableArrayList(v.getAll()));
            System.out.println(NomC.getText());
            comboPRO.setItems(FXCollections.observableArrayList(v.getAll()));
            System.out.println(upro.getText());

        }

    @FXML
    private void recherche(ActionEvent event) {
    }

    @FXML
    private void SupprimerM(MouseEvent event) {
         if (!tablC.getSelectionModel().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sur de vouloir supprimer la reservation du " + tablC.getSelectionModel().getSelectedItem().getNomc()+ " ?", ButtonType.YES, ButtonType.NO);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    ServiceC r=new ServiceC();
    r.Supprimercat(tablC.getSelectionModel().getSelectedItem().getIdc());
    };
    refresh();
    }
    }

    @FXML
    private void addC(ActionEvent event) { 
        
        
            connection= MyDB.getInsatnce().getConnection();
            String pro = (String)comboPRO.getValue();
            String cat = (String)comboNOMC.getValue();
            String q =qual.getText();
            ServiceC rec = new ServiceC();
            ObservableList<categorie> ch= rec.chercherCat(pro);

            ServiceC sc= new ServiceC();
//            int Age =Integer.valueOf(Rage.getText());
            if( cat.isEmpty()){
                Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setContentText("categorie class est vide");   
                 alert.showAndWait();
    
            }else if(pro.isEmpty()){
                    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("usage pro class est vide");   
                    alert.showAndWait(); 


                    categorie re = new categorie(cat,pro,q);
                    System.out.println(re.toString());
                    rec.AjouterCat(re);
                        notiff();
                        refresh();
                         alert.setContentText("categorie ajouté");
                         alert.showAndWait();
            }
        }
    
    

        private void notiff()
    {
        ServiceC sv = new ServiceC();
        categorie RV = new categorie();
         String nomC = NomC.getText();
        //int y=sv.calculnb((Destination.getText()));
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Bienvenu A I-WORK");
        tray.setMessage("L'ajout de la Ctaegorie"+ NomC+ " a ete effectué!");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(2000));
    }
    
    

    @FXML
    private void actualiser(ActionEvent event) {
         loadC();
        refresh();
    }

    @FXML
    private void ModC(ActionEvent event)throws SQLException {
    
        serviceControlMAt sc= new serviceControlMAt();   

        categorie voy=new categorie();
      ServiceC rec = new ServiceC();
   voy=tablC.getSelectionModel().getSelectedItem();
   voy.setIdc(tablC.getSelectionModel().getSelectedItem().getIdc()); 
   String nomc = (String)comboNOMC.getValue();
   String usage = (String)comboPRO.getValue();
   voy.setNomc(nomc);
   voy.setUsagePro(usage);
   String q =qual.getText();
   int A=Integer.parseInt(q);
        ObservableList<categorie> Idc=rec.chercherCat(nomc);
   voy.setQualite(q);
   
if( usage.isEmpty()){
    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Travel class vides");   
    alert.showAndWait();
    
}else if( nomc.isEmpty()){
    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Travel class vides");   
    alert.showAndWait();  
} else {
    categorie re = new categorie(nomc,usage,q);
                    System.out.println(re.toString());
                    rec.ModifierCat(re);
                        notiff();
                        refresh();
                        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);

                        alert.setContentText("categorie modifié");
                        alert.showAndWait();
             }
    
    
    
  
   
}
    
  private void populateTable(ObservableList<categorie> branlist){
       tablC.setItems(branlist);
   
       } 
   public void setnomCat(String query ) {
        this.comboNOMC.setValue(query);
    }

    @FXML
    private void backH(ActionEvent event)throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("FourHome.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show(); 
    }
}
    
  
    
    
    
    
    
    
    
    
    
    
    




