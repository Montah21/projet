/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interface.User;
import Models.Avis;
import Models.utilisateur;
import static Services.PasswordHasher.hashPassword;
import Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mariem
 */
public class UtilisateurService implements User{
    
    private Collection <Avis> aviss;

    Statement sta;
    //var
    Connection cnx = MyConnection.getInstance().getCnx();
/*
    @Override
  public void ajouterUtilisateur(utilisateur u) {
        
   String req = "INSERT INTO `utilisateur`(`id`, `cin`, `nom`, `prenom`, `role`, `tel`,`password`) VALUES('" 
      +u.getId()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getRole()+"','"+u.getPassword()+"','"+u.getCin()+"','"+u.getTel()+"')";
 
   try {
            Statement st  = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user  ajouté avec success!!");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/   
  

    @Override
    public void ajouterUtilisateur2(utilisateur u) {
      String req = "INSERT INTO `utilisateur`(`id`, `cin`, `nom`, `prenom`,`mail`, `password`, `role`, `tel`) VALUES (?,?,?,?,?,?,?,?)";
      try {
            PreparedStatement ps = cnx.prepareStatement(req);    
            
            ps.setInt(1, u.getId());
            ps.setInt(2, u.getCin());
            ps.setString(3, u.getNom());
            ps.setString(4, u.getPrenom());
            ps.setString(5, u.getMail());
            // Hacher le mot de passe avant de l'ajouter à la base de données
            String hashedPassword = PasswordHasher.hashPassword(u.getPassword());
             ps.setString(6, hashedPassword);
        
            ps.setString(7, u.getRole());
            ps.setInt(8, u.getTel());
            
            ps.executeUpdate();
            System.out.println("User ajouté avec success via prepared Statement!!!");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<utilisateur> afficherUtilisateur() {
        
        List<utilisateur> users = new ArrayList<>();
        
        String request = "SELECT * FROM `utilisateur`  ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                utilisateur u = new utilisateur ();
                u.setId(rs.getInt(1));              
                u.setCin(rs.getInt(2));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setMail(rs.getString("mail"));
                u.setRole(rs.getString("role"));
                u.setPassword(rs.getString("password"));
                u.setTel(rs.getInt(8));
                //(list).add(p)
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    // methode delete selon l id //
    @Override
    public void supprimerUtilisateur(utilisateur u) {
        
        String sql = "DELETE FROM `utilisateur` where id = ? ";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, u.getId());
            ste.executeUpdate();
            System.out.println("votre user est supprimé via prepstatement");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    // méthode modifier  selon cin  donné en paramétre   //    

    @Override
    public void modifierUtilisateur( utilisateur u) {
        
        String sql = "UPDATE `utilisateur` SET `cin`=?,`nom`=?,`prenom`=?,`mail`=?,`password`=?,`role`=?,`tel`=? WHERE `id`=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setInt(1,u.getCin());
            ste.setString(2,u.getNom());
            ste.setString(3,u.getPrenom());
             ste.setString(4,u.getMail());
            ste.setString(5, hashPassword(u.getPassword()));
            ste.setString(6,u.getRole());
            ste.setInt(7,u.getTel());
            ste.setInt(8,u.getId());            
            
            
            ste.executeUpdate();
            System.out.println("user avec le cin donnée est modifié avec success via prepared Statement");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //GetById : Affichage d'un seul user ///

    @Override
    public utilisateur afficherUtilisateur(int idu) {
        
     utilisateur u = new utilisateur();
     String req = " SELECT * FROM `utilisateur` where `id` =" +idu ;
      try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                u.setId(rs.getInt(1));              
                u.setCin(rs.getInt(2));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                 u.setRole(rs.getString("mail"));
                u.setRole(rs.getString("role"));
                u.setPassword(rs.getString("password"));
                u.setTel(rs.getInt(8));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    //filter : afficher les roles d'un user a partir la liste des users 

    @Override
    public List<utilisateur> afficherUsersByRoole(String role) {
       
         List<utilisateur> users = new ArrayList<>();
          String req = " SELECT * FROM `utilisateur` where role='" +role+"'" ; 
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                 utilisateur u = new utilisateur ();
                u.setId(rs.getInt(1));              
                u.setCin(rs.getInt(2));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setRole(rs.getString("mail"));
                u.setRole(rs.getString("role"));
                u.setPassword(rs.getString("password"));
                u.setTel(rs.getInt(8));
                
                //
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    /*
      public boolean resetPassword(int idu, String newPassword)  {
        String req = "UPDATE `utilisateur` SET  `password`=? WHERE id = ?";
        try (
             PreparedStatement ste = cnx.prepareStatement(req);
          
            ste.setString(1,newPassword());
            ste.setInt(2,id());            
            
            ste.executeUpdate();
            System.out.println("user avec le cin donnée est modifié avec success via prepared Statement");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        } */

    
/*       @Override
    public boolean resetPassword(int id, String Password) {
    String req = "UPDATE `utilisateur` SET  `password`=? WHERE id = ?";

    try (PreparedStatement ste = cnx.prepareStatement(req)) {
        ste.setString(1, Password);
        ste.setInt(2, id);
        ste.executeUpdate();
        System.out.println("Le mot de passe de l'utilisateur avec l'ID " + id + " a été modifié avec succès.");
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}*/

 
@Override
public boolean resetPassword(String mail, String password) {
    String hashedPassword = hashPassword(password); // Hasher le nouveau mot de passe
    
    String req = "UPDATE `utilisateur` SET  `password`=? WHERE mail = ?";

    try (PreparedStatement ste = cnx.prepareStatement(req)) {
        ste.setString(1, hashedPassword);
        ste.setString(2, mail);
        ste.executeUpdate();
        System.out.println("Le mot de passe de l'utilisateur avec l'ID " + mail + " a été modifié avec succès.");
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}





    @Override
    public utilisateur getUtilisateurByCin(int cin) {
       
        String req = "SELECT * FROM `utilisateur` WHERE `cin` = " +cin;
        utilisateur u = new utilisateur();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                u.setId(rs.getInt(1));              
                u.setCin(rs.getInt(2));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setRole(rs.getString("role"));
                u.setPassword(rs.getString("password"));
                u.setTel(rs.getInt(7));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    


 // last project ///

    
    @Override
    public int getIDByCin(int cin) {
    int userID = -1; // initialize to a default value if no user found
    String req = "SELECT id FROM utilisateur WHERE cin =" + cin;

    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        if (rs.next()) {
            userID = rs.getInt(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
    }

    return userID;
}
    
    public void storeUserIDInSession(int cin) {
    int userID = getIDByCin(cin);
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession session = request.getSession();
    session.setAttribute("userID", userID);
    }
    
}


    
    
    
    
    
    
    
   
        
    

    
    

