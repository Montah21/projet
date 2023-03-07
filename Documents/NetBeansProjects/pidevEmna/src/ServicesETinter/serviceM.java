/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesETinter;
import Entity.materiel;
import Util.MyDB;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Emna
 */
public class serviceM implements MatInterface {
    
    Connection cnx;

    public serviceM() {
                cnx=MyDB.getInsatnce().getConnection();
    }
    /*************************************************************************************************/
     
    public void AjouterMat(materiel m) {
         try {
             
                String req = "insert into materiel(idm,nom,prix,quantite,valabilite,image)"
                        +"values("+1+",'"+m.getNomM()+"','"+m.getPrix()+"','"+m.getQuantite()+"','"+m.getValabilite()+"',"
                        +m.getImage()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("materiel ajouté avec succ");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());        }    }

    /*******************************************************************************************************/
    
    public void ModifierMat(materiel m) {
        try {

            
            String req ="UPDATE materiel SET idm=1,nom=?,prix=?,quantite=?,valabilite=?,image=? WHERE idm=?;";
            PreparedStatement ps= cnx.prepareStatement(req); //req dynamic plus securiser
           
            ps.setString(2,m.getNomM());
            ps.setFloat(3,m.getPrix());
            ps.setInt(4,m.getQuantite());
            ps.setString(5,m.getValabilite());
           
            ps.setString(6,m.getImage());
            ps.setInt(1,m.getIdm());

           ps.executeUpdate();
                        System.out.println("materiel Modifié avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(serviceM.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    /****************************************************************************************/
    
    @Override
    public void SupprimerMat(int idm) {
			try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM materiel WHERE idm = "+idm+"";
                st.executeUpdate(req);      
      System.out.println("Le materiel avec l'id = "+idm+" a été supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }
/*****************************************************************************************/
    @Override
    public List<materiel> RecupererMat() {
 List<materiel> mat = new ArrayList<>();
        try {
            String req ="select * from materiel";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               materiel m = new materiel();
               m.setIdm(rs.getInt("idm"));
               m.setNomM(rs.getString("nom"));
               m.setPrix(rs.getFloat("prix"));
               m.setQuantite(rs.getInt("quantite"));
               m.setValabilite(rs.getString("valabilite"));
               m.setImage(rs.getString("image"));
              
               
               mat.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return mat;    }

/**************************************************************************************************/
    @Override
    public List<materiel> RecupererMatTrieNom() {
 List<materiel> mat = new ArrayList<>();
        try {
            String req ="select * from materiel order by nom";
            Statement st = cnx.createStatement();   //req statique 
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
              materiel m = new materiel();
               m.setIdm(rs.getInt("idm"));
               m.setNomM(rs.getString("nom"));
               m.setPrix(rs.getFloat("prix"));
               m.setQuantite(rs.getInt("quantite"));
               m.setValabilite(rs.getString("valabilite"));
               m.setImage(rs.getString("image"));
              
               
               mat.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return mat;    }
    /************************************************************************************************************/
    @Override
     public List<materiel> RechercheMat(String Nom) {
 List<materiel> mat = new ArrayList<>();

        try {
            String req ="select * from materiel WHERE nom = '"+Nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               materiel m =new materiel();
               m.setIdm(rs.getInt("idm"));
               m.setNomM(rs.getString("nom"));
               m.setPrix(rs.getFloat("prix"));
               m.setQuantite(rs.getInt("quantite"));
               m.setValabilite(rs.getString("valabilite"));
               m.setImage(rs.getString("image"));
               
               mat.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return mat;    }
/*****************************************************************************************************/
    @Override
  public List<materiel> RecupererMatDisponible() {
 List<materiel> mat = new ArrayList<>();
        try {
            String req ="select * from materiel WHERE valabilite = 'Disponible'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                 materiel m =new materiel();
               m.setIdm(rs.getInt("idm"));
               m.setNomM(rs.getString("nom"));
               m.setPrix(rs.getFloat("prix"));
               m.setQuantite(rs.getInt("quantite"));
               m.setValabilite(rs.getString("valabilite"));
               m.setImage(rs.getString("image"));
               
               mat.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return mat;        }
/******************************************************************************************************/
    
    @Override
     public List<materiel> RecupererMatNonDisponible() {
 List<materiel> mat = new ArrayList<>();
        try {
            String req ="select * from materiel WHERE valabilite = 'Non Disponible'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                 materiel m =new materiel();
               m.setIdm(rs.getInt("idm"));
               m.setNomM(rs.getString("nom"));
               m.setPrix(rs.getFloat("prix"));
               m.setQuantite(rs.getInt("quantite"));
               m.setValabilite(rs.getString("valabilite"));
               m.setImage(rs.getString("image"));
               mat.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return mat;   
    }
    /********************************************************************************************************/

    @Override
    public List<materiel> RecupererMatBientotdisponible() {
 List<materiel> mat = new ArrayList<>();
        try {
            String req ="select * from materiel WHERE valabilite = 'Bientot Disponible'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                 materiel m =new materiel();
              m.setIdm(rs.getInt("idm"));
               m.setNomM(rs.getString("nom"));
               m.setPrix(rs.getFloat("prix"));
               m.setQuantite(rs.getInt("quantite"));
               m.setValabilite(rs.getString("valabilite"));
               m.setImage(rs.getString("image"));
               mat.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return mat;   
    }
    /*************************************************************************************************************/
     public List <materiel> listeMat()
    {
        String sql = "select * from materiel";
        
       List <materiel> list = new ArrayList<>(); 
       try {
       PreparedStatement ps=cnx.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
       
       while (rs.next())
       {
           list.add(new materiel(rs.getInt("idm"),rs.getString("nom"),rs.getFloat("prix"),rs.getInt("quantite"),rs.getString("valabilite"),rs.getString("image")));
       }
       
       }
       catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    return list; 
    }
    
    //--------------------------------- getvoyageList() ------------------------------------------------------//
    public ObservableList<materiel> getMatList() throws SQLException
    {
        ObservableList<materiel> materiellist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select * from materiel WHERE valabilite = 'Disponible'";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        materiel materiel;
        while (rs.next()) {
           materiel= new materiel(rs.getInt("idm"),rs.getString("nom"),rs.getFloat("prix"),rs.getInt("quantite"),rs.getString("valabilite"),rs.getString("image")); 
            //System.out.println(events);
            materiellist.add(materiel);

        }
         return materiellist;    
    }
    /**
     * @throws java.sql.SQLException*****************************************************************************************************/
    public ObservableList<materiel> getMaterielNon_Disponible() throws SQLException
    {
        ObservableList<materiel> materiellist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select * from materiel WHERE valabilite = 'Non Disponible'";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        materiel materiel;
        while (rs.next()) {
           materiel= new materiel(rs.getInt("idm"),rs.getString("nom"),rs.getFloat("prix"),rs.getInt("quantite"),rs.getString("valabilite"),rs.getString("image")); 
            //System.out.println(events);
            materiellist.add(materiel);

        }
         return materiellist;    
    }
    /************************************************************************************/
        public ObservableList<materiel> getMatDisponible() throws SQLException
    {
        ObservableList<materiel> materiellist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select * from materiel WHERE valabilite = 'Disponible'";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        materiel materiel;
        while (rs.next()) {
           materiel= new materiel(rs.getInt("idm"),rs.getString("nom"),rs.getFloat("prix"),rs.getInt("quantite"),rs.getString("valabilite"),rs.getString("image")); 
            //System.out.println(events);
            materiellist.add(materiel);

        }
         return materiellist;    
    }  
        /************************************************************************************************/
        public ObservableList<materiel> getMatBientot_Disponible() throws SQLException
    {
        ObservableList<materiel> materiellist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select * from materiel WHERE valabilite = 'Bientot Disponible'";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        materiel materiel;
        while (rs.next()) {
           materiel= new materiel(rs.getInt("idm"),rs.getString("nom"),rs.getFloat("prix"),rs.getInt("quantite"),rs.getString("valabilite"),rs.getString("image")); 
            //System.out.println(events);
            materiellist.add(materiel);

        }
         return materiellist;    
    }
     //----------------------------------------  Display Destination by ID --------------------------------------------------------------//
     public String getNomMatID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from materiel where idm=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("nom");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(materiel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     public String getnomID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * materiel where idm=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("nom");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(materiel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     public String getduree_voyageID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from materiel where idm=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("qualite");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(materiel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     public String getvalabiliteID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from materiel where idm=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("valabilite");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(materiel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     
     public float getprixID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from materiel where idm=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getFloat("prix");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(materiel.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return 0;
    }
     public void modifier(materiel m ,int idm) {
           try {
             
PreparedStatement ps= cnx.prepareStatement("UPDATE materiel SET fournisseur_id=19,nom=?,prix=?,quantite=?,valabilite=?,image=? WHERE id=?");           
            ps.setString(2,m.getNomM());
            ps.setFloat(3,m.getPrix());
            ps.setInt(4,m.getQuantite());
            ps.setString(5,m.getValabilite());
           
            ps.setString(6,m.getImage());
            ps.setInt(1,m.getIdm());



           ps.executeUpdate();
                        System.out.println("materiel Modifer avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(serviceM.class.getName()).log(Level.SEVERE, null, ex);
        }   

    }
     public ObservableList<materiel> chercherVoyage(String chaine){
          String sql="SELECT * FROM materiel WHERE (nom LIKE ? or prix LIKE ? or valabilite LIKE ? or prix = ? )";
            
             Connection cnx= MyDB.getInsatnce().getConnection();
            String ch=""+chaine+"%";
         System.out.println(sql);
            ObservableList<materiel> myList= FXCollections.observableArrayList();
        try {
           
            Statement ste= cnx.createStatement();
           // PreparedStatement pst = myCNX.getCnx().prepareStatement(requete6);
            PreparedStatement stee =cnx.prepareStatement(sql);  
            stee.setString(1, ch);
            stee.setString(2, ch);
            stee.setString(3, ch);
            stee.setString(4, ch);
            stee.setString(5, ch);
         System.out.println(stee);

            ResultSet rs = stee.executeQuery();
            while (rs.next()){
                materiel m = new materiel();
               m.setIdm(rs.getInt("idm"));
               m.setNomM(rs.getString("nom"));
               m.setPrix(rs.getFloat("prix"));
               m.setQuantite(rs.getInt("quantite"));
               m.setValabilite(rs.getString("valabilite"));
               m.setImage(rs.getString("image"));
              
               
               

                myList.add(m);
                System.out.println("titre trouvé! ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
      }
      //---------------------------------------- Excel -----------------------------------------------------------//
     
     public void getDefendants( String db) throws Exception  { 
        
        @SuppressWarnings("unused")
        Workbook rbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\EMNA\\Documents\\NetBeansProjects\\pidevEmna\\test2.xls") );
        @SuppressWarnings("resource")
        Workbook writeWorkbook = (Workbook) new HSSFWorkbook();
        Sheet desSheet = writeWorkbook.createSheet("new sheet");

        Statement stmt = null;
        ResultSet rs = null;
        try{
            String query ="SELECT * FROM MATERIEL"+db;

            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            Row desRow1 = desSheet.createRow(0);
            for(int col=0 ;col < columnsNumber;col++) {
                Cell newpath = desRow1.createCell(col);
                newpath.setCellValue(rsmd.getColumnLabel(col+1));
            }
            while(rs.next()) {
                System.out.println("Row number" + rs.getRow() );
                Row desRow = desSheet.createRow(rs.getRow());
                for(int col=0 ;col < columnsNumber;col++) {
                    Cell newpath = desRow.createCell(col);
                    newpath.setCellValue(rs.getString(col+1));  
                }
                FileOutputStream fileOut = new FileOutputStream("C:\\Users\\EMNA\\Documents\\NetBeansProjects\\pidevEmna\\test2.xls");
                writeWorkbook.write(fileOut);
                fileOut.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Failed to get data from database");
        }
    }
     
     //--------------------------- NB Voyage ---------------------------------------------//
     public int calculnb(String nom) {

        PreparedStatement pre;
        int count = 19;
        try {
            Statement stmt = cnx.createStatement();

            String query = "SELECT COUNT(*) FROM materiel WHERE nom='"+nom+"'";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            count = rs.getInt(1);
            return count;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;

    } 

    @Override
    public void AjouterMat(Object m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModifierMat(Object m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
