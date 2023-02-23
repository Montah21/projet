/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Administrator
 */
public class service {
     private String ID_Client;
    private String Location;
    private String ServiceName;
    private int ClientPhone;
    private String OuvrierID;

    public service() {
    }

    public service(String ID_Client, String Location, String ServiceName, int ClientPhone, String OuvrierID) {
        this.ID_Client = ID_Client;
        this.Location = Location;
        this.ServiceName = ServiceName;
        this.ClientPhone = ClientPhone;
        this.OuvrierID = OuvrierID;
    }

    public String getID_Client() {
        return ID_Client;
    }

    public void setID_Client(String ID_Client) {
        this.ID_Client = ID_Client;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public int getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(int ClientPhone) {
        this.ClientPhone = ClientPhone;
    }

    public String getOuvrierID() {
        return OuvrierID;
    }

    public void setOuvrierID(String OuvrierID) {
        this.OuvrierID = OuvrierID;
    }

    @Override
    public String toString() {
        return "service{" + "ID_Client=" + ID_Client + ", Location=" + Location + ", ServiceName=" + ServiceName + ", ClientPhone=" + ClientPhone + ", OuvrierID=" + OuvrierID + '}';
    }

  
}
