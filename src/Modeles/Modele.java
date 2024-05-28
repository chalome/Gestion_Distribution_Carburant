
package Modeles;

public class Modele {
    private int modeleID;
    private String modeleNom;

    public Modele() {
    }

    public Modele(int modeleID, String modeleNom) {
        this.modeleID = modeleID;
        this.modeleNom = modeleNom;
    }

    public Modele(String modeleNom) {
        this.modeleNom = modeleNom;
    }

    public int getModeleID() {
        return modeleID;
    }

    public void setModeleID(int modeleID) {
        this.modeleID = modeleID;
    }

    public String getModeleNom() {
        return modeleNom;
    }

    public void setModeleNom(String modeleNom) {
        this.modeleNom = modeleNom;
    }

    @Override
    public String toString() {
        return  modeleNom;
    }
    
    
}
