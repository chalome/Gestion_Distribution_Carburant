
package Interfaces;

import Modeles.TypeCarburant;
import java.util.List;

public interface ICarburant {
    
    public int create(TypeCarburant carburant);

    public int update(TypeCarburant carburant);

    public int delete(TypeCarburant carburant);

    public List<TypeCarburant> afficherTypeCaburants();
}
