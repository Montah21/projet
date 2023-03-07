/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevemna;
import Entity.categorie;
import Entity.materiel;
import Util.MyDB;
import Util.connexion;
import java.util.ArrayList;
import java.util.List;
import ServicesETinter.MatInterface;
import ServicesETinter.CatInterface;
import ServicesETinter.ServiceC;
import ServicesETinter.serviceM;





/**
 *
 * @author Emna
 */
public class PidevEmna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        

        MyDB db = MyDB.getInsatnce();
      //Ajouter 
//      Date Datevoy=Date.valueOf("2022-10-10");

//      materiel m = new materiel("poignet",5000,30,"Non Disponible","Image");
//      categorie c = new categorie(2,1,0,"peinture","pro","bonne");
//        serviceM sm = new serviceM();
//        ServiceC sc =new ServiceC();
//        sc.AjouterCat(c);
//         sm.AjouterMat(m);
//        
//        sm.ModifierMat(m);
//    
        //ps.SupprimerVoyage(35);

      //Affichage            
//         List<materiel> Listmat = new ArrayList<>();
//           
//         List<categorie> Listcat = new ArrayList<>();
//           
//        Listmat=sm.RecupererMat();
//        Listcat=sc.RecupererCat();
        

//       Listvoyage.sort(new Comparator<voyage>() {
//          @Override
//          public int compare(voyage o1, voyage o2) {
//              return o2.getNom_voyage().compareTo(o1.getNom_voyage());
//          }
//      }); 
      /*           List<voyage> Listtrievoyage = new ArrayList<>();

       Listtrievoyage = Listvoyage.stream().sorted(new Comparator<voyage>() {
          @Override
          public int compare(voyage o1, voyage o2) {
              return o2.getNom_voyage().compareTo(o1.getNom_voyage());
          }
      }).collect(Collectors.toList());
        
        */
        //Listvoyage=ps.RecupererVoyagetrieDestination();
        
       // Listvoyage=ps.RechercheVoyage("CA");
        
       // Listvoyage=ps.RecupererVoyageDisponible();
        
       // Listvoyage=ps.RecupererVoyageBientotdisponible();

      // Listvoyage=ps.RecupererVoyageNonDisponible();
      
//        ServiseReserVoy pss = new ServiseReserVoy();
        
        //pss.SupprimerReserverVoyage(1);
        
        //pss.AjouterReserverVoyage(r);

        //pss.ModifierReserverVoyage(r);

        
//        Listreservationvoyage=pss.RecupererReserverVoyage();
//        Scontrole_Voyage sc= new Scontrole_Voyage();   
        
//    System.out.println(Listmat);
//    System.out.println(sc.isNumeric("a"));

    }
        
        
        
    }
    

