package Interfaces;

import Modeles.Approvisionnement;
import java.util.List;

public interface IApprovisionnement {

    public int ajouter(Approvisionnement approvisionnement);

    public int modifier(Approvisionnement approvisionnement);

    public int supprimer(Approvisionnement approvisionnement);

    public List<Approvisionnement> listApprovisions();
}
