package Modeles;

public class Employe {

    private int employeID;
    private String employeMatricule;
    private String employeNom;
    private String employePrenom;
    private String employeAdresse;
    private String employeService;
    private String employeCategorie;
    private String employeTelephone;

    public Employe() {
    }

    public Employe(String employeMatricule, String employePrenom, String employeCategorie) {
        this.employeMatricule = employeMatricule;
        this.employePrenom = employePrenom;
        this.employeCategorie = employeCategorie;
    }

    public Employe(int employeID, String employeMatricule, String employeNom, String employePrenom, String employeAdresse, String employeSerice, String employeCategorie, String employeTelephone) {
        this.employeID = employeID;
        this.employeMatricule = employeMatricule;
        this.employeNom = employeNom;
        this.employePrenom = employePrenom;
        this.employeAdresse = employeAdresse;
        this.employeService = employeSerice;
        this.employeCategorie = employeCategorie;
        this.employeTelephone = employeTelephone;
    }

    public Employe(String employeMatricule, String employePrenom) {
        this.employeMatricule = employeMatricule;
        this.employePrenom = employePrenom;
    }

    public Employe(String employeMatricule, String employeNom, String employePrenom, String employeAdresse, String employeSerice, String employeCategorie, String employeTelephone) {
        this.employeMatricule = employeMatricule;
        this.employeNom = employeNom;
        this.employePrenom = employePrenom;
        this.employeAdresse = employeAdresse;
        this.employeService = employeSerice;
        this.employeCategorie = employeCategorie;
        this.employeTelephone = employeTelephone;
    }

    public int getEmployeID() {
        return employeID;
    }

    /**
     * @param employeID the employeID to set
     */
    public void setEmployeID(int employeID) {
        this.employeID = employeID;
    }

    /**
     * @return the employeMatricule
     */
    public String getEmployeMatricule() {
        return employeMatricule;
    }

    /**
     * @param employeMatricule the employeMatricule to set
     */
    public void setEmployeMatricule(String employeMatricule) {
        this.employeMatricule = employeMatricule;
    }

    /**
     * @return the employeNom
     */
    public String getEmployeNom() {
        return employeNom;
    }

    /**
     * @param employeNom the employeNom to set
     */
    public void setEmployeNom(String employeNom) {
        this.employeNom = employeNom;
    }

    /**
     * @return the employePrenom
     */
    public String getEmployePrenom() {
        return employePrenom;
    }

    /**
     * @param employePrenom the employePrenom to set
     */
    public void setEmployePrenom(String employePrenom) {
        this.employePrenom = employePrenom;
    }

    /**
     * @return the employeAdresse
     */
    public String getEmployeAdresse() {
        return employeAdresse;
    }

    /**
     * @param employeAdresse the employeAdresse to set
     */
    public void setEmployeAdresse(String employeAdresse) {
        this.employeAdresse = employeAdresse;
    }

    /**
     * @return the employeSerice
     */
    public String getEmployeSerice() {
        return employeService;
    }

    /**
     * @param employeSerice the employeSerice to set
     */
    public void setEmployeSerice(String employeSerice) {
        this.employeService = employeSerice;
    }

    /**
     * @return the employeTelephone
     */
    public String getEmployeTelephone() {
        return employeTelephone;
    }

    /**
     * @param employeTelephone the employeTelephone to set
     */
    public void setEmployeTelephone(String employeTelephone) {
        this.employeTelephone = employeTelephone;
    }

    @Override
    public String toString() {
        return employeNom + " " + employePrenom;
    }

    /**
     * @return the employeCategorie
     */
    public String getEmployeCategorie() {
        return employeCategorie;
    }

    /**
     * @param employeCategorie the employeCategorie to set
     */
    public void setEmployeCategorie(String employeCategorie) {
        this.employeCategorie = employeCategorie;
    }

}
