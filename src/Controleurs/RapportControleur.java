package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IRapport;
import Modeles.Rapport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RapportControleur extends Commun implements IRapport {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO rapport(rapportQuantite,rapportCout,rapportPeriode,rapportQuantiteConsomme,rapportCoutConsomme,rapportCommantaire,rapportTransaction) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE rapport SET rapportQuantite=?,rapportCout=?,rapportPeriode=?,rapportQuantiteConsomme=?,rapportCoutConsomme=?,rapportCommantaire=?,rapportTransaction=? WHERE rapportID=?";
    private static final String DELETE = "DELETE FROM rapport WHERE rapportID=?";
    private static final String SELECT_ALL = "SELECT * from rapport";
    public RapportControleur() {
    }

    @Override
    public boolean dejaExist(String text) {
          connection = getConnection();
        String requete = "SELECT * FROM rapport WHERE rapportID=?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, text);
            res = pst.executeQuery();
            while (res.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;  }

    @Override
    public String returnId(String parametre, String table, String cle, String valeur) {
       connection = getConnection();
        String id = "";
        try {
            pst = connection.prepareStatement("select " + parametre + " from "
                    + table + " where " + cle + "=?");
            pst.setString(1, valeur);
            res = pst.executeQuery();
            while (res.next()) {
                Rapport employe = new Rapport();
                employe.setRapportCommantaire(res.getString(parametre));
                id = employe.getRapportCommantaire();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id; 
    }

    @Override
    public int create(Rapport rapport) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setDouble(1, rapport.getRapportQuantite());
            pst.setInt(2, rapport.getRapportCout());
            pst.setString(3, rapport.getRapportPeriode());
            pst.setDouble(4, rapport.getRapportQuantiteConsomme());
            pst.setInt(5, rapport.getRapportCoutConsomme());
            pst.setString(6, rapport.getRapportCommantaire());
            pst.setInt(7, rapport.getRapportTransaction());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Rapport rapport) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setDouble(1, rapport.getRapportQuantite());
            pst.setInt(2, rapport.getRapportCout());
            pst.setString(3, rapport.getRapportPeriode());
            pst.setDouble(4, rapport.getRapportQuantiteConsomme());
            pst.setInt(5, rapport.getRapportCoutConsomme());
            pst.setString(6, rapport.getRapportCommantaire());
            pst.setInt(7, rapport.getRapportTransaction());
            pst.setInt(8, rapport.getRapportID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Rapport rapport) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, rapport.getRapportID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Rapport> afficherRapport() {
        List<Rapport> rapports = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                Rapport rapport = new Rapport();
                rapport.setRapportID(res.getInt("rapportID"));
                rapport.setRapportQuantite(res.getDouble("rapportQuantite"));
                rapport.setRapportCout(res.getInt("rapportCout"));
                rapport.setRapportPeriode(res.getString("rapportPeriode"));
                rapport.setRapportQuantiteConsomme(res.getDouble("rapportQuantiteConsomme"));
                rapport.setRapportCoutConsomme(res.getInt("rapportCoutConsomme"));
                rapport.setRapportCommantaire(res.getString("rapportCommantaire"));
                rapport.setRapportTransaction(res.getInt("rapportTransaction "));
                rapport.setRapportDate(res.getString("rapportDate"));
                rapports.add(rapport);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rapports;
    }

}
