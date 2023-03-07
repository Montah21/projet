/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.utilisateur;
import Utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class DashBoardController implements Initializable {

     @FXML
    private ListView<utilisateur> Listview;

    @FXML
    private TilePane TilePane;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
            list_affiche();
        } catch (SQLException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void list_affiche() throws SQLException {
        Connection cnx = MyConnection.getInstance().getCnx();
        ObservableList<utilisateur> users = FXCollections.observableArrayList();
        PreparedStatement stmt = null;
        ResultSet rst = null;

        String req = "SELECT * FROM utilisateur WHERE role = ?";
        stmt = cnx.prepareStatement(req);
        stmt.setString(1, "client");
        rst = stmt.executeQuery();

        while (rst.next()) {
            utilisateur u = new utilisateur(
                    rst.getInt("id"),
                    rst.getInt("cin"),
                    rst.getString("nom"),
                    rst.getString("prenom"),
                    rst.getString("mail"),
                    rst.getString("password"),
                    rst.getString("role"),
                    rst.getInt("tel")
            );
            users.add(u);
        }

        // personnalisation de l'affichage des cellules
        Listview.setCellFactory(new Callback<ListView<utilisateur>, ListCell<utilisateur>>() {
            @Override
            public ListCell<utilisateur> call(ListView<utilisateur> param) {
                return new ListCell<utilisateur>() {
                    @Override
                    protected void updateItem(utilisateur u, boolean empty) {
                        super.updateItem(u, empty);
                        if (empty || u == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(u.getNom() + " " + u.getPrenom() + " " + u.getMail() + " " + u.getTel());

                            // création d'une image pour chaque cellule
                            ImageView imageView = new ImageView(new Image(getClass().getResource("images.jpg").toExternalForm()));

                            // personnalisation de l'image
                            imageView.setFitHeight(50);
                            imageView.setFitWidth(50);

                            // création d'un conteneur pour l'image et le nom de l'utilisateur
                            VBox vbox = new VBox(imageView);
                            vbox.setAlignment(Pos.CENTER);
                            vbox.setSpacing(5);

                            // ajout du conteneur à la cellule
                            setGraphic(vbox);
                        }
                    }
                };
            }
        });

        // ajout des utilisateurs à la liste
        Listview.setItems(users);
    }  
        

    }    
    
    
    
    
    
    

