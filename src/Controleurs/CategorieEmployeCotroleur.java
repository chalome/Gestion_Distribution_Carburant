package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.ICategorieEmploye;
import Modeles.CategorieEmploye;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class CategorieEmployeCotroleur extends Commun implements ICategorieEmploye {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO categorieemploye(CategorieEmployeNom) VALUES(?)";
    private static final String UPDATE = "UPDATE categorieemploye SET CategorieEmployeNom=? WHERE CategorieEmployeID=?";
    private static final String DELETE = "DELETE FROM categorieemploye WHERE CategorieEmployeID=?";
    private static final String SELECT_ALL = "SELECT * FROM categorieemploye";

    public CategorieEmployeCotroleur() {
    }

    @Override
    public int create(CategorieEmploye typeEmploye) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, typeEmploye.getCategorieEmploye());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(CategorieEmploye typeEmploye) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, typeEmploye.getCategorieEmploye());
            pst.setInt(2, typeEmploye.getCategorieEmployeID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(CategorieEmploye typeEmploye) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, typeEmploye.getCategorieEmployeID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<CategorieEmploye> afficherCategorieEmployes() {
        List<CategorieEmploye> categorieEmployes = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("CategorieEmployeID");
                String typeEmploye = res.getString("CategorieEmployeNom");
                categorieEmployes.add(new CategorieEmploye(id, typeEmploye));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return categorieEmployes;
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "select * from categorieemploye where CategorieEmployeNom=?";
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
                CategorieEmploye categorie = new CategorieEmploye();
                categorie.setCategorieEmploye(res.getString(parametre));
                id = categorie.getCategorieEmploye();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;

    }
        public void afficherListeCategories(JList<String> list) {
        DefaultListModel model = new DefaultListModel();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                String nom = res.getString("CategorieEmployeNom");
                model.addElement(nom);
            }
            list.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
