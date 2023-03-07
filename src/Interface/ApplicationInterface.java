/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Models.application;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;
/**
 *
 * @author Administrator
 */
public interface ApplicationInterface {
    
    
    //add

    /**
     *
     * @param p
     */
    public void addApplication(application p);
    
    //list : select
   
    
    //affectation
    public void affecterApplication(application p);
    public void SupprimerApplication(String id);
    public application afficherApplication(String id);
    public List<application> afficherApplications() throws SQLException;
    public List<application> FetchByRole(String Role);
    public int FetchIDByNum(int Num) throws SQLException;
}
