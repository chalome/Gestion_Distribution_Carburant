
package Modeles;

public class Demande {
    private int demandeID;
    private double demandeQuantite;
    private String demandeService;
    private String demandeMotif;
    private String demandeDate;
    private String demandeEtat;
    private String demandeVehicule;
    public Demande() {
    }

    public Demande(int demandeID, double demandeQuantite, String demandeService, String demandeMotif, String demandeDate, String demandeEtat, String demandeVehicule) {
        this.demandeID = demandeID;
        this.demandeQuantite = demandeQuantite;
        this.demandeService = demandeService;
        this.demandeMotif = demandeMotif;
        this.demandeDate = demandeDate;
        this.demandeEtat = demandeEtat;
        this.demandeVehicule = demandeVehicule;
    }

    public Demande(double demandeQuantite, String demandeService, String demandeMotif, String demandeVehicule) {
        this.demandeQuantite = demandeQuantite;
        this.demandeService = demandeService;
        this.demandeMotif = demandeMotif;
        this.demandeVehicule = demandeVehicule;
    }

    public Demande(int demandeID, double demandeQuantite, String demandeService, String demandeMotif, String demandeVehicule) {
        this.demandeID = demandeID;
        this.demandeQuantite = demandeQuantite;
        this.demandeService = demandeService;
        this.demandeMotif = demandeMotif;
        this.demandeVehicule = demandeVehicule;
    }



    public String getDemandeVehicule() {
        return demandeVehicule;
    }

    public void setDemandeVehicule(String demandeVehicule) {
        this.demandeVehicule = demandeVehicule;
    }



    public String getDemandeEtat() {
        return demandeEtat;
    }

    public void setDemandeEtat(String demandeEtat) {
        this.demandeEtat = demandeEtat;
    }


    public int getDemandeID() {
        return demandeID;
    }

    public void setDemandeID(int demandeID) {
        this.demandeID = demandeID;
    }

    public double getDemandeQuantite() {
        return demandeQuantite;
    }

    public void setDemandeQuantite(double demandeQuantite) {
        this.demandeQuantite = demandeQuantite;
    }

    public String getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(String demandeService) {
        this.demandeService = demandeService;
    }

    public String getDemandeMotif() {
        return demandeMotif;
    }

    public void setDemandeMotif(String demandeMotif) {
        this.demandeMotif = demandeMotif;
    }

    public String getDemandeDate() {
        return demandeDate;
    }

    public void setDemandeDate(String demandeDate) {
        this.demandeDate = demandeDate;
    }
    
}
