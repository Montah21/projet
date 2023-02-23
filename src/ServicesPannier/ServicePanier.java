/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import InterfaceF.PanierInterface;
import ModelsF.Categorie;
import ModelsF.Produit;
import Util.MaConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mouty
 */
public class ServicePanier implements PanierInterface {
     Connection cnx = MaConnection.getInstance().getCnx();

   @Override 
    public void addProduit(Produit p) {
         try {
            String req = "INSERT INTO `produit`(`nom`, `prix`,`ref`,`stock`) VALUES ('"+ p.getNom()+"',"+p.getPrix()+","+ p.getref()+""+ p.getstock()+")";
            Statement st = cnx.createStatement();
             
            
            st.executeUpdate(req);
            System.out.println("Produit Added successfully!");
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
                p.setPrix(rs.getFloat("Prix"));
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
    public List<Produit> fetchProduitbyname(String nom) {
       List<Produit> Produits = new ArrayList<>();
        try {
            
            String req = "SELECT `nom`, `prix`,`ref`, `stock` FROM produit WHERE `nom`=\""+nom+"\";";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Produit p = new Produit();
               p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrix(rs.getFloat("Prix"));
                p.setPrix(rs.getFloat("Prix"));
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
            ps.setInt(1, c.getId());
            ps.setInt(2, p.getId());
            
             
           // ps.setInt(3, c.getQuantite()+1);
            ps.executeUpdate();
            System.out.println("Produit updated successfully in this categorie!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
     @Override
    public void SupprimerProduit(int id) {
        String request = "DELETE FROM produit WHERE `id`= ?";
        Statement st;
       try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setInt(1, id);
            //
            ps.executeUpdate();
            System.out.println("produit supprimé avec success via prepared Statement!!!");
        } catch (SQLException ex) {
              ex.printStackTrace();
        }
    }

    @Override
    public void addCategorie(Categorie c) {
             try {
            
            String req = "INSERT INTO `categorie`(`libelle`, `ref`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getLibelle());
            ps.setString(2, c.getRef());
            
            ps.executeUpdate();
            System.out.println("categorie Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
    
    
    
    }

    
    

    
   
    
    

