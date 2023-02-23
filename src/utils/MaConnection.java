package utils;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class MaConnection {
    
    //DB PARAM
    static final String URL ="jdbc:mysql://localhost:3306/khademni";
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