/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Emna
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author ASUS
 */

public class connexion {
    public String url="jdbc:mysql://localhost:3306/i-work-four";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static connexion instance;
    
    private connexion(){
        try {
           cnx = DriverManager.getConnection(url ,login ,pwd);
           System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
           System.err.print(ex.getMessage());
        }
    }
    
    public Connection getCnx() {
        return cnx;
    }
    
    public static connexion getInstance(){
        if(instance == null){
        instance = new connexion();
        }
        return instance;
    }
}

