package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IModele;
import Modeles.Modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ModeleControleur extends Commun implements IModele {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO modele(modeleNom) VALUES(?)";
    private static final String UPDATE = "UPDATE modele SET modeleNom=? WHERE modeleID=?";
    private static final String DELETE = "DELETE FROM modele WHERE modeleID=?";
    private static final String SELECT_ALL = "SELECT * FROM modele";

    public ModeleControleur() {
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "SELECT * FROM modele WHERE modeleNom=?";
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
                Modele modele = new Modele();
                modele.setModeleNom(res.getString(parametre));
                id = modele.getModeleNom();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int create(Modele modele) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, modele.getModeleNom());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Modele modele) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, modele.getModeleNom());
            pst.setInt(2, modele.getModeleID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Modele modele) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, modele.getModeleID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Modele> afficherModeles() {
        List<Modele> modeles = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                Modele modele = new Modele();
                modele.setModeleID(res.getInt("modeleID"));
                modele.setModeleNom(res.getString("modeleNom"));
                modeles.add(modele);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modeles;
    }

    public void afficherListeModeles(JList<String> list) {
        DefaultListModel model = new DefaultListModel();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                String nom = res.getString("modeleNom");
                model.addElement(nom);
            }
            list.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
