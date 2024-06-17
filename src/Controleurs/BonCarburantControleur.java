package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IBonCommande;
import Modeles.BonCarburant;
import Modeles.Employe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BonCarburantControleur extends Commun implements IBonCommande {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO bonCarburant(carburant,bonCarburantVehicule,autorise_par,bonCarburantIDemande,bonCarburantQuantite,bonStation) VALUES(?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE bonCarburant SET carburant=?,bonCarburantVehicule=?,autorise_par=?,bonCarburantIDemande=?,bonCarburantQuantite=?,bonStation=? WHERE bonCarburantID =?";
    private static final String DELETE = "DELETE FROM bonCarburant WHERE bonCarburantID =?";
    private static final String SELECT_ALL = "SELECT bonCarburantID,carburantNom as carburants,bonCarburantIDemande,BonCarburantDate,concat(employeNom,' ',employePrenom) as nom,vehiculePlaque as vehicule,bonCarburantQuantite,bonStation FROM boncarburant,vehicule,employe,carburant where bonCarburantVehicule=vehiculeID and autorise_par=employeID and carburant=carburantID";

    public BonCarburantControleur() {
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "select * from bonCarburant where bonCarburantID=?";
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
        return false;

    }

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
                Employe employe = new Employe();
                employe.setEmployeMatricule(res.getString(parametre));
                id = employe.getEmployeMatricule();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int create(BonCarburant bonCommande) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, bonCommande.getCarburant());
            pst.setString(2, bonCommande.getBonCarburantVehicule());
            pst.setString(3, bonCommande.getBonEmploye());
            pst.setInt(4, bonCommande.getBonDemandeID());
            pst.setDouble(5, bonCommande.getBonQuantite());
            pst.setString(6, bonCommande.getBonStation());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(BonCarburant bonCommande) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, bonCommande.getCarburant());
            pst.setString(2, bonCommande.getBonCarburantVehicule());
            pst.setString(3, bonCommande.getBonEmploye());
            pst.setInt(4, bonCommande.getBonDemandeID());
            pst.setDouble(5, bonCommande.getBonQuantite());
            pst.setString(6, bonCommande.getBonStation());
            pst.setInt(7, bonCommande.getBonCarburantID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;

    }

    @Override
    public int delete(BonCarburant bonCommande) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, bonCommande.getBonCarburantID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<BonCarburant> afficherBonCommandes() {
        List<BonCarburant> bonCommandes = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("bonCarburantID");
                String carburant = res.getString("carburants");
                String date = res.getString("BonCarburantDate");
                String vehicule = res.getString("vehicule");
                String employe = res.getString("nom");
                int demandeID = res.getInt("bonCarburantIDemande");
                double qte = res.getDouble("bonCarburantQuantite");
                String station = res.getString("bonStation");
                bonCommandes.add(new BonCarburant(id, carburant, date, vehicule, employe, demandeID, qte, station));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bonCommandes;
    }

    public String afficherCarburant(String vehicule) {
        String carburant = "";
        connection = getConnection();
        String sql = "select carburantNom from carburant,vehicule where vehiculeTypeCarburant=carburantid and vehiculePlaque='" + vehicule + "'";
        try {
            pst = connection.prepareStatement(sql);
            res = pst.executeQuery();
            while (res.next()) {
                carburant = res.getString("carburantNom");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return carburant;
    }

    public String afficherQuantite(String id) {
        String quantite = "";
        connection = getConnection();
        String sql = "select bonCarburantQuantite from bonCarburant where bonCarburantID=" + id;
        try {
            pst = connection.prepareStatement(sql);
            res = pst.executeQuery();
            while (res.next()) {
                quantite = res.getString("bonCarburantQuantite");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return quantite;
    }
}
