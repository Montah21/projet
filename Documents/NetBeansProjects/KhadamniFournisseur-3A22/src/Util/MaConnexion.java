/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Emna
 */
public class MaConnexion {
    
    
    //DB PARAM
    static final String URL ="jdbc:mysql://localhost:3306/fournissseur";
    static final String USER ="root";
    static final String PASSWORD ="";
    
    //var
     Connection cnx;
    //1
    static MaConnexion instance;
    
    //const
    //2
    public MaConnexion(){
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    public Connection getCnx() {
        return cnx;
    }

    //3
    public static MaConnexion getInstance() {
        if(instance == null)
            instance = new MaConnexion();
        
        return instance;
    }
    
    
    
}
