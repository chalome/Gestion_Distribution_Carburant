package Modeles;

public class BonCarburant {

    private int bonCarburantID;
    private String carburant;
    private String BonCarburantDate;
    private String bonCarburantVehicule;
    private String bonEmploye;
    private int bonDemandeID;
    private double bonQuantite;
    private String bonStation;

    public BonCarburant() {
    }

    public BonCarburant(int bonCarburantID, String carburant, String BonCarburantDate, String bonCarburantVehicule, String bonEmploye, int bonDemandeID, double bonQuantite, String bonStation) {
        this.bonCarburantID = bonCarburantID;
        this.carburant = carburant;
        this.BonCarburantDate = BonCarburantDate;
        this.bonCarburantVehicule = bonCarburantVehicule;
        this.bonEmploye = bonEmploye;
        this.bonDemandeID = bonDemandeID;
        this.bonQuantite = bonQuantite;
        this.bonStation = bonStation;
    }

    public BonCarburant(String carburant, String bonCarburantVehicule, String bonEmploye, int bonDemandeID, double bonQuantite, String bonStation) {
        this.carburant = carburant;
        this.bonCarburantVehicule = bonCarburantVehicule;
        this.bonEmploye = bonEmploye;
        this.bonDemandeID = bonDemandeID;
        this.bonQuantite = bonQuantite;
        this.bonStation = bonStation;
    }

    public BonCarburant(int bonCarburantID, String carburant, String bonCarburantVehicule, String bonEmploye, int bonDemandeID, double bonQuantite, String bonStation) {
        this.bonCarburantID = bonCarburantID;
        this.carburant = carburant;
        this.bonCarburantVehicule = bonCarburantVehicule;
        this.bonEmploye = bonEmploye;
        this.bonDemandeID = bonDemandeID;
        this.bonQuantite = bonQuantite;
        this.bonStation = bonStation;
    }
 

    public double getBonQuantite() {
        return bonQuantite;
    }

    public void setBonQuantite(double bonQuantite) {
        this.bonQuantite = bonQuantite;
    }

  

    public int getBonDemandeID() {
        return bonDemandeID;
    }

    public void setBonDemandeID(int bonDemandeID) {
        this.bonDemandeID = bonDemandeID;
    }

    public int getBonCarburantID() {
        return bonCarburantID;
    }

    public void setBonCarburantID(int bonCarburantID) {
        this.bonCarburantID = bonCarburantID;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getBonCarburantDate() {
        return BonCarburantDate;
    }

    public void setBonCarburantDate(String BonCarburantDate) {
        this.BonCarburantDate = BonCarburantDate;
    }

    public String getBonCarburantVehicule() {
        return bonCarburantVehicule;
    }

    public void setBonCarburantVehicule(String bonCarburantVehicule) {
        this.bonCarburantVehicule = bonCarburantVehicule;
    }

    public String getBonEmploye() {
        return bonEmploye;
    }

    public void setBonEmploye(String bonEmploye) {
        this.bonEmploye = bonEmploye;
    }

    public String getBonStation() {
        return bonStation;
    }

    public void setBonStation(String bonStation) {
        this.bonStation = bonStation;
    }

}
