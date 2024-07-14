package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IVehicule;
import Modeles.Vehicule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VehiculeControleur extends Commun implements IVehicule {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO vehicule(vehiculePlaque,vehiculeModele,vehiculeAnneeFabrication,vehiculeTypeCarburant,vehiculeConsommationMoyenne,vehiculeService,vehiculeChauffeur) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE vehicule SET vehiculePlaque=?,vehiculeModele=?,vehiculeAnneeFabrication=?,vehiculeTypeCarburant =?,vehiculeConsommationMoyenne=?,vehiculeService=?,vehiculeChauffeur=?WHERE vehiculeID=?";
    private static final String DELETE = "DELETE FROM vehicule WHERE vehiculeID=?";
    private static final String SELECT_ALL = "SELECT vehiculeID,vehiculePlaque,modeleNom as modele,vehiculeAnneeFabrication,carburantNom as carburant,vehiculeConsommationMoyenne,serviceNom as service,employePrenom as nom FROM vehicule,service,employe,carburant,modele where vehiculeservice=serviceID and vehiculeTypeCarburant=carburantid and vehiculeChauffeur=employeID and vehiculeModele=modeleID";

    public VehiculeControleur() {
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "SELECT * FROM vehicule WHERE vehiculePlaque=?";
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
                Vehicule vehicule = new Vehicule();
                vehicule.setVehiculePlaque(res.getString(parametre));
                id = vehicule.getVehiculePlaque();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int create(Vehicule vehicule) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, vehicule.getVehiculePlaque());
            pst.setString(2, vehicule.getVehiculeModele());
            pst.setString(3, vehicule.getVehiculeAnneeFabrication());
            pst.setString(4, vehicule.getVehiculeTypeCarburant());
            pst.setDouble(5, vehicule.getVehiculeConsommationMoyenne());
            pst.setString(6, vehicule.getVehiculeService());
            pst.setString(7, vehicule.getVehiculeChauffeur());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Vehicule vehicule) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, vehicule.getVehiculePlaque());
            pst.setString(2, vehicule.getVehiculeModele());
            pst.setString(3, vehicule.getVehiculeAnneeFabrication());
            pst.setString(4, vehicule.getVehiculeTypeCarburant());
            pst.setDouble(5, vehicule.getVehiculeConsommationMoyenne());
            pst.setString(6, vehicule.getVehiculeService());
            pst.setString(7, vehicule.getVehiculeChauffeur());
            pst.setInt(8, vehicule.getVehivuleID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Vehicule vehicule) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, vehicule.getVehivuleID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Vehicule> afficherVehicules() {
        List<Vehicule> vehicules = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("vehiculeID");
                String plaque = res.getString("vehiculePlaque");
                String modele = res.getString("modele");
                String annee = res.getString("vehiculeAnneeFabrication");
                String carburant = res.getString("carburant");
                double consomMoy = res.getDouble("vehiculeConsommationMoyenne");
                String service = res.getString("service");
                String chauffeur = res.getString("nom");
                vehicules.add(new Vehicule(id, plaque, modele, annee, carburant, consomMoy, service, chauffeur));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return vehicules;
    }

    public void afficherVehicule(JComboBox combo, String service) {
        connection = getConnection();
        try {
            pst = connection.prepareStatement("select vehiculePlaque as plaque from vehicule where vehiculeService=(select serviceID from service where serviceNom='" + service + "')");
            res = pst.executeQuery();
            while (res.next()) {
                combo.addItem(res.getString("plaque"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
