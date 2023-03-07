/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Emna
 */
public class categorie {
   int fournisseur, matId, idc;
   String nomc, usagePro, qualite;

    public categorie(int fournisseur, int matId, int idc, String nomc, String usagePro, String qualite) {
        this.fournisseur = fournisseur;
        this.matId = matId;
        this.idc = idc;
        this.nomc = nomc;
        this.usagePro = usagePro;
        this.qualite = qualite;
    }

    public categorie(int matId, int idc, String nomc, String usagePro, String qualite) {
        this.matId = matId;
        this.idc = idc;
        this.nomc = nomc;
        this.usagePro = usagePro;
        this.qualite = qualite;
    }

    public categorie(String nomc, String usagePro, String qualite) {
        this.nomc = nomc;
        this.usagePro = usagePro;
        this.qualite = qualite;
    }
    

    public categorie() {
    }

    @Override
    public String toString() {
        return "categorie{" + "fournisseur=" + fournisseur + ", matId=" + matId + ", idc=" + idc + ", nomc=" + nomc + ", usagePro=" + usagePro + ", qualite=" + qualite + '}';
    }

    public int getFournisseur() {
        return fournisseur;
    }

    public int getMatId() {
        return matId;
    }

    public int getIdc() {
        return idc;
    }

    public String getNomc() {
        return nomc;
    }

    public String getUsagePro() {
        return usagePro;
    }

    public String getQualite() {
        return qualite;
    }

    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public void setUsagePro(String usagePro) {
        this.usagePro = usagePro;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }
   
   
}
