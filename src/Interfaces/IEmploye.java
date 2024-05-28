package Interfaces;

import Modeles.Employe;
import java.util.List;

public interface IEmploye {

    public int create(Employe employe);

    public int update(Employe employe);

    public int delete(Employe employe);

    public List<Employe> afficherEmployes();


}
