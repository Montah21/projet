/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import InterfaceF.FournisseurInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 /*importjava.sql.Statement;*/
import java.util.List;
import ModelsF.Material;
import ModelsF.CategoryF;
import Util.MaConnexion;
import Services.serviceCategorie;
import Services.ServiceMateriel;

/**
 *
 * @author Emna
 */
public class ServiceFournisseur implements FournisseurInterface{
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
// @Override
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

//    @Override
//    public void addMaterial2(Material M) {
//        try {
//            
//            String req = "INSERT INTO `Material`(`id`, `nom`, `prix`) VALUES (?,?,?)";
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setInt(1, M.getId());
//            ps.setString(2, M.getNom());
//            ps.setFloat(3, M.getPrix());
//            ps.executeUpdate();
//            System.out.println("Material Added Successfully!");
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//
//    }
    
//     @Override
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
              
                
//                Material.add(M);
//            }
            
//  /*      } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return Material;
//    }*/

    /**
     *
     * @param M
     */
//    @Override
//    public void affecterMaterial(Material M, CategoryF C) {
//        try {
//            String req ="UPDATE `Material` SET  WHERE id = ?";
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setInt(1, C.getIdC());
//            ps.setInt(2, M.getId());
//            ps.executeUpdate();
//            System.out.println("material updated successfully!");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//
//    }
// /*public void addCategory(CategoryF C) {
//        try {
//
//            String req = "INSERT INTO `CategoryF`(`idc`, `nom`, `proUsage`) VALUES (?,?,?)";
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setInt(1, C.getIdC());
//            ps.setString(2, C.getNom());
////            ps.setString(3, C.getType());
//            ps.setBoolean(3, C.isProUsage());
//            ps.executeUpdate();
//            System.out.println("category Added Successfully!");
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }*/
        

   // }
//    public void deleteMaterial(int id) {
//    String query = "DELETE FROM Material WHERE id = ?";
//
//    try {
//        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        }
//    } catch (SQLException e) {
//    }
//    }

//    @Override
//    public void deleteMaterial(Material M) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   

    @Override
    public void addMaterial2(Material M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<Material> fetchMaterial() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void deleteMaterial(Material M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCategory(CategoryF c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void deleteMaterial(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void affecterMaterial(Material M, CategoryF C) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public List<CategoryF> fetchCategoryF() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /**
     *
     * @param idC
     */
    @Override
    public void deleteCategory(int idC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> AfficherMaterial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoryF> AfficherCategorie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModifierMateriel(Material m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void ModifierCategorie(CategoryF c) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void Modifiercategorie(CategoryF c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
  
  
}

