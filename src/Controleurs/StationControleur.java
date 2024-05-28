package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IStation;
import Modeles.Station;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StationControleur extends Commun implements IStation {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO station(stationNIF,stationRC,stationNom,stationAdresse) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE station SET stationNIF=?,stationRC=?,stationNom=?,stationAdresse=?WHERE stationID=?";
    private static final String DELETE = "DELETE FROM station WHERE stationID=?";
    private static final String SELECT_ALL = "SELECT * FROM station";

    public StationControleur() {
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "SELECT * FROM station WHERE stationNom=?";
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
                Station station = new Station();
                station.setStationNom(res.getString(parametre));
                id = station.getStationNom();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int create(Station station) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, station.getStationNIF());
            pst.setString(2, station.getStationRC());
            pst.setString(3, station.getStationNom());
            pst.setString(4, station.getStationAdresse());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Station station) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, station.getStationNIF());
            pst.setString(2, station.getStationRC());
            pst.setString(3, station.getStationNom());
            pst.setString(4, station.getStationAdresse());
            pst.setInt(5, station.getStationID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Station station) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, station.getStationID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Station> afficherStations() {
        List<Station> stations = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("stationID");
                String nif = res.getString("stationNIF");
                String rc = res.getString("stationRC");
                String nom = res.getString("stationNom");
                String adresse = res.getString("stationAdresse");
                stations.add(new Station(id, nif, rc, nom, adresse));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return stations;
    }

}
