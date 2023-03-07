/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesETinter;
import Entity.materiel;
import Entity.categorie;
import ServicesETinter.serviceM;
import Util.connexion;
import Util.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Emna
 */
public class ServiceC implements CatInterface<categorie>{
    
    Connection cnx;
    public ServiceC(){
        cnx=MyDB.getInsatnce().getConnection();
    }
    /*****************************************************************/
    @Override
    public void AjouterCat(categorie c) {
            try {
                String req = "insert into categorie(fournisseur,matID,idc,nomc,uagePro,qualite)"
                        +"values("+1+","+c.getMatId()+",'"+c.getIdc()+"','"+c.getNomc()+"','"+c.getUsagePro()+"',"+c.getQualite()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("categorie ajoutée avec succ");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } 
    }
     /************************************************************************************/       
    @Override
    public void ModifierCat(categorie c) {
try {

            
            String req ="UPDATE categorie SET fournisseur=?,matid=?,nomc=?,usagePro=?,qualite=? WHERE idc=?";
            PreparedStatement ps= cnx.prepareStatement(req); //req dynamic plus securiser
           
           // ps.setString(1,);
            ps.setInt(1,c.getFournisseur());
            ps.setInt(2,c.getMatId());
            ps.setString(3,c.getNomc());
            ps.setString(4,c.getUsagePro());
            ps.setString(5,c.getQualite());
           ps.executeUpdate();
                        System.out.println("categorie Modifer avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceC.class.getName()).log(Level.SEVERE, null, ex);
        }       }
    /******************************************************************************/
     @Override
    public void Supprimercat(int idc) {
			try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM gategorie WHERE idc = "+idc+"";
                st.executeUpdate(req);      
      System.out.println("La categorie avec l'id = "+idc+" a été supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }
@Override
    public List<categorie> RecupererCat() {
         List<categorie> cat = new ArrayList<>();
       
        String sql ="select categorie.idc,materiel.nom ,categorie.matID,categorie.nomc, categorie.usagePro,categorie.qualite from categorie INNER JOIN materiel on categorie.idc =materiel.idm ";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                categorie c = new categorie();
               c.setIdc(rs.getInt("fournisseur"));
               c.setNomc(rs.getString("nomc"));
               c.setMatId(rs.getInt("matid"));               
               c.setUsagePro(rs.getString("usagePro"));
               c.setQualite(rs.getString("qualite"));
               
                cat.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cat;

    }
     public List<String> getAll() {
        List<String> list = new ArrayList<String>();
        try {
            String requetee = "SELECT nom FROM materiel";
            PreparedStatement pst = cnx.prepareStatement(requetee);
            ResultSet rs = pst.executeQuery();
            System.out.println(rs.toString());

            while (rs.next()) {
                list.add(rs.getString("nom"));
            }

            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
     /******************************************************************/
    
    public int chercherMat(String nom) throws SQLException{
         int id=0;
         String requetee = "SELECT id FROM materiel where nom='"+nom+"';";
            PreparedStatement pst = cnx.prepareStatement(requetee);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {id= rs.getInt("id");
            }return id;}
    /*********************************************************************/
     
    public ObservableList<categorie> chercherCat(String chaine){
        String sql ="select categorie.idc,materiel.nom ,categorie.matID,categorie.nomc, categorie.usagePro, categorie.qualite from categorie INNER JOIN materiel on categorie.matID =matID where (qualite LIKE ? or usagePro = ?)";
            
             Connection cnx= MyDB.getInsatnce().getConnection();
            String ch=""+chaine+"%";
         System.out.println(sql);
            ObservableList<categorie> myList= FXCollections.observableArrayList();
        try {
           
            Statement ste= cnx.createStatement();
           // PreparedStatement pst = myCNX.getCnx().prepareStatement(requete6);
            PreparedStatement stee =cnx.prepareStatement(sql);  
            stee.setString(1, ch);
            stee.setString(2, ch);

         System.out.println(stee);

            ResultSet rs = stee.executeQuery();
            while (rs.next()){
                 categorie c = new categorie();
               c.setIdc(rs.getInt("idc"));
               c.setNomc(rs.getString("nomc"));
               c.setMatId(rs.getInt("matID"));
               c.setUsagePro(rs.getString("usagePro"));
               c.setQualite(rs.getString("qualite"));
               
                myList.add(c);
                System.out.println("titre trouvé! ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
      }
}
