/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

     import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequestWrapper;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import Services.PasswordHasher;
import Services.UtilisateurService;
import Models.utilisateur;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
import java.net.HttpURLConnection;
//import javafx.concurrent.Worker;
import javafx.scene.web.WebView;
//import jdk.nashorn.api.scripting.JSObject;


/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class Login2Controller implements Initializable {

    
    @FXML
    private TextField capresponse;
    
    @FXML
    private Label control;
    
    UtilisateurService us = new UtilisateurService(); 
    @FXML
    private Button Password;

    @FXML
    private Button button_log;

    @FXML
    private Button button_sign;

    @FXML
    private TextField cinField;

    @FXML
    private Label cinLabel;

    @FXML
    private PasswordField passField;

    @FXML
    private Label passwordLabel;

     
    private HttpSession session;
   
   // private String captchaResponse;
    //private final String siteKey = "6Lek1NAkAAAAAHVyGISMpvhMzJtmA2aBUlYVDh7k";
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       /*  cap.getEngine().load("https://www.google.com/recaptcha/api/fallback?k=" + siteKey);
        cap.getEngine().setJavaScriptEnabled(true);
        cap.getEngine().getLoadWorker().stateProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject window = (JSObject) cap.getEngine().executeScript("window");
                        window.setMember("java", new JavaBridge());
                    }
                });*/    
        // TODO
    }
   /* public class JavaBridge {

        public void setCaptchaResponse(String response) {
            captchaResponse = response;
        }

        public void recaptchaCallback(String response) {
            setCaptchaResponse(response);
        }

        public String getCaptchaResponse() {
            return captchaResponse;
        }
    }*/
    
    //Méthode pour vérifier si le captcha a été rempli correctement
    /*public boolean verifyCaptcha() {
    boolean success = false;
    String captchaResponse = capresponse.getText();
    try {
        URL url = new URL("https://www.google.com/recaptcha/api/siteverify");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String secretKey = "6Lek1NAkAAAAADtFlwrmQA2uhItC39NW5wxb3C6c";
        String postParams = "secret=" + secretKey + "&response=" + captchaResponse;
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(postParams.getBytes());
        os.flush();
        os.close();
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            success = jsonObject.get("success").getAsBoolean();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return success;
}*/


    @FXML
     void Login(ActionEvent event) {
    UtilisateurService us = new UtilisateurService();
    String cin = cinField.getText();
    String password = passField.getText();
    String hashedPassword = PasswordHasher.hashPassword(password);
    if (cin.isEmpty() || password.isEmpty()) {
        control.setText("One or more fields are empty");
        return;
    }
    // Retrieve the user with the given cin from the database
    utilisateur user = us.getUtilisateurByCin(Integer.parseInt(cin));
    if (user == null) {
        control.setText("Invalid cin or password");
        return;
    }
    // Compare the entered password with the stored password
    if (user.getPassword().equals(hashedPassword)) {
        control.setText("Login successful");
        // Load the FXML file based on the user's role
        String fxmlFile;
        if (user.getRole().equals("client")) {
            fxmlFile = "../fxproject/fxml1.fxml";
        } else if (user.getRole().equals("ouvrier")) {
            fxmlFile = "../fxproject/ouvrier.fxml"; //  
        } else if (user.getRole().equals("admin")){
            fxmlFile = "../Gui/DashBoard.fxml"; // page naarech chkoun momkn sahbi
        } else if (user.getRole().equals("fournisseur")){
            fxmlFile = "../Gui/fourhome.fxml"; //page manel
        } else {
            control.setText("Invalid user role");
            return;
        }   
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            // Store the user ID in the session
            us.storeUserIDInSession(Integer.parseInt(cin));
            // Close the current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            control.setText("Error loading FXML file: " + e.getMessage());
        }
    } else {
        control.setText("Invalid cin or password");
    }
}

    
  

    
    
    @FXML
    void forgetPass(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/password.fxml"));
                                    Parent root = loader.load();
                                 Scene scene = new Scene(root);  
                                  Stage primaryStage = new Stage();
                                 primaryStage.setScene(scene);  
                                 primaryStage.setTitle("password forgot");  
                                 primaryStage.centerOnScreen();  
                                 primaryStage.setResizable(false);  
                                 primaryStage.setOpacity(1);  
                                 primaryStage.show();  
                                 Node node = (Node) event.getSource();
                                 Stage stage = (Stage) node.getScene().getWindow();
                                 stage.close();
        

    }

    @FXML
    void sign(ActionEvent event) throws IOException {
        
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/AjouterUtilisateur.fxml"));
                                  Parent root = loader.load();
                                 Scene scene = new Scene(root);  
                                 Stage primaryStage = new Stage();
                                 primaryStage.setScene(scene);  
                                 primaryStage.setTitle("User Login");  
                                 primaryStage.centerOnScreen();  
                                 primaryStage.setResizable(false);  
                                 primaryStage.setOpacity(1);  
                                 primaryStage.show();  
                                 Node node = (Node) event.getSource();
                                 Stage stage = (Stage) node.getScene().getWindow();
                                 stage.close();
        
        
    }
}
