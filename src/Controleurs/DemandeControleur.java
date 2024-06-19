package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.ADemande;
import Modeles.Demande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DemandeControleur extends ADemande {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO demande(demandeQuantite,demandeService,demandeMotif,demandeVehicule) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE demande SET demandeQuantite=?,demandeService=?,demandeMotif=?,demandeVehicule=?WHERE demandeID=?";
    private static final String DELETE = "DELETE FROM demande WHERE demandeID=?";
    private static final String SELECT_ALL = "SELECT demandeID,demandeQuantite,serviceNom as service,demandeMotif,demandeDate,demandeEtatNom as etat,demandeVehicule FROM demande,demandeEtat,service where demande.demandeEtat=demandeEtat.demandeEtatID and demandeService=serviceID";

    public DemandeControleur() {
    }

    @Override
    public int create(Demande demande) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setDouble(1, demande.getDemandeQuantite());
            pst.setString(2, demande.getDemandeService());
            pst.setString(3, demande.getDemandeMotif());
            pst.setString(4, demande.getDemandeVehicule());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Demande demande) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setDouble(1, demande.getDemandeQuantite());
            pst.setString(2, demande.getDemandeService());
            pst.setString(3, demande.getDemandeMotif());
            pst.setString(4, demande.getDemandeVehicule());
            pst.setInt(5, demande.getDemandeID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Demande demande) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, demande.getDemandeID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        try {
            pst = connection.prepareStatement("SELECT * FROM demande WHERE demandeID=" + text);
            res = pst.executeQuery();
            while (res.next()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public String returnId(String parametre, String table, String cle, String valeur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Demande> afficherDemmandes() {
        List<Demande> demandes = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("demandeID");
                double qte = res.getDouble("demandeQuantite");
                String service = res.getString("service");
                String motif = res.getString("demandeMotif");
                String date = res.getString("demandeDate");
                String etat = res.getString("etat");
                String vehicule = res.getString("demandeVehicule");
                demandes.add(new Demande(id, qte, service, motif, date, etat, vehicule));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return demandes;
    }

    public void update(String id) {
        String SQL = "UPDATE demande SET demandeEtat=1 WHERE demandeID=" + id;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SQL);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public int refuser(int id) {
        String SQL = "UPDATE demande SET demandeEtat=2 WHERE demandeID=" + id;
        connection = getConnection();
        int refus = 0;
        try {
            pst = connection.prepareStatement(SQL);
            refus = pst.executeUpdate();
            return refus;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return refus;
    }

    public int nombreDemande(int type) {
        int nombre = 0;
        String sql = "select count(demandeID)as nombre from demande where demandeEtat=" + type;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(sql);
            res = pst.executeQuery();
            while (res.next()) {
                nombre = res.getInt("nombre");
                return nombre;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return nombre;
    }
}
