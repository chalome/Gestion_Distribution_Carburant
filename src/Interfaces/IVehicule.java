
package Interfaces;

import Modeles.Vehicule;
import java.util.List;

public interface IVehicule {
 
    public int create(Vehicule vehicule);

    public int update(Vehicule vehicule);

    public int delete(Vehicule vehicule);

    public List<Vehicule> afficherVehicules();   
}
