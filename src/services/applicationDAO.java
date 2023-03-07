package services;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */

import Interface.ApplicationInterface;
import utils.MaConnection;
import Models.application;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class applicationDAO implements ApplicationInterface{
  Connection cnx = MaConnection.getInstance().getCnx();
    
  @Override
    public void addApplication(application p) {
        try {
            
            String req = "INSERT INTO `application`(`id`, `name`, `num`, `role`, `location`, `document`) VALUES (NULL,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
        //    ps.setInt(1, p.getId());
            ps.setString(1, p.getName());
            ps.setInt(2, p.getNum());
           ps.setString(3, p.getRole());
           ps.setString(4, p.getLocation());
           ps.setString(5, p.getDocument());
            ps.executeUpdate();
            System.out.println("Application Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

    }

      @Override
public List<application> afficherApplications() throws SQLException {
        List<application> applications = new ArrayList<>();
        String request ="SELECT * FROM `application`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                application p = new application();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setNum(rs.getInt(3));
                p.setRole(rs.getString(4));
                p.setLocation(rs.getString(5));
                p.setDocument(rs.getString(6));
                //
                applications.add(p);
                            System.out.println(p.toString());

            }}
              catch (SQLException ex) {
           ex.printStackTrace();
        }
        return applications; 
    }
  @Override
public application afficherApplication(String id) {
        application p = new application();
        String request ="SELECT * FROM `application` WHERE `id` =\""+id+"\";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setNum(rs.getInt(3));
                p.setRole(rs.getString(4));
                p.setLocation(rs.getString(5));
                p.setDocument(rs.getString(6));
            }
        } catch (SQLException ex) {
              ex.printStackTrace();
        }System.out.println(p.toString());
        return p;
    }
  @Override
    public void affecterApplication(application p) {
        try {
            String req ="UPDATE `application` SET `name`= ?,`num`= ?,`role`= ?,`location`= ?,`document`= ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, p.getName());
            ps.setInt(2, p.getNum());
           ps.setString(3, p.getRole());
           ps.setString(4, p.getLocation());
           ps.setString(5, p.getDocument());
           ps.setInt(6, p.getId());
          
            ps.executeUpdate();
            System.out.println("Application updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
      @Override
    public void SupprimerApplication(String id) {
        String request = "DELETE FROM `application` WHERE `id`= ?";
        Statement st;
       try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, id);
            //
            ps.executeUpdate();
            System.out.println("Application supprimé avec success via prepared Statement!!!");
        } catch (SQLException ex) {
              ex.printStackTrace();
        }
    }
      @Override
    public List<application> FetchByRole(String Role) {
       List<application> applications = new ArrayList<>();
        String request ="SELECT * FROM `application` WHERE `role` =\""+Role+"\";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                application p = new application();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setNum(rs.getInt(3));
                p.setRole(rs.getString(4));
                p.setLocation(rs.getString(5));
                p.setDocument(rs.getString(6));
                applications.add(p);
                System.out.println(p.toString());
            }
        } catch (SQLException ex) {
              ex.printStackTrace();
        }
        return applications;
    }
     @Override
    public int FetchIDByNum(int Num) throws SQLException{
        int id=0 ;
        String request ="SELECT `id` FROM `application` WHERE `num` =\""+Num+"\";";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){id=rs.getInt(1);}
         System.out.println(id);}
        catch (SQLException ex) {
              ex.printStackTrace();
             
        }
        return id;
    } 
}