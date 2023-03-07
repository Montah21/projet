/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Entity.materiel;
import ServicesETinter.serviceControlMAt;
import ServicesETinter.serviceM;
import Util.MyDB;
import java.lang.*;
import Util.MyDB;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import javafx.stage.StageStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Emna
 */
public class MatController implements Initializable {

   
    /**************************/
//     private String Image[] imagesArray = {ampoule, poignet, marteau, lunettes,vis};

    @FXML
    private ComboBox<String> comboNOM;
    @FXML
    private ComboBox<String> comboV;
    @FXML
    private TextField prixM;
    @FXML
    private TextField quanM;
    @FXML
    private TextField img;
    @FXML
    private Button CLM;
    @FXML
    private Button ajoutM;
    @FXML
    private Button RM;
    @FXML
    private Button ModM;
    @FXML
    private Button DM;
    @FXML
    private Button BackMHOME;
    @FXML
    private Button ADDimg;
    public static String idxx;

    materiel mm = new materiel();

    private Statement ste;
    private materiel m;
    String query = null;
    Connection connection = MyDB.getInsatnce().getConnection();
   Connection cnx = MyDB.getInsatnce().getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    materiel MAT = null;
        ObservableList<materiel> ListM = FXCollections.observableArrayList();

    @FXML
    private TableColumn<materiel, String> NomM;
    @FXML
    private TableColumn<materiel, Float> PrixM;
     @FXML
    private TableColumn<materiel, Integer> Quant;
      @FXML
    private TableColumn<materiel, String> Valab;
       @FXML
    private TableColumn<materiel, String> im;
    @FXML
    private TextField RechM;
    ObservableList<materiel> listM;
    @FXML
    private TableView<materiel> tablM;
    @FXML
    private ImageView image;
    @FXML
    private TableColumn<materiel,Integer > idm;
    
    @FXML
    private Label matlab;
    @FXML
    private Label prlab;
    @FXML
    private Label quantlab;
    @FXML
    private Label vlab;
    @FXML
    private Label imlab;
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> list = FXCollections.observableArrayList("ampoule", "poignet", "cables","marteau","vis","protection");
        comboNOM.setItems(list); 
         ObservableList<String> listV = FXCollections.observableArrayList("Disponible", "stock épuisé", "soon");
        comboV.setItems(list); 
        loadM();
        refresh();


    }  
    public void delete() {
        serviceM sm = new serviceM();
        
        sm.SupprimerMat(tablM.getSelectionModel().getSelectedItem().getIdm());
        System.out.println(tablM.getSelectionModel().getSelectedItem().getIdm());
      
        System.out.println();
    }


    @FXML
    private void supprimerM(ActionEvent event) {
        
         delete();
        tablM.getItems().removeAll(tablM.getSelectionModel().getSelectedItem());
        System.out.println(tablM);
        tablM.refresh();
    }

    @FXML
    private void Add(ActionEvent event) {
        String nomM = comboNOM.getValue();
        String prix = PrixM.getText();
        String quantite = Quant.getText();
        String Valabilite = (String) comboV.getValue();
        String image = im.getText();
        serviceControlMAt sc = new serviceControlMAt();
        serviceM ps = new serviceM();

        if (nomM.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("champs vides");
            alert.setTitle("Prolem");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (!sc.isNumeric(prix)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("prix doit étre un nombre");
            alert.showAndWait();
        } else {
            materiel v = new materiel(nomM, Float.parseFloat(prix), Integer.parseInt(quantite), Valabilite, image);
            ps.AjouterMat(v);
            
            refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("succes");
            alert.setHeaderText(null);
            alert.setContentText("materiel ajouteé");
            alert.showAndWait();
        }
    }

    @FXML
    private void modM(ActionEvent event) {
    serviceControlMAt sc = new serviceControlMAt();

        materiel Mat = new materiel();
        serviceM sv = new serviceM();
        Mat = tablM.getSelectionModel().getSelectedItem();
        Mat.setIdm(tablM.getSelectionModel().getSelectedItem().getIdm());
        String nomM = (String) comboNOM.getValue();
        Mat.setValabilite(nomM);

        String Valabilite = (String) comboV.getValue();
        Mat.setValabilite(Valabilite);
        Mat.setImage(im.getText());
        if (!sc.isNumeric(prixM.getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("prix doit étre un nombre");
            alert.showAndWait();
        } else {
            Mat.setPrix(Float.parseFloat(prixM.getText()));
            sv.ModifierMat(Mat);
            loadM();
            refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("succes");
            alert.setHeaderText(null);
            alert.setContentText("materiel Modifieé Avec succ");
            alert.showAndWait();
        }
         if (!sc.isNumeric(Quant.getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("quantite doit étre un nombre");
            alert.showAndWait();
        } else {
            Mat.setPrix(Integer.parseInt(Quant.getText()));
            sv.ModifierMat(Mat);
            loadM();
            refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("succes");
            alert.setHeaderText(null);
            alert.setContentText("Voyage Modifier Avec succ");
            alert.showAndWait();
        }

    }

    @FXML
    private void listM(javafx.scene.input.MouseEvent event) {
        try {
            materiel MAT = tablM.getSelectionModel().getSelectedItem();
//            int q =MAT.getQuantite();
//            Quant.setContextMenu(q);
//            Quant.setText(MAT.getQuantite());
            String n =MAT.getNomM();
            comboNOM.setValue(n);

            String c = MAT.getValabilite();
            comboV.setValue(c);
            prixM.setText(String.valueOf(MAT.getPrix()));
            String path = "C:\\\\\\\\xampp\\\\\\\\htdocs\\\\\\\\Version-Integre\\\\\\\\public\\\\\\\\uploads\\\\\\\\"+MAT.getImage();
            File file = new File(path);
            img.setText(path);
//           image imge= new image(file.toURI().toString());
//           image.setImage(imge);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @FXML
    private void Actualiser(ActionEvent event) {
         loadM();
        refresh();
        
        
    }
    private void refresh() {
        try {
            ListM.clear();

            query = "select * from materiel";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ListM.add(new materiel(
                        resultSet.getInt("idm"),
                        resultSet.getString("nom"),
                        resultSet.getFloat("prix"),
                        resultSet.getInt("quantite"),
                        
                        resultSet.getString("valabilite"),
                        resultSet.getString("image")
                ));
                tablM.setItems(ListM);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void loadM() {
        materiel v = new materiel();
        connection = MyDB.getInsatnce().getConnection();
        idm.setCellValueFactory(new PropertyValueFactory<>("idm"));
        NomM.setCellValueFactory(new PropertyValueFactory<>("nom"));
            PrixM.setCellValueFactory(new PropertyValueFactory<>("prix"));
        Quant.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        Valab.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        im.setCellValueFactory(new PropertyValueFactory<>("image"));
    
    }

    @FXML
    private void clear(ActionEvent event) {
         
    }

    @FXML
    private void ADDimg(ActionEvent event)throws FileNotFoundException, IOException {
      Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        //String DBPath = "C:\\\\xampp\\\\htdocs\\\\Version-Integre\\\\public\\\\uploads\\\\" + x + ".jpg";
                String DBPath = "" + x + ".jpg";

        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path = file.getAbsolutePath();
            String res;
            int len;
            len=path.length();

            res = path.substring(47,len);
            System.out.println(res);
            Image imge = new Image(file.toURI().toString());
            image.setImage(imge);
            img.setText(res);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();

        } else {
            System.out.println("error");

        }
    }

    @FXML
    private void RechercheM(KeyEvent event) {
        serviceM se = new serviceM();
        String chaine = RechM.getText();
        populateTable(se.chercherVoyage(chaine));
    }
    private void populateTable(ObservableList<materiel> branlist) {
        tablM.setItems(branlist);

    }
     private void notiff() {
        serviceM sv = new serviceM();
        materiel v = new materiel();
        String nomM = NomM.getText();
        int y = sv.calculnb((NomM.getText()));
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("attention");
        tray.setMessage("il existe " + y + " voyages a " + nomM + "");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(2000));
    }

    
    private void notif(MouseEvent event) {
        notiff();
    }

    
//     public void setMateriel() {
//        this.Materiel.setVisible(false);
//    }

    public void setSupprimerMat() {
        this.DM.setVisible(false);
    }

    public void setM(materiel m) {
        this.m = m;
    }

    public void setNomM() {
        this.NomM.setVisible(false);
    }

    public void setPrix() {
        this.prixM.setVisible(false);
    }

   

    public void setImage() {
        this.ADDimg.setVisible(false);

    }

    public void setImg() {
        this.img.setVisible(false);

    }

    public void setAdd() {
        this.ajoutM.setVisible(false);

    }

    public void setModM() {
        this.ModM.setVisible(false);

    }

    public void setComboV() {
        this.comboV.setVisible(false);
    }

    public void setActualiser() {
        this.RM.setVisible(false);

    }

    public void setNomMText() {
        this.matlab.setVisible(false);

    }

   

   

    public void setValabilitetext() {
        this.vlab.setVisible(false);
    }

    public void setImagetext() {
        this.imlab.setVisible(false);
    }

    public void setPrixText() {
        this.prlab.setVisible(false);
    }

    public void setquant(boolean T) {
        this.quantlab.setVisible(T);
    }

    @FXML
    private void RechercheM(ActionEvent event) {
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
    
    
    
        
      
	

   
    
    

     
    
    

