
package Interfaces;

import Modeles.Demande;
import java.util.List;

public abstract class ADemande {
    public abstract int create(Demande demande);
    public abstract int update(Demande demande);
    public abstract int delete(Demande demande);
     public abstract boolean dejaExist(String text);
    public abstract String returnId(String parametre, String table, String cle, String valeur);
    public abstract List<Demande> afficherDemmandes();
}
