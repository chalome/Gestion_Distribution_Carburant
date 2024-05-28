package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Commun;
import Interfaces.ITransaction;
import Modeles.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TransactionControleur extends Commun implements ITransaction {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String INSERT = "INSERT INTO transaction(transactionQuantite,transactionPrixUnitaire,transactionPrixTotal,transactionBonCommande,transactionStation) VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE transaction SET transactionQuantite=?,transactionPrixUnitaire=?,transactionPrixTotal=?,transactionBonCommande=?,transactionStation=?WHERE transactionID=?";
    private static final String DELETE = "DELETE FROM transaction WHERE transactionID=?";
    private static final String SELECT_ALL = "SELECT transactionID,transactionDate,transactionQuantite,transactionPrixUnitaire,transactionPrixTotal,transactionBonCommande,stationNom FROM transaction,station where transactionStation=stationid";

    public TransactionControleur() {
    }

    @Override
    public boolean dejaExist(String text) {
        connection = getConnection();
        String requete = "SELECT * FROM transaction WHERE transactionID=?";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Transaction transaction) {
        int ajout = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(INSERT);
            pst.setDouble(1, transaction.getTransactionQuantite());
            pst.setInt(2, transaction.getTransactionPrixUnitaire());
            pst.setInt(3, transaction.getTransactionPrixTotal());
            pst.setString(4, transaction.getTransactionBonCommande());
            pst.setString(5, transaction.getTransactionStation());
            ajout = pst.executeUpdate();
            return ajout;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ajout;
    }

    @Override
    public int update(Transaction transaction) {
        int modifier = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(UPDATE);
            pst.setDouble(1, transaction.getTransactionQuantite());
            pst.setInt(2, transaction.getTransactionPrixUnitaire());
            pst.setInt(3, transaction.getTransactionPrixTotal());
            pst.setString(4, transaction.getTransactionBonCommande());
            pst.setString(5, transaction.getTransactionStation());
            pst.setInt(6, transaction.getTransactionID());
            modifier = pst.executeUpdate();
            return modifier;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return modifier;
    }

    @Override
    public int delete(Transaction transaction) {
        int suppression = 0;
        connection = getConnection();
        try {
            pst = connection.prepareStatement(DELETE);
            pst.setInt(1, transaction.getTransactionID());
            suppression = pst.executeUpdate();
            return suppression;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return suppression;
    }

    @Override
    public List<Transaction> afficherTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        connection = getConnection();
        try {
            pst = connection.prepareStatement(SELECT_ALL);
            res = pst.executeQuery();
            while (res.next()) {
                int id = res.getInt("transactionID");
                double qte = res.getDouble("transactionQuantite");
                int pu = res.getInt("transactionPrixUnitaire");
                int pt = res.getInt("transactionPrixTotal");
                String date = res.getString("transactionDate");
                String bon = res.getString("transactionBonCommande");
                String station = res.getString("stationNom");
                transactions.add(new Transaction(id, qte, pu, pt, date, bon, station));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return transactions;
    }

}
