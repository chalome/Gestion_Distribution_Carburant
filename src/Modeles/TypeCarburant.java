
package Modeles;

public class TypeCarburant {
    private int carburantID;
    private String carburantNom;

    public TypeCarburant() {
    }

    public TypeCarburant(int carburantID, String carburantNom) {
        this.carburantID = carburantID;
        this.carburantNom = carburantNom;
    }

    public TypeCarburant(String carburantNom) {
        this.carburantNom = carburantNom;
    }

    public int getCarburantID() {
        return carburantID;
    }

    public void setCarburantID(int carburantID) {
        this.carburantID = carburantID;
    }

    public String getCarburantNom() {
        return carburantNom;
    }

    public void setCarburantNom(String carburantNom) {
        this.carburantNom = carburantNom;
    }

    @Override
    public String toString() {
        return carburantNom;
    }
    
}
