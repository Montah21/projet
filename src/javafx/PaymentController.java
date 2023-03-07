/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentIntentCreateParams.ConfirmationMethod;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaymentController {
  
    private String paymentIntentClientSecret;
    private TextField cardNumberField;
    private TextField expiryDateField;
    private TextField cvvField;
    @FXML
    private Button retour;
    @FXML
    private Text date;
    @FXML
    private Text objet;
    @FXML
    private Text flous;
    @FXML
    private Text cartenumber;
    @FXML
    private Button payButton;
    @FXML
    private Text successMessage;
    @FXML
    private Text errorMessage;
    @FXML
    private Text loadingMessage;
    @FXML
    private Text cvc;
    @FXML
    private TextField cartenum;
    @FXML
    private DatePicker expdate;
    @FXML
    private Text dateexp;
    @FXML
    private PasswordField cvccode;
    @FXML
    private Button to2;
     

    @FXML
private void updateTime(MouseEvent event) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDate = now.format(formatter);
    date.setText(formattedDate);
}
    private void initialize() throws StripeException {
          
        Stripe.apiKey = "cus_NSxPp2nDfAbXIN";

        // Create a payment intent
        long amount = 1000; // amount in cents
PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
   .setAmount(amount)
   .setCurrency("usd")
   .addPaymentMethodType("card")
   .setConfirmationMethod(ConfirmationMethod.MANUAL)
   .setConfirm(true)
   .build();
PaymentIntent paymentIntent = PaymentIntent.create(params);
paymentIntentClientSecret = paymentIntent.getClientSecret();

    }
    
    private void submitPayment() throws StripeException {
        // Collect payment details from the user
        String cardNumber = cardNumberField.getText();
        String expiryDate = expiryDateField.getText();
        String cvv = cvvField.getText();
        
        // Use the Stripe.js library to tokenize the payment details
        // ...
        
        // Submit the payment by calling the Stripe API
        PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentClientSecret);
        paymentIntent.confirm();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
       {
 
   Parent root = FXMLLoader.load(getClass().getResource("mainfxml.fxml"));
   Stage window =(Stage) retour.getScene().getWindow();
   window.setScene(new Scene(root));
} 
}

@FXML
private void makePayment(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Payment Successful");
    alert.setHeaderText(null);
    alert.setContentText("Ton achat était un succès");
    alert.showAndWait();
}

    @FXML
    private void displaytotalCost2(ActionEvent event) {
    }

}




  
    



