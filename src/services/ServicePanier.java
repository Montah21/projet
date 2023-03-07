package services;

import interfaces.PanierInterface;
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

public class ServicePanier implements PanierInterface {

    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addProduit(Produit p) {
        try {
            String req = "INSERT INTO `produit` (`id`, `nom`, `prix`, `idc`, `ref`, `stock`) VALUES (?, ?, ?, ?, ?, ?)";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Produit ajouté avec succès !");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
   public List<Produit> fetchProduit() {
       List<Produit> Produits = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM produit";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Produit p = new Produit();
               p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrix(rs.getInt("Prix"));
                p.setref(rs.getString("ref"));
                p.setstock(rs.getInt("stock"));
              
                
                Produits.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Produits;
    }

    @Override
    public void affecterProduit(Produit p,Categorie c) {
        try {
            String req ="UPDATE `produit` SET `id_categorie`= ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, c.getIdc());
            ps.setInt(2, p.getId());
            
             
           // ps.setInt(3, c.getQuantite()+1);
            ps.executeUpdate();
            System.out.println("Produit updated successfully in this categorie!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
      @Override
    public void deleteProduit(Produit p) {
        try {
            String req = "DELETE FROM produit WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            System.out.println("Produit Deleted Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      @Override
     public List<Produit> fetchProduitbyname(String nom) {
       List<Produit> Produits = new ArrayList<>();
        try {
            
            String req = "SELECT `nom`, `prix`,`ref`, `stock` FROM produit WHERE `nom`=\""+nom+"\";";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Produit p = new Produit();
             
                p.setNom(rs.getString(1));
                p.setPrix(rs.getInt("Prix"));
                p.setref(rs.getString("ref"));
                p.setstock(rs.getInt("stock"));
              
                
                Produits.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Produits;
    }
@Override
public List<Produit> fetchProduitByCategory(int idc) {
    List<Produit> produits = new ArrayList<>();
    try {
        String req = "SELECT * FROM produit WHERE idc = ?";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setInt(1, idc);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {                
            Produit p = new Produit();
            p.setId(rs.getInt(1));
            p.setNom(rs.getString(2));
            p.setPrix(rs.getInt("Prix"));
            p.setref(rs.getString("ref"));
            p.setstock(rs.getInt("stock"));
            produits.add(p);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return produits;
}



    @Override
    public void modifierProduit(Produit p) {
        
        String req= "UPDATE `produit` SET `nom`='?',`stock`='?' WHERE  `id`= ?"  ;
        try {
            
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getstock());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
            System.out.println("Product updated successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Produit> fetchProduitByCategory(String selectedCategory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  



   

}



 

        