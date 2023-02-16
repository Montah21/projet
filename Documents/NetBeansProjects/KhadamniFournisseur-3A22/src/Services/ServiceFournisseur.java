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

/**
 *
 * @author Emna
 */
public class ServiceFournisseur implements FournisseurInterface{
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
 @Override
    public void addMaterial(Material  M) {
        try {
            String req = "INSERT INTO `Material`(`id`, `nom`, `prix`) VALUES ('"+ M.getId() +"',"+M.getNom()+","+M.getPrix()+")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Player Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addMaterial2(Material M) {
        try {
            
            String req = "INSERT INTO `Material`(`id`, `nom`, `prix`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, M.getId());
            ps.setString(2, M.getNom());
            ps.setFloat(3, M.getPrix());
            ps.executeUpdate();
            System.out.println("Material Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

    }
    
     @Override
    public List<Material> fetchMaterial() {
        List<Material> Material = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM Material";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Material M = new Material();
                M.setId(rs.getInt(1));
                M.setNom(rs.getString(2));
                M.setPrix(rs.getFloat("Prix"));
              
                
                Material.add(M);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Material;
    }

    @Override
    public void affecterMaterial(Material M, CategoryF C) {
        try {
            String req ="UPDATE `Material` SET `Category`= ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, C.getId());
            ps.setInt(2, M.getId());
            ps.executeUpdate();
            System.out.println("material updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

   

  
}
