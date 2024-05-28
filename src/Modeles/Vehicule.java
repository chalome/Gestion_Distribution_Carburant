
package Modeles;

public class Vehicule {
    private int vehivuleID;
    private String vehiculePlaque;
    private String vehiculeModele;
    private String vehiculeAnneeFabrication;
    private String vehiculeTypeCarburant;
    private double vehiculeConsommationMoyenne;
    private String vehiculeService;
    private String vehiculeChauffeur;

    public Vehicule(int vehivuleID, String vehiculePlaque, String vehiculeModele, String vehiculeAnneeFabrication, String vehiculeTypeCarburant, double vehiculeConsommationMoyenne, String vehiculeService, String vehiculeChauffeur) {
        this.vehivuleID = vehivuleID;
        this.vehiculePlaque = vehiculePlaque;
        this.vehiculeModele = vehiculeModele;
        this.vehiculeAnneeFabrication = vehiculeAnneeFabrication;
        this.vehiculeTypeCarburant = vehiculeTypeCarburant;
        this.vehiculeConsommationMoyenne = vehiculeConsommationMoyenne;
        this.vehiculeService = vehiculeService;
        this.vehiculeChauffeur = vehiculeChauffeur;
    }

    public Vehicule(String vehiculePlaque, String vehiculeModele, String vehiculeAnneeFabrication, String vehiculeTypeCarburant, double vehiculeConsommationMoyenne, String vehiculeService, String vehiculeChauffeur) {
        this.vehiculePlaque = vehiculePlaque;
        this.vehiculeModele = vehiculeModele;
        this.vehiculeAnneeFabrication = vehiculeAnneeFabrication;
        this.vehiculeTypeCarburant = vehiculeTypeCarburant;
        this.vehiculeConsommationMoyenne = vehiculeConsommationMoyenne;
        this.vehiculeService = vehiculeService;
        this.vehiculeChauffeur = vehiculeChauffeur;
    }
    
    
    public String getVehiculeChauffeur() {
        return vehiculeChauffeur;
    }

    public void setVehiculeChauffeur(String vehiculeChauffeur) {
        this.vehiculeChauffeur = vehiculeChauffeur;
    }
    
    public String getVehiculeService() {
        return vehiculeService;
    }

    public void setVehiculeService(String vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    public Vehicule() {
    }


    public int getVehivuleID() {
        return vehivuleID;
    }

    public void setVehivuleID(int vehivuleID) {
        this.vehivuleID = vehivuleID;
    }

    public String getVehiculePlaque() {
        return vehiculePlaque;
    }

    public void setVehiculePlaque(String vehiculePlaque) {
        this.vehiculePlaque = vehiculePlaque;
    }

    public String getVehiculeModele() {
        return vehiculeModele;
    }

    public void setVehiculeModele(String vehiculeModele) {
        this.vehiculeModele = vehiculeModele;
    }

    public String getVehiculeAnneeFabrication() {
        return vehiculeAnneeFabrication;
    }

    public void setVehiculeAnneeFabrication(String vehiculeAnneeFabrication) {
        this.vehiculeAnneeFabrication = vehiculeAnneeFabrication;
    }

    public String getVehiculeTypeCarburant() {
        return vehiculeTypeCarburant;
    }

    public void setVehiculeTypeCarburant(String vehiculeTypeCarburant) {
        this.vehiculeTypeCarburant = vehiculeTypeCarburant;
    }

    public double getVehiculeConsommationMoyenne() {
        return vehiculeConsommationMoyenne;
    }

    public void setVehiculeConsommationMoyenne(double vehiculeConsommationMoyenne) {
        this.vehiculeConsommationMoyenne = vehiculeConsommationMoyenne;
    }

    @Override
    public String toString() {
        return vehiculePlaque;
    }
    
    
}
