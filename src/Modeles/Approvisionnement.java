
package Modeles;

public class Approvisionnement {
    private int approvisionID;
    private double approvisionQuantite;
    private int approvisionPU;
    private int approvisionPT;
    private String approvisionFournisseur;
    private String approvisionCarburant;

    public Approvisionnement(int approvisionID, double approvisionQuantite, int approvisionPU, int approvisionPT, String approvisionFournisseur, String approvisionCarburant) {
        this.approvisionID = approvisionID;
        this.approvisionQuantite = approvisionQuantite;
        this.approvisionPU = approvisionPU;
        this.approvisionPT = approvisionPT;
        this.approvisionFournisseur = approvisionFournisseur;
        this.approvisionCarburant = approvisionCarburant;
    }

    public Approvisionnement() {
    }

    public Approvisionnement(double approvisionQuantite, int approvisionPU, int approvisionPT, String approvisionFournisseur, String approvisionCarburant) {
        this.approvisionQuantite = approvisionQuantite;
        this.approvisionPU = approvisionPU;
        this.approvisionPT = approvisionPT;
        this.approvisionFournisseur = approvisionFournisseur;
        this.approvisionCarburant = approvisionCarburant;
    }

    public int getApprovisionID() {
        return approvisionID;
    }

    public void setApprovisionID(int approvisionID) {
        this.approvisionID = approvisionID;
    }

    public double getApprovisionQuantite() {
        return approvisionQuantite;
    }

    public void setApprovisionQuantite(double approvisionQuantite) {
        this.approvisionQuantite = approvisionQuantite;
    }

    public int getApprovisionPU() {
        return approvisionPU;
    }

    public void setApprovisionPU(int approvisionPU) {
        this.approvisionPU = approvisionPU;
    }

    public int getApprovisionPT() {
        return approvisionPT;
    }

    public void setApprovisionPT(int approvisionPT) {
        this.approvisionPT = approvisionPT;
    }

    public String getApprovisionFournisseur() {
        return approvisionFournisseur;
    }

    public void setApprovisionFournisseur(String approvisionFournisseur) {
        this.approvisionFournisseur = approvisionFournisseur;
    }

    public String getApprovisionCarburant() {
        return approvisionCarburant;
    }

    public void setApprovisionCarburant(String approvisionCarburant) {
        this.approvisionCarburant = approvisionCarburant;
    }
    
    
}
