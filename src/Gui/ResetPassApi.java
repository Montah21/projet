/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ResetPassApi {
    
    public static void sendPasswordResetEmail(String recipient, String newPassword) {
        // paramètres de connexion SMTP pour Gmail
        String host = "smtp.gmail.com";
        String email = "maryembenghouma@gmail.com"; // modifier avec votre adresse e-mail
        String password = "Maryem123456"; // modifier avec votre mot de passe

        // Créer une session SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            // Créer le message e-mail
            String subject = "Réinitialisation de votre mot de passe";
            String body = "Bonjour,\n\nVotre nouveau mot de passe est : " + newPassword;
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Envoyer le message e-mail
            Transport.send(message);
        } catch (AddressException e) {
            Logger.getLogger(ResetPassApi.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Impossible d'envoyer l'e-mail de réinitialisation de mot de passe - adresse e-mail invalide", e);
        } catch (MessagingException e) {
            Logger.getLogger(ResetPassApi.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Impossible d'envoyer l'e-mail de réinitialisation de mot de passe", e);
        }
    }
}















































/*
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ResetPassApi {
    
    public static void sendPasswordResetEmail(String recipient, String newPassword)   {
        // SMTP connection parameters for Gmail
      
        String host = "smtp.gmail.com";
        String email = "maryembenghouma@gmail.com";
        
        // se bloc permet de valider l'adresse mail avant de l'envoyer 
        InternetAddress emailAddr = null;
            try {
                  emailAddr = new InternetAddress(email);
                    emailAddr.validate();
              } catch (AddressException ex) {
                   Logger.getLogger(ResetPassApi.class.getName()).log(Level.SEVERE, null, ex);
                  throw new RuntimeException("Failed to send password reset email - invalid email address", ex);}


        
        String password = "Maryem123456";

        // Create SMTP session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try{
        // Create email message
        String subject = "Reset your password";
        String body = "Hello,\n\nYour new password is: " + newPassword;
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email));
        //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        // verifier si le mail est valid ou pas 
        InternetAddress[] recipientAddress = InternetAddress.parse(recipient);
        if (recipientAddress.length != 1 || !recipientAddress[0].getAddress().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
         throw new AddressException("Invalid recipient address");
         } else {
          message.setRecipients(Message.RecipientType.TO, recipientAddress);}


                        
        message.setSubject(subject);
        message.setText(body);

        // Send email message
        Transport.send(message);
        
        }catch (MessagingException e) {
        System.err.println("Failed to send password reset email: " + e.getMessage());
        throw new RuntimeException("Failed to send password reset email", e);
    }
    }
    
    
     
}*/