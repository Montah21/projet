/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;
import java.sql.SQLException;
import Models.service;
import java.util.List;
import Models.application;
/**
 *
 * @author Administrator
 */
public interface ServiceInterface {
    
    public void addService(service p);
    public service afficherService(String ClientID);
  public List<service> afficherServices() throws SQLException;  
  public List<service> Jointure() throws SQLException;
  public List<service> FetchByID(int id)throws SQLException;
  public void SupprimerbyPhone(int id);
}
