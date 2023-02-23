/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//crud creat read update delete 
package Services;

import InterfaceF.FournisseurInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ModelsF.Material;
import ModelsF.CategoryF;
import Util.MaConnexion;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Emna
 */
public class serviceCategorie implements FournisseurInterface{
     Connection cnx = MaConnexion.getInstance().getCnx();

   
    
    @Override
    public void addCategory(CategoryF c) {
        try {
            
            String req = "INSERT INTO `categoryf`(`idC`, `nomC`,`description`, `proUsage`) VALUES (?,?,?,?)";
            PreparedStatement pc = cnx.prepareStatement(req);
            pc.setInt(1, c.getIdC());
            pc.setString(2, c.getNomC());
            pc.setString(3,c.getDescription());
//            ps.setString(3, C.getType());
            pc.setBoolean(4, c.isProUsage());
            pc.executeUpdate();
            System.out.println("category Added Successfully!");
            
        } catch (SQLException ex) {
//            ex.printStackTrace();
              Logger.getLogger(ServiceMateriel.class.getName()).log(Level.SEVERE, null, ex);
        }
}//////////////////////////FETCH///////////////////
//     @Override
//    public List<CategoryF> fetchCategoryF() {
//        List<CategoryF> CategoryF = new ArrayList<>();
//        try {
//            
//            String req = "SELECT * FROM categoryf";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {                
//              CategoryF c = new CategoryF();
//                c.setIdC(rs.getInt(1));
//                c.setNomC(rs.getString(2));
////                c.setProUsage(rs.isProUsage(3));
////                M.setCategorie(rs.getIdc(4));
//               
//                     CategoryF.add(c);
//                     System.out.println(CategoryF);
//      
//            }
//                  } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//        return CategoryF;
//    }

    /**
     *
//     * @param i
     * @return
     */
     public List<CategoryF> AfficherCategorie(int i) {
       
       List<CategoryF> CategoryF = new ArrayList<>();
        
//        String req = "SELECT * FROM `materiel` ";  
        try {
             String req = "SELECT * FROM `categoryf` ";  
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                CategoryF fc = new CategoryF();
                
                fc.setIdC(rs.getInt(1));
                fc.setNomC(rs.getString(2));
                fc.setDescription(rs.getString(3));//app au affichage de user pour matcher la méthode setuser a setCin //              
//                fc.(rs.getFloat(3));
                fc.setProUsage(rs.getBoolean(4));
              
                //(list).add(p)
                CategoryF.add(fc);
                System.out.println(fc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceCategorie.class.getName()).log(Level.SEVERE, null, ex);
//             ex.printStackTrace();
        }
        return CategoryF;
    }
    /////////////////////////DELETE/////////////////////////
  
     @Override
    public void deleteCategory(int idc) {
    String query = "DELETE FROM categoryf WHERE idc = ?";

    try {
        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1, idc);
            preparedStatement.executeUpdate();
            System.out.println("category deleted succefully");
        }
    } catch (SQLException e) {
    }
    } 

////////////////////////MODIFY/////////////////////////
     @Override
    public void Modifiercategorie( CategoryF c) {
       
        
        
          
         try { 
             String sql = "UPDATE `categoryf` SET `idC`= ?,`nomC`= ?,`description=?`,`proUsage`=? ";
         PreparedStatement ste = cnx.prepareStatement(sql);
         
            
            
            ste.setInt(1,c.getIdC());
            ste.setString(2,c.getNomC());
            ste.setString(3, c.getDescription());
            ste.setBoolean(3, c.isProUsage());
           
            
            ste.executeUpdate();
            System.out.println("Vous avez modifié votre categorie avec succée via prepared Statement");
        } 
         catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }  }
    

    @Override
    public void addMaterial2(Material M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<Material> fetchMaterial() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void affecterMaterial(Material M, CategoryF C) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void deleteMaterial(Material M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void deleteMaterial(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public List<Material> AfficherMaterial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<CategoryF> fetchCategoryF() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void ModifierMateriel(Material m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoryF> AfficherCategorie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//    @Override
//    public void ModifierCategorie(CategoryF c) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void ModifierCategorie(CategoryF c) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    CategoryF AfficherCategorie(int i) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//    CategoryF AfficherCategorie(int i) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    }

   
  

   

   
    

