/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Mariem
 */
public class Avis {
    private int id_avis;
    private utilisateur user;    // creation d un objet appl user pour faire la jointure et dans le service je l'identifie avec la bd pour qu'il se connait comme cin //
    private String role,nv_satif, comment;
    
    public Avis() {
    }

    public Avis( utilisateur user, String role, String nv_satif, String comment) {
        this.user = user;
        this.role = role;
        this.nv_satif = nv_satif;
        this.comment = comment;
    }

    public Avis(int id_avis, utilisateur user, String role, String nv_satif, String comment) {
        this.id_avis = id_avis;
        this.user = user;
        this.role = role;
        this.nv_satif = nv_satif;
        this.comment = comment;
    }

    public int getId_avis() {
        return id_avis;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }



    public utilisateur getUser() {
        return user;
    }

    public void setUser(utilisateur user) {
        this.user = user;
    }

   
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNv_satif() {
        return nv_satif;
    }

    public void setNv_satif(String nv_satif) {
        this.nv_satif = nv_satif;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", user=" + user + ",role=" + role + ", nv_satif=" + nv_satif + ", comment=" + comment + '}';
    }

    

   

}   