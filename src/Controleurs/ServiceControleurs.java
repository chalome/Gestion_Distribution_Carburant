package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IService;
import Modeles.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ServiceControleurs extends Commun implements IService {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO service(serviceNom) VALUES(?)";
    private static final String UPDATE = "UPDATE service SET serviceNom=? WHERE serviceID=?";
    private static final String DELETE = "DELETE FROM service WHERE serviceID=?";
    private static final String SELECT_ALL = "SELECT * FROM service";

    public ServiceControleurs() {
    }

    @Override
    public int create(Service service) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setString(1, service.getServiceNom());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Service service) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setString(1, service.getServiceNom());
            pst.setInt(2, service.getServiceID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Service service) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, service.getServiceID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Service> afficherServices() {
        List<Service> approbations = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                Service service = new Service();
                service.setServiceID(res.getInt("serviceID"));
                service.setServiceNom(res.getString("serviceNom"));
                approbations.add(service);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return approbations;
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "select * from service where serviceNom=?";
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
                Service service = new Service();
                service.setServiceNom(res.getString(parametre));
                id = service.getServiceNom();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public void afficherListeServices(JList<String> list) {
        DefaultListModel model = new DefaultListModel();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                String nom = res.getString("serviceNom");
                model.addElement(nom);
            }
            list.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
