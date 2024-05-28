package Modeles;

public class CategorieEmploye {

    private int CategorieEmployeID;
    private String CategorieEmploye;

    public CategorieEmploye() {
    }

    public CategorieEmploye(int TypeEmployeID, String typeEmploye) {
        this.CategorieEmployeID = TypeEmployeID;
        this.CategorieEmploye = typeEmploye;
    }

    public CategorieEmploye(String typeEmploye) {
        this.CategorieEmploye = typeEmploye;
    }

    public int getCategorieEmployeID() {
        return CategorieEmployeID;
    }

    public void setCategorieEmployeID(int TypeEmployeID) {
        this.CategorieEmployeID = TypeEmployeID;
    }

    public String getCategorieEmploye() {
        return CategorieEmploye;
    }

    public void setCategorieEmploye(String CategorieEmploye) {
        this.CategorieEmploye = CategorieEmploye;
    }

    @Override
    public String toString() {
        return CategorieEmploye;
    }

}
