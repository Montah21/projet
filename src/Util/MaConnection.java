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
 * @author mouty
 */
public class MaConnection {
     //DB PARAM
    static final String URL ="jdbc:mysql://localhost:3306/gestionpannier";
    static final String USER ="root";
    static final String PASSWORD ="";
    
    //var
    private Connection cnx;
    //1
    static MaConnection instance;
    
    //const
    //2
    private MaConnection(){
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public Connection getCnx() {
        return cnx;
    }

    //3
    public static MaConnection getInstance() {
        if(instance == null)
            instance = new MaConnection();
        
        return instance;
    }
    
    
}
