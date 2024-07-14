package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IEmploye;
import Modeles.Employe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EmployeControleur extends Commun implements IEmploye {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO employe(employeMatricule,employeNom,employePrenom,employeAdresse,employeService,employeCategorie,	employeTelephone) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE employe SET employeMatricule=?,employeNom=?,employePrenom=?,employeAdresse=?,employeService=?,employeCategorie=?,employeTelephone=? WHERE employeID=?";
    private static final String DELETE = "DELETE FROM employe WHERE employeID=?";
    private static final String SELECT_ALL = "SELECT employeID,employeNom,employePrenom,employeMatricule,service.serviceNom as service,categorieemploye.CategorieEmployeNom as categorie,employeadresse,employeTelephone FROM employe,service,categorieemploye where employeService=serviceID and employeCategorie=categorieEmployeID";

    public EmployeControleur() {
    }

    @Override
    public int create(Employe employe) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, employe.getEmployeMatricule());
            pst.setString(2, employe.getEmployeNom());
            pst.setString(3, employe.getEmployePrenom());
            pst.setString(4, employe.getEmployeAdresse());
            pst.setString(5, employe.getEmployeSerice());
            pst.setString(6, employe.getEmployeCategorie());
            pst.setString(7, employe.getEmployeTelephone());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Employe employe) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, employe.getEmployeMatricule());
            pst.setString(2, employe.getEmployeNom());
            pst.setString(3, employe.getEmployePrenom());
            pst.setString(4, employe.getEmployeAdresse());
            pst.setString(5, employe.getEmployeSerice());
            pst.setString(6, employe.getEmployeCategorie());
            pst.setString(7, employe.getEmployeTelephone());
            pst.setInt(8, employe.getEmployeID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Employe employe) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, employe.getEmployeID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Employe> afficherEmployes() {
        List<Employe> employes = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("employeID");
                String matricule = res.getString("employeMatricule");
                String nom = res.getString("employenom");
                String prenom = res.getString("employeprenom");
                String adresse = res.getString("employeadresse");
                String service = res.getString("service");
                String categorie = res.getString("categorie");
                String telephone = res.getString("employetelephone");
                employes.add(new Employe(id, matricule, nom, prenom, adresse, service, categorie, telephone));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return employes;
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "select * from employe where employeMatricule=?";
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

    public void afficherCharroi(JComboBox combo) {
        connection = getConnection();
        try {
            pst = connection.prepareStatement("select concat(employeNom,' ',employePrenom) as nom from employe where employeCategorie=5");
            res = pst.executeQuery();
            while (res.next()) {
                combo.addItem(res.getString("nom"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
