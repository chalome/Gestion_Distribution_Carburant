package Modeles;

public class Transaction {

    private int transactionID;
    private double transactionQuantite;
    private int transactionPrixUnitaire;
    private int transactionPrixTotal;
    private String transactionDate;
    private String transactionBonCommande;
    private String transactionStation;

    public Transaction(double transactionQuantite, int transactionPrixUnitaire, int transactionPrixTotal, String transactionBonCommande, String transactionStation) {
        this.transactionQuantite = transactionQuantite;
        this.transactionPrixUnitaire = transactionPrixUnitaire;
        this.transactionPrixTotal = transactionPrixTotal;
        this.transactionBonCommande = transactionBonCommande;
        this.transactionStation = transactionStation;
    }

    public Transaction(int transactionID, double transactionQuantite, int transactionPrixUnitaire, int transactionPrixTotal, String transactionDate, String transactionBonCommande, String transactionStation) {
        this.transactionID = transactionID;
        this.transactionQuantite = transactionQuantite;
        this.transactionPrixUnitaire = transactionPrixUnitaire;
        this.transactionPrixTotal = transactionPrixTotal;
        this.transactionDate = transactionDate;
        this.transactionBonCommande = transactionBonCommande;
        this.transactionStation = transactionStation;
    }

    public Transaction(double transactionQuantite, int transactionPrixUnitaire, int transactionPrixTotal, String transactionDate, String transactionBonCommande, String transactionStation) {
        this.transactionQuantite = transactionQuantite;
        this.transactionPrixUnitaire = transactionPrixUnitaire;
        this.transactionPrixTotal = transactionPrixTotal;
        this.transactionDate = transactionDate;
        this.transactionBonCommande = transactionBonCommande;
        this.transactionStation = transactionStation;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public double getTransactionQuantite() {
        return transactionQuantite;
    }

    public void setTransactionQuantite(double transactionQuantite) {
        this.transactionQuantite = transactionQuantite;
    }

    public int getTransactionPrixUnitaire() {
        return transactionPrixUnitaire;
    }

    public void setTransactionPrixUnitaire(int transactionPrixUnitaire) {
        this.transactionPrixUnitaire = transactionPrixUnitaire;
    }

    public int getTransactionPrixTotal() {
        return transactionPrixTotal;
    }

    public void setTransactionPrixTotal(int transactionPrixTotal) {
        this.transactionPrixTotal = transactionPrixTotal;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionBonCommande() {
        return transactionBonCommande;
    }

    public void setTransactionBonCommande(String transactionBonCommande) {
        this.transactionBonCommande = transactionBonCommande;
    }

    public String getTransactionStation() {
        return transactionStation;
    }

    public void setTransactionStation(String transactionStation) {
        this.transactionStation = transactionStation;
    }

}
