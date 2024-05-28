package Interfaces;

import Modeles.Modele;
import java.util.List;

public interface IModele {

    public int create(Modele modele);

    public int update(Modele modele);

    public int delete(Modele modele);

    public List<Modele> afficherModeles();

}
