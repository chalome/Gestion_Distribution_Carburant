package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.ICarburant;
import Modeles.TypeCarburant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class CarburantControleur extends Commun implements ICarburant {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO carburant(carburantNom) VALUES(?)";
    private static final String UPDATE = "UPDATE carburant SET carburantNom=? carburantID=?";
    private static final String DELETE = "DELETE FROM carburant WHERE carburantID=?";
    private static final String SELECT_ALL = "SELECT * FROM carburant";

    public CarburantControleur() {
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "SELECT * FROM carburant WHERE carburantNom=?";
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
                TypeCarburant carburant = new TypeCarburant();
                carburant.setCarburantNom(res.getString(parametre));
                id = carburant.getCarburantNom();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int create(TypeCarburant carburant) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, carburant.getCarburantNom());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(TypeCarburant carburant) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, carburant.getCarburantNom());
            pst.setInt(2, carburant.getCarburantID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(TypeCarburant carburant) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, carburant.getCarburantID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<TypeCarburant> afficherTypeCaburants() {
        List<TypeCarburant> typeCarburants = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("carburantID");
                String nif = res.getString("carburantNom");
                typeCarburants.add(new TypeCarburant(id, nif));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return typeCarburants;
    }
public void afficherListeCarburants(JList<String> list) {
        DefaultListModel model = new DefaultListModel();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                String nom = res.getString("carburantNom");
                model.addElement(nom);
            }
            list.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
