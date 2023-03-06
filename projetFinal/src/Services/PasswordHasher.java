/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Mariem
 */
public class PasswordHasher {
    
     public static String hashPassword(String password) {
        try {
            // Créer une instance de l'algorithme SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Hacher le mot de passe
            byte[] hashedPassword = md.digest(password.getBytes());
            
            // Convertir le hachage en une chaîne de caractères hexadécimale
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Gérer l'erreur d'algorithme de hachage inexistant
            e.printStackTrace();
            return null;
        }
    }


    
}
