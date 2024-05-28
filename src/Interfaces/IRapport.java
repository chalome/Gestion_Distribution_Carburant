package Interfaces;

import Modeles.Rapport;
import java.util.List;

public interface IRapport {

    public int create(Rapport rapport);

    public int update(Rapport rapport);

    public int delete(Rapport rapport);

    public List<Rapport> afficherRapport();
}
