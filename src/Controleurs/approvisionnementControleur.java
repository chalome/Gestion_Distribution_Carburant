/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.IApprovisionnement;
import Modeles.Approvisionnement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Didier
 */
public class approvisionnementControleur extends Commun implements IApprovisionnement {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO approvisionnement(approvisionnementQuantite,approvisionnementPU,approvisionnementPT,approvisionnementFournisseur,approvisionnementCarburant) VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE approvisionnement SET approvisionnementQuantite=?,approvisionnementPU=?,approvisionnementPT=?,approvisionnementFournisseur=?,approvisionnementCarburant=? WHERE approvisionnementID=?";
    private static final String DELETE = "DELETE FROM approvisionnement WHERE approvisionnementID =?";
    private static final String SELECT_ALL = "SELECT approvisionnementID as id,approvisionnementQuantite as qte,approvisionnementPU as pu,approvisionnementPT as pt,stationNom as station,carburantNom  as carburant FROM station,approvisionnement,carburant where  approvisionnementFournisseur=stationID and approvisionnementCarburant=carburantID";

    public approvisionnementControleur() {
    }

    @Override
    public boolean dejaExist(String carburant) {
        connection = getConnection();
        String requete = "select * from approvisionnement where approvisionnementQuantite>0 and approvisionnementCarburant=( select carburant.carburantID from carburant WHERE carburant.carburantNom='" + carburant + "')";
        try {
            pst = connection.prepareStatement(requete);
            res = pst.executeQuery();
            while (res.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;

    }

    public boolean finished() {
        connection = getConnection();
        String requete = "select * from approvisionnement where approvisionnementQuantite <=0";
        try {
            pst = connection.prepareStatement(requete);
            res = pst.executeQuery();
            while (res.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;

    }

    @Override
    public String returnId(String parametre, String table, String cle, String valeur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ajouter(Approvisionnement approvisionnement) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setDouble(1, approvisionnement.getApprovisionQuantite());
            pst.setInt(2, approvisionnement.getApprovisionPU());
            pst.setInt(3, approvisionnement.getApprovisionPT());
            pst.setString(4, approvisionnement.getApprovisionFournisseur());
            pst.setString(5, approvisionnement.getApprovisionCarburant());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int modifier(Approvisionnement approvisionnement) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setDouble(1, approvisionnement.getApprovisionQuantite());
            pst.setInt(2, approvisionnement.getApprovisionPU());
            pst.setInt(3, approvisionnement.getApprovisionPT());
            pst.setString(4, approvisionnement.getApprovisionFournisseur());
            pst.setString(5, approvisionnement.getApprovisionCarburant());
            pst.setInt(6, approvisionnement.getApprovisionID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;

    }

    public int modifier(double quantite) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement("UPDATE approvisionnement SET approvisionnementQuantite=approvisionnementQuantite-" + quantite + " where approvisionnementQuantite>0");
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;

    }

    @Override
    public int supprimer(Approvisionnement approvisionnement) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, approvisionnement.getApprovisionID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Approvisionnement> listApprovisions() {
        List<Approvisionnement> approvisionnements = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String carburant = res.getString("carburant");
                int pu = res.getInt("pu");
                int pt = res.getInt("pt");
                double qte = res.getDouble("qte");
                String fournisseur = res.getString("station");
                approvisionnements.add(new Approvisionnement(id, qte, pu, pt, fournisseur, carburant));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return approvisionnements;
    }

    public String afficherQuantite() {
        String quantite = "";
        connection = getConnection();
        String sql = "select approvisionnementQuantite as qte from approvisionnement where approvisionnementQuantite>0";
        try {
            pst = connection.prepareStatement(sql);
            res = pst.executeQuery();
            while (res.next()) {
                quantite = res.getString("qte");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return quantite;
    }
}
