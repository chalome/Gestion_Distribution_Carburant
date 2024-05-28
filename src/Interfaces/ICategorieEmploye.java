package Interfaces;

import Modeles.CategorieEmploye;
import java.util.List;

public interface ICategorieEmploye {

    public int create(CategorieEmploye typeEmploye);

    public int update(CategorieEmploye typeEmploye);

    public int delete(CategorieEmploye typeEmploye);

    public List<CategorieEmploye> afficherCategorieEmployes();
}
