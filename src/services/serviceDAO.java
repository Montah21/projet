/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Administrator
 */
import Interface.ServiceInterface;
import Interface.ApplicationInterface;
import utils.MaConnection;
import Models.application;
import Models.service;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class serviceDAO implements ServiceInterface{
  Connection cnx = MaConnection.getInstance().getCnx();
    
  @Override
    public void addService(service p) {
        try {
            
            String req = "INSERT INTO `service`(`ID_Client`, `Location`, `ServiceName`, `ClientPhone`, `OuvrierID`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getID_Client());
            ps.setString(2, p.getLocation());
            ps.setString(3, p.getServiceName());
           ps.setInt(4, p.getClientPhone());
           ps.setString(5, p.getOuvrierID());
            ps.executeUpdate();
            System.out.println("Service Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

    }
    @Override
    public List<service> Jointure() throws SQLException{
    List<service> services = new ArrayList<>();
        
                
            String req = "SELECT service.* FROM service INNER JOIN application ON service.OuvrierID = application.id;";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                service p = new service();
                p.setID_Client(rs.getString(1));
                p.setLocation(rs.getString(2));
                p.setServiceName(rs.getString(3));
                p.setClientPhone(rs.getInt(4));
                p.setOuvrierID(rs.getString(5));
                
                services.add(p);
            }
        return services;
    
    }
    @Override
    public List<service> FetchByID(String id)throws SQLException {
        List<service> services = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM service WHERE `OuvrierID` =\""+id+"\";";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                service p = new service();
                p.setID_Client(rs.getString(1));
                p.setLocation(rs.getString(2));
                p.setServiceName(rs.getString(3));
                p.setClientPhone(rs.getInt(4));
                p.setOuvrierID(rs.getString(5));
                
                services.add(p);
            }
            System.out.println(services.toString());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return services;
    }
  @Override
    public List<service> afficherServices()throws SQLException {
        List<service> services = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM service ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                service p = new service();
                p.setID_Client(rs.getString(1));
                p.setLocation(rs.getString(2));
                p.setServiceName(rs.getString(3));
                p.setClientPhone(rs.getInt(4));
                p.setOuvrierID(rs.getString(5));
                
                services.add(p);
            }
            System.out.println(services.toString());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return services;
    }

  @Override
public service afficherService(String ClientID) {
        service p = new service();
        String request ="SELECT `ID_Client`,`Location`,`ServiceName`,`ClientPhone`, FROM `service` WHERE `role` =\""+ClientID+"\";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                p.setID_Client(rs.getString(1));
                p.setLocation(rs.getString(2));
                p.setServiceName(rs.getString(3));
                p.setClientPhone(rs.getInt(4));
              
            }
        } catch (SQLException ex) {
              ex.printStackTrace();
        }System.out.println(p.toString());
        return p;
    }

}







 /* @Override
    public void affecterApplication(application p) {
        try {
            String req ="UPDATE `application` SET `name`= ?,`num`= ?,`role`= ?,`document`= ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, p.getName());
            ps.setInt(2, p.getNum());
           ps.setString(3, p.getRole());
           ps.setString(4, p.getDocument());
           ps.setString(5, p.getId());
          
            ps.executeUpdate();
            System.out.println("Player updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        */
    
    

    

