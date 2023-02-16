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
public class MaConnection {




/**
 *
 * @author farah
 */




     public static Connection con;
    private static String url="jdbc:mysql://localhost:3306/khademni";
    private static String login="root";
    private static String pwd="";
    private static Statement ste;




    public static void main(String[] args)  {
        // TODO code application logic here
        try{
        con=DriverManager.getConnection(url, login, pwd);
          System.out.println("connexion établie");
        }catch(SQLException e){
            System.out.println(e);
            
        }}
    
}
