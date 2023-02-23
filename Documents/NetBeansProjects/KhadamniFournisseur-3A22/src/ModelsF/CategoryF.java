/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsF;

/**
 *
 * @author Emna
 */
public class CategoryF {

    public static void add(CategoryF fc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     //att
    private int idC;
    private String nomC;
   private String description;
   private boolean ProUsage;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public CategoryF(int idC, String nomC, String description, boolean ProUsage) {
        this.idC = idC;
        this.nomC = nomC;
        this.description = description;
        this.ProUsage = ProUsage;
    }
    

//const

    public CategoryF() {
    }

    public CategoryF(int idC, String nomC, boolean ProUsage) {
        this.idC = idC;
        this.nomC = nomC;
        this.ProUsage = ProUsage;
    }
    //Getters

    public int getIdC() {
        return idC;
    }


    public String getNomC() {
        return nomC;
    }

  
 

    public boolean isProUsage() {
        return ProUsage;
    }
    //Setters

    public void setIdC(int idC) {
        this.idC = idC;
    }



    public void setNomC(String nomC) {
        this.nomC = nomC;
    }
    
    public void setProUsage(boolean ProUsage) {
        this.ProUsage = ProUsage;
    }
    //Display
    @Override
    public String toString() {
        return "CategoryF{" + "idC=" + idC + ", nomC=" + nomC + ", description=" + description + ", ProUsage=" + ProUsage + '}';
    }



    

   
//    public void setType(String accessoire) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
    
}



