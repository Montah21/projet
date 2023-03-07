package services;

import interfaces.CategorieInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categorie;
import models.Produit;

import util.MyConnection;

public class ServiceCategorie implements CategorieInterface {
    //var
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
       public void addCategorie(Categorie c) {
             try {
            
            String req = "INSERT INTO `categorie`(`idc`,`libelle`, `quantite`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, c. getIdc());
            ps.setString(2, c.getLibelle());
            ps.setInt(3, c.getQuantite());
            
            ps.executeUpdate();
            System.out.println("categorie Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
@Override
    public List<Categorie> fetchCategories() {
        List<Categorie> categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie c = new Categorie();
                c.setIdc(rs.getInt(1));
                c.setLibelle(rs.getString(2));
                c.setQuantite(rs.getInt("quantite"));
                
                categories.add(c);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return categories;
    }

    /*@Override
    public void affecterProduit(Categorie c, Produit p) {
        try {
            String req ="UPDATE `produit` SET `idc`= ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, c.getIdc());
            ps.setInt(2, p.getId());
            ps.executeUpdate();
            System.out.println("Product updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/

    @Override
    public void modifierCategorie(Categorie c) {
        
        String req= "UPDATE `categorie` SET `libelle`='?',`quantite`='?' WHERE  `idc`= ?"  ;
        try {
            
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getLibelle());
            ps.setInt(2, c.getQuantite());
            ps.setInt(3, c.getIdc());
            ps.executeUpdate();
            System.out.println("category updated successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    /*
    @Override
    public void afficherCategorieByName(String libelle) {
        try {
            String req = "SELECT * FROM categorie WHERE libelle = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, libelle);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setIdc(rs.getInt("idc"));
                c.setLibelle(rs.getString("libelle"));
                c.setQuantite(rs.getInt("quantite"));
                System.out.println(c.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/
    
    @Override
    public void deleteCategorie(int id) {
        try {
            String req ="DELETE FROM `categorie` WHERE `idc` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Categorie deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void affecterProduit(Categorie c, Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficherCategorieByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
