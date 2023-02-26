/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Manel
 */
public class PostManagerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         // Set up the UI elements
        Label titleLabel = new Label("Post Manager");
        titleLabel.setFont(new javafx.scene.text.Font("Arial", 24));

        Button addButton = new Button("Add Post");
        addButton.setPrefWidth(100);

        Button deleteButton = new Button("Delete Post");
        deleteButton.setPrefWidth(100);

        Label titleLabel2 = new Label("Title:");
        TextField titleTextField = new TextField();

        Label contentLabel = new Label("Content:");
        TextArea contentTextArea = new TextArea();

        VBox vBox = new VBox(10, titleLabel2, titleTextField, contentLabel, contentTextArea);
        vBox.setPadding(new javafx.geometry.Insets(10));
        vBox.setAlignment(Pos.TOP_LEFT);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(100);
        gridPane.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(300);
        gridPane.getColumnConstraints().add(column2);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(30);
        gridPane.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(350);
        gridPane.getRowConstraints().add(row2);

        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(addButton, 0, 1);
        gridPane.add(deleteButton, 1, 1);
        gridPane.add(vBox, 0, 2, 2, 1);

        // Create the scene and add it to the stage
        Scene scene = new Scene(gridPane, 500, 400);
        primaryStage.setTitle("Post Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
   
    
    }    

    private static class primaryStage {

        private static void setTitle(String post_Manager) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setScene(Scene scene) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void show() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public primaryStage() {
        }
    }
        
    
}
