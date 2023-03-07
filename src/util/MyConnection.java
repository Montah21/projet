/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class MyConnection {
    
    //DB PARAM
    static  String URL ="jdbc:mysql://127.0.0.1:3306/khademni";
    //static  String URL ="jdbc:mysql://localhost:3306/gestionpannier";
    static  String USER ="root";
    static  String PASSWORD ="";
    
    //var
    private Connection cnx;
    //1
    static MyConnection instance;
    
    //const
    //2
    private MyConnection(){
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connection est etablie");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public Connection getCnx() {
        return cnx;
    }

    //3
    public static MyConnection getInstance() {
        if(instance == null)
            instance = new MyConnection();
        
        return instance;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }
    
    
    
}
