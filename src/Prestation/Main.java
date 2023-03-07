package Prestation;

import services.applicationDAO;
import Models.application;
import Models.service;
import services.serviceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;
import Interface.ApplicationInterface;
import Interface.ServiceInterface;


public class Main {
     

    public Main() {
       
    }
    public static void main(String[] args) throws SQLException {
       applicationDAO dao = new applicationDAO();
       //  serviceDAO dao = new serviceDAO();

     

        // Add a new application
     application newApp = new application(1, "John De", 143,"Manager" ,"Ariana", "patht");
      dao.addApplication(newApp);
     
      //  dao.SupprimerApplication(id);
   // String id="A142";
 //dao.afficherServices();
      
    }
}