/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesPannier;
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
            String req = "INSERT INTO `produit`(`nom`, `prix`) VALUES ('"+ p.getNom()+"',"+p.getPrix()+")";
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
              
                
                Produits.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Produits;
    }

    
    

    public void affecterProduit(Produit p,Categorie c) {
        try {
            String req ="UPDATE `produit` SET `categorie`= ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, c.getId());
            ps.setInt(2, p.getId());
           // ps.setInt(3, c.getQuantite()+1);
            ps.executeUpdate();
            System.out.println("Player updated successfully in this categorie!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    

    
   
    
    
}
