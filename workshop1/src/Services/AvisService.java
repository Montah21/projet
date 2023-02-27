/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interface.Aviss;
import Models.Avis;
import Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariem
 */
public class AvisService implements Aviss{

     Statement sta;
    //var
    Connection cnx = MyConnection.getInstance().getCnx();
    // instance pour la jointure //
    UtilisateurService us = new UtilisateurService ();
    
    @Override
    public void AjouterAvis(Avis A) {
        String req = " INSERT INTO `avis`(`id_avis`, `id_user`, `role`, `nv_satif`, `comment`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);    
            
            ps.setInt(1, A.getId_avis());
            ps.setInt(2, A.getUser().getId());
            ps.setString(3, A.getRole());
            ps.setString(4, A.getNv_satif());
            ps.setString(5, A.getComment());
  
            ps.executeUpdate();
            System.out.println(" Votre avis est ajouté avec success merci !");
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       

    @Override
    public List<Avis> AfficherAvis() {
       
       List<Avis> avis = new ArrayList<>();
        
        String req = "SELECT * FROM `avis` ";  
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Avis A = new Avis ();
                
                A.setId_avis(rs.getInt(1));
                A.setUser(us.afficherUtilisateur((rs.getInt(2)))); //app au affichage de user pour matcher la méthode setuser a setCin //              
                A.setRole(rs.getString("role"));
                A.setNv_satif(rs.getString("nv_satif"));
                A.setComment(rs.getString("comment"));
                //(list).add(p)
                avis.add(A);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avis;
    }
                
                       


    @Override
    public void SupprimerAvis(Avis A) {
        
       String sql = "DELETE FROM `avis` WHERE id_user ='?'";
       try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setInt(1, A.getUser().getId()); // on fait getuser.getid pour faire comprendre a la base que cin est le foreign key et pour l'app on utilise l'objet user 
            
            ste.executeUpdate();
            System.out.println(" Avis est supprimé avec succes via prepstatement");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ModifierAvis( Avis A) {
       
         
        
         String sql = "UPDATE `avis` SET `id_user`= ?,`role`= ?,`nv_satif`=? ,`comment`= ? WHERE `id_avis` = ?"; 
         try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setInt(1,A.getUser().getId());
            ste.setString(2,A.getRole());
            ste.setString(3, A.getNv_satif());
            ste.setString(4,A.getComment());
            ste.setInt(5,A.getId_avis());
            
            ste.executeUpdate();
            System.out.println("Vous avez modifié votre avis avec success via prepared Statement");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }  
    }
    
    ///// méthode Get by id //
/*
    @Override
    public Avis AfficherAvis(int cinn) {
        
        Avis A = new Avis ();
        String req = "SELECT * FROM `avis` WHERE cin =" + cinn +" " ;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                A.setUser(us.afficherUtilisateur(rs.getInt(1)));
                A.setRole(rs.getString(2));
                A.setNv_satif(rs.getString(3));
                A.setComment(rs.getString(4));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return A;
    }*/

    /*
     public List<utilisateur> afficherRoledeUsers(String role) {
       
         List<utilisateur> users = new ArrayList<>();
          String req =" \"SELECT * FROM `utilisateur` where role=" +role ; 
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                 utilisateur u = new utilisateur ();
                u.setId(rs.getInt(1));
                u.setCin(rs.getInt(2));
                u.setNom(rs.getString(3));
                u.setPrenom(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setRole(rs.getString(6));
                u.setTel(rs.getInt(7));
                
                //
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }*/

    /*@Override
    public List<Avis> afficherAvisbyroles(String role); {
      
        List<Avis> Aviss = new ArrayList<>();
         String req = "SELECT * FROM `avis` WHERE role=" +role;
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Avis A = new Avis ();
                A.setUser(us.afficherUtilisateur((rs.getInt(1))));
                A.setRole(rs.getString(2));
                A.setNv_satif(rs.getString(3));
                A.setComment(rs.getString(4));
             
               
                Aviss.add(A);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  Aviss ;
        
    }*/
     
     //*************************** filter *****************************************//
    @Override
    public List<Avis> afficherAvisbyroles(String role) {
        
        List<Avis> Aviss = new ArrayList<>();
        
        String req = "SELECT * FROM `avis` where role='" +role+"'" ; 
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
             while(rs.next()){
                Avis A = new Avis ();
                
                
                A.setId_avis(rs.getInt(1));
                A.setUser(us.afficherUtilisateur((rs.getInt(2))));
                A.setRole(rs.getString(3));
                A.setNv_satif(rs.getString(4));
                A.setComment(rs.getString(5));
                
                Aviss.add(A);
         }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Aviss;
              
    }
       
    
    }
    
    


   
    

