package Controleurs;

import static Base_De_Donnees.Connection.getConnection;
import Interfaces.Ilogin;
import Modeles.Employe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginControleur implements Ilogin {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet res;
    private static final String LOGIN = "SELECT * FROM employe WHERE employePrenom=? AND employeMatricule=?";
    private static final String ADMIN = "SELECT * FROM employe WHERE employePrenom=? AND employeCategorie=6";
    private static final String CHARROI = "SELECT * FROM employe WHERE employePrenom=? AND employeCategorie=5";
    private static final String AGENT = "SELECT * FROM employe WHERE employePrenom=? AND employeCategorie=2";

    public LoginControleur() {
    }

    @Override
    public boolean isLogin(Employe employe) {
        connection = getConnection();
        try {
            pst = connection.prepareStatement(LOGIN);
            pst.setString(1, employe.getEmployePrenom());
            pst.setString(2, employe.getEmployeMatricule());
            res=pst.executeQuery();
            while(res.next()){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isCharroi(String employe) {
      connection = getConnection();
        try {
            pst = connection.prepareStatement(CHARROI);
            pst.setString(1, employe);
            res=pst.executeQuery();
            while(res.next()){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;   
    }

    @Override
    public boolean isAgent(String employe) {
    connection = getConnection();
        try {
            pst = connection.prepareStatement(AGENT);
            pst.setString(1, employe);
            res=pst.executeQuery();
            while(res.next()){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;  
    }

    @Override
    public boolean isAdmin(String employe) {
    connection = getConnection();
        try {
            pst = connection.prepareStatement(ADMIN);
            pst.setString(1, employe);
            res=pst.executeQuery();
            while(res.next()){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;    
    }

}
