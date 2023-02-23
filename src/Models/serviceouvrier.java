/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Administrator
 */
public class serviceouvrier {
    String Tache;
    String ClientName;
    int ClientPhone;

    public serviceouvrier() {
    }

    public serviceouvrier(String Tache, String ClientName, int ClientPhone) {
        this.Tache = Tache;
        this.ClientName = ClientName;
        this.ClientPhone = ClientPhone;
    }

    public String getTache() {
        return Tache;
    }

    public void setTache(String Tache) {
        this.Tache = Tache;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public int getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(int ClientPhone) {
        this.ClientPhone = ClientPhone;
    }

    @Override
    public String toString() {
        return "serviceouvrier{" + "Tache=" + Tache + ", ClientName=" + ClientName + ", ClientPhone=" + ClientPhone + '}';
    }
    
}
