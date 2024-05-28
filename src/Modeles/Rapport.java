
package Modeles;

public class Rapport {
  private int rapportID;
  private double rapportQuantite;
  private int rapportCout;
  private String rapportPeriode;
  private double rapportQuantiteConsomme;
  private int rapportCoutConsomme;
  private String rapportCommantaire;
  private int rapportTransaction;
  private String rapportDate;

    public Rapport() {
    }

    public Rapport(int rapportID, double rapportQuantite, int rapportCout, String rapportPeriode, double rapportQuantiteConsomme, int rapportCoutConsomme, String rapportCommantaire, int rapportTransaction, String rapportDate) {
        this.rapportID = rapportID;
        this.rapportQuantite = rapportQuantite;
        this.rapportCout = rapportCout;
        this.rapportPeriode = rapportPeriode;
        this.rapportQuantiteConsomme = rapportQuantiteConsomme;
        this.rapportCoutConsomme = rapportCoutConsomme;
        this.rapportCommantaire = rapportCommantaire;
        this.rapportTransaction = rapportTransaction;
        this.rapportDate = rapportDate;
    }
  

    public Rapport(double rapportQuantite, int rapportCout, String rapportPeriode, double rapportQuantiteConsomme, int rapportCoutConsomme, String rapportCommantaire, int rapportTransaction) {
        this.rapportQuantite = rapportQuantite;
        this.rapportCout = rapportCout;
        this.rapportPeriode = rapportPeriode;
        this.rapportQuantiteConsomme = rapportQuantiteConsomme;
        this.rapportCoutConsomme = rapportCoutConsomme;
        this.rapportCommantaire = rapportCommantaire;
        this.rapportTransaction = rapportTransaction;
    }

    public int getRapportID() {
        return rapportID;
    }

    public void setRapportID(int rapportID) {
        this.rapportID = rapportID;
    }

    public double getRapportQuantite() {
        return rapportQuantite;
    }

    public void setRapportQuantite(double rapportQuantite) {
        this.rapportQuantite = rapportQuantite;
    }

    public int getRapportCout() {
        return rapportCout;
    }

    public void setRapportCout(int rapportCout) {
        this.rapportCout = rapportCout;
    }

    public String getRapportPeriode() {
        return rapportPeriode;
    }

    public void setRapportPeriode(String rapportPeriode) {
        this.rapportPeriode = rapportPeriode;
    }

    public double getRapportQuantiteConsomme() {
        return rapportQuantiteConsomme;
    }

    public void setRapportQuantiteConsomme(double rapportQuantiteConsomme) {
        this.rapportQuantiteConsomme = rapportQuantiteConsomme;
    }

    public int getRapportCoutConsomme() {
        return rapportCoutConsomme;
    }

    public void setRapportCoutConsomme(int rapportCoutConsomme) {
        this.rapportCoutConsomme = rapportCoutConsomme;
    }

    public String getRapportCommantaire() {
        return rapportCommantaire;
    }

    public void setRapportCommantaire(String rapportCommantaire) {
        this.rapportCommantaire = rapportCommantaire;
    }

    public int getRapportTransaction() {
        return rapportTransaction;
    }

    public void setRapportTransaction(int rapportTransaction) {
        this.rapportTransaction = rapportTransaction;
    }

    public String getRapportDate() {
        return rapportDate;
    }

    public void setRapportDate(String rapportDate) {
        this.rapportDate = rapportDate;
    }
  
}
