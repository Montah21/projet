/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import services.ServiceCategorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import models.Produit;
import services.ServicePanier;
 

/**
 * FXML Controller class
 *
 * @author mouty
 */
public class MainfxmlController implements Initializable {
private Produit selectedProduit;

    @FXML
    private ComboBox categorie;
    
    @FXML
    private Button search;
    @FXML
    private TextField rechercheparnom;
    @FXML
    private Button add;
   
    @FXML
    private ListView<String> t1;
    @FXML
    private ListView<String> t2;
    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;
  
    @FXML
    private ImageView image4;
    ;
    @FXML
    private Button moin;
    @FXML
    private Button plus;
    @FXML
    private Button supp;
    @FXML
    private Button commander;
    @FXML
    private ImageView image5;
    @FXML
    private Button totalQuantitiesLabel;
    @FXML
    private AnchorPane totalCost;
    @FXML
    private Button to;
 

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 ServicePanier dao = new ServicePanier();
   List<Produit> Produits = dao.fetchProduit();

    ObservableList<String> items = FXCollections.observableArrayList();
    for (Produit produit : Produits) {
   String item = produit.getNom() + "          " + produit.getPrix() + "              " + produit.getref() + "                " + produit.getstock();
        items.add(item);
    }
    t1.setItems(items);
     
    ObservableList<String> list = FXCollections.observableArrayList("Béton","Acier","Bois","Pierre","Brique/maçonnerie");
    categorie.setItems(list);
 
        

  
        // TODO
    }  
@FXML
private void select(ActionEvent event) throws SQLException {
    ServicePanier dao = new ServicePanier();
    String selectedCategory = categorie.getSelectionModel().getSelectedItem().toString();
    List<Produit> produits = dao.fetchProduitByCategory(getCategoryId(selectedCategory));
    ObservableList<String> items = FXCollections.observableArrayList();
    for (Produit produit : produits) {
        String item = produit.getNom() + "          " + produit.getPrix() + "              " + produit.getref() + "                " + produit.getstock();
        items.add(item);
    }
    t1.setItems(items);
}

private int getCategoryId(String category) {
    Map<String, Integer> categoriesMap = new HashMap<>();
    categoriesMap.put("Béton", 2);
    categoriesMap.put("Acier", 1);
    categoriesMap.put("Bois", 3);
    categoriesMap.put("Pierre", 4);
    categoriesMap.put("Brique/maçonnerie", 5);
    return categoriesMap.get(category);
}



@FXML
private void rchrch(ActionEvent event) throws SQLException {
    ServicePanier dao = new ServicePanier();
    List<Produit> Produits = dao.fetchProduitbyname(rechercheparnom.getText());
    ObservableList<String> items = FXCollections.observableArrayList();
    for (Produit produit : Produits) {
        String item = produit.getNom() + "          " + produit.getPrix() + "              " + produit.getref() + "                " + produit.getstock();
        items.add(item);
    }
    t1.setItems(items);
}


  @FXML
private void AddProductAction(ActionEvent event) {
    String selectedProduct = t1.getSelectionModel().getSelectedItem().trim();
    if (selectedProduct != null) {
        t1.getItems().remove(selectedProduct);
        String productWithCount = selectedProduct + "     (1)";
        boolean existsInT2 = false;
        for (String item : t2.getItems()) {
            if (item.startsWith(selectedProduct)) {
                existsInT2 = true;
                int count = Integer.parseInt(item.substring(item.lastIndexOf("(") + 1, item.lastIndexOf(")"))) + 1;
                t2.getItems().remove(item);
                productWithCount = selectedProduct + "    (" + count + ")";
                break;
            }
        }
        if (!existsInT2) {
            t2.getItems().add(productWithCount);
        } else {
            t2.getItems().add(productWithCount);
        }
    }
    
}


   @FXML
private void SupprimerProduit(ActionEvent event) {
    String selectedProduct = t2.getSelectionModel().getSelectedItem();
    if (selectedProduct != null) {
        t2.getItems().remove(selectedProduct);
        String productWithoutCount = selectedProduct.substring(0, selectedProduct.lastIndexOf("(")).trim();
        t1.getItems().add(productWithoutCount);
    }
}
@FXML
    private void commander(ActionEvent event) throws IOException {
       {
 
   Parent root = FXMLLoader.load(getClass().getResource("payment.fxml"));
   Stage window =(Stage) commander.getScene().getWindow();
   window.setScene(new Scene(root));
} 
}

    @FXML
private void lower(ActionEvent event) {
    String selectedProduct = t2.getSelectionModel().getSelectedItem();
    if (selectedProduct != null) {
        int count = Integer.parseInt(selectedProduct.substring(selectedProduct.lastIndexOf("(") + 1, selectedProduct.lastIndexOf(")")));
        if (count == 1) {
            t2.getItems().remove(selectedProduct);
            t1.getItems().add(selectedProduct.substring(0, selectedProduct.lastIndexOf("(")).trim());
        } else {
            t2.getItems().remove(selectedProduct);
            String productWithCount = selectedProduct.substring(0, selectedProduct.lastIndexOf("(")).trim() + "   (" + (count - 1) + ")";
            t2.getItems().add(productWithCount);
        }
    } 
    
}


@FXML
private void more(ActionEvent event) {
    String selectedProduct = t2.getSelectionModel().getSelectedItem().trim();
    if (selectedProduct != null) {
        int count = Integer.parseInt(selectedProduct.substring(selectedProduct.lastIndexOf("(") + 1, selectedProduct.lastIndexOf(")"))) + 1;
        String updatedProduct = selectedProduct.substring(0, selectedProduct.lastIndexOf("(") + 1) + count + ")";
        t2.getItems().remove(selectedProduct);
        t2.getItems().add(updatedProduct);
    }
 
}

 
private String txtr() {
    int totalQuantities = 0;
    for (String item : t2.getItems()) {
        int count = Integer.parseInt(item.substring(item.lastIndexOf("(") + 1, item.lastIndexOf(")")));
        totalQuantities += count;
    }
    return " " + totalQuantities;
}
@FXML
private void displayTotalQuantities(ActionEvent event) {
    String totalQuantitiesText = txtr();
    totalQuantitiesLabel.setText(totalQuantitiesText);
}

private void totalCost() {
    int totalQuantities = 0;
    for (String item : t2.getItems()) {
        int count = Integer.parseInt(item.substring(item.lastIndexOf("(") + 1, item.lastIndexOf(")")));
        totalQuantities += count;
    }
    int totalCost = 10 * totalQuantities;
    System.out.println("Total Cost: " + totalCost);
    
}


    @FXML
    private void displaytotalCost(ActionEvent event) throws WriterException {
    int totalQuantities = 0;
    for (String item : t2.getItems()) {
        int count = Integer.parseInt(item.substring(item.lastIndexOf("(") + 1, item.lastIndexOf(")")));
        totalQuantities += count;
    }
    int totalCost = 10 * totalQuantities;

    // Generate QR code
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    int width = 300;
    int height = 300;
    String qrCodeText = String.valueOf(totalCost);
    BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, width, height);

    // Convert QR code to image and encode as base64 string
    BufferedImage qrCodeImage = toBufferedImage(bitMatrix);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
        ImageIO.write(qrCodeImage, "png", baos);
    } catch (IOException e) {
        e.printStackTrace();
    }
    byte[] qrCodeBytes = baos.toByteArray();
    String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeBytes);

    // Set text field to display QR code
    String qrCodeHtml = "<img src='data:image/png;base64," + qrCodeBase64 + "'/>";
    to.setText(qrCodeHtml);
}

// Helper method to convert BitMatrix to BufferedImage
private BufferedImage toBufferedImage(BitMatrix matrix) {
    int width = matrix.getWidth();
    int height = matrix.getHeight();
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
        }
    }
    return image;
}



  
  
}





  




