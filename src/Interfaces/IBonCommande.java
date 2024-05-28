package Interfaces;

import Modeles.BonCarburant;
import java.util.List;

public interface IBonCommande {

    public int create(BonCarburant bonCommande);

    public int update(BonCarburant bonCommande);

    public int delete(BonCarburant bonCommande);

    public List<BonCarburant> afficherBonCommandes();
}
