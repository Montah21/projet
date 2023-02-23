/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import Services.ServiceFournisseur;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Emna
 */
public class ServiceMateriel implements FournisseurInterface{
    //var
    Statement sta;
    Connection cnx = MaConnexion.getInstance().getCnx();
    serviceCategorie sc= new serviceCategorie();
    /////////////////////////////ADD////////////////////////////////////
//    @Override
//    public void addMaterial(Material  M) {
//        try {
//            String req = "INSERT INTO `material`(`id`, `nom`, `prix`) VALUES ('"+ M.getId() +"',"+M.getNom()+","+M.getPrix()+")";
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Player Added successfully!");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    
    
      
    @Override
    public void addMaterial2(Material m) {
        try {
          
            
            String req = "INSERT INTO `material`(`id`, `nom`, `prix`, `quantité`,`idcategorie`) VALUES (?,?,?,?,?)";
            PreparedStatement pm = cnx.prepareStatement(req);
            pm.setInt(1, m.getId());
            pm.setString(2, m.getNom());
            pm.setFloat(3, m.getPrix());
            pm.setInt(4,m.getQuantity() );
            pm.setInt(5, m.getCat().getIdC());
            
            pm.executeUpdate();
            System.out.println("Material Added Successfully!");
            
        }
        catch (SQLException ex) {
            
//            ex.printStackTrace();
              Logger.getLogger(ServiceMateriel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        }
    /////////////////////////////////List/////////////////////////////
//      @Override
//    public List<Material> fetchMaterial() {
//        List<Material> Material = new ArrayList<>();
//        try {
//            
//            String req = "SELECT * FROM material";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {                
//                Material M = new Material();
//                M.setId(rs.getInt(1));
//                M.setNom(rs.getString(2));
//                M.setPrix(rs.getFloat(3));
////                M.setCategorie(rs.getIdc(4));
//            Material.add(M);
//       
//            
//            }
//                  } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//       return Material;
//    }
   
    @Override
    public List<Material> AfficherMaterial() {
       
       List<Material> Material = new ArrayList<>();
        
//        String req = "SELECT * FROM `materiel` ";  
        try {
             String req = "SELECT * FROM `material` ";  
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Material mt = new Material ();
                
                mt.setId(rs.getInt(1));
                mt.setNom( rs.getString(2));//app au affichage de user pour matcher la méthode setuser a setCin //              
                mt.setPrix(rs.getFloat(3));
                mt.setQuantity(rs.getInt(4));
                mt.setCat((CategoryF) sc.AfficherCategorie((rs.getInt(5))));
                //(list).add(p)
                Material.add(mt);
                System.out.println(mt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMateriel.class.getName()).log(Level.SEVERE, null, ex);
//             ex.printStackTrace();
        }
        return Material;
    }
     
    ////////////////////////////////////DELETE///////////////////////////////
    @Override
    public void deleteMaterial(Material m) {
    String query = "DELETE FROM material WHERE idcategorie = ?";

    
        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1,m.getCat().getIdC());
            preparedStatement.executeUpdate();
            System.out.println("materiel deleted succefully");
        
    } catch (SQLException e) {
    }
    } 
    //////////////////////////////MODIFY//////////////////////////
     @Override
    public void ModifierMateriel( Material M) {
       
         
        
          
         try {
             String sql = "UPDATE `material` SET `id`= ?,`nom`= ?,`prix`=?,`quantité=?` , `idcategorie=?` ";
         
         
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, M.getId());
            ste.setString(2,M.getNom());
            ste.setFloat(3, M.getPrix());
            ste.setInt(4, M.getQuantity());
            ste.setInt(5,M.getCat().getIdC());
            
            ste.executeUpdate();
            System.out.println("Vous avez modifié votre materiel avec success via prepared Statement");
        } 
         catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }  }
    
 
   
//    @Override
//    public void deleteMaterial(Material M) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void addCategory(CategoryF c) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//   @Override
//    public List<CategoryF> fetchCategoryF() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


//    @Override
//    public void deleteCategory(int idC) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void affecterMaterial(Material M, CategoryF C) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public List<Material> fetchMaterial() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


//    @Override
//    public List<Material> afficherMaterial() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//  

//    @Override
//    public List<Material> afficherMaterial() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//     public List<CategoryF> AfficherCategorie() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    
//   

//    @Override
//    public void deleteMaterial(Material M) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void addCategory(CategoryF c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(int idC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoryF> AfficherCategorie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ModifierCategorie(CategoryF c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modifiercategorie(CategoryF c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void deleteMaterial(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

 
    }

 
   
    

