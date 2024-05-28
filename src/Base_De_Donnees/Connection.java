package Base_De_Donnees;

import java.sql.DriverManager;

public class Connection {
 private static java.sql.Connection connection = null;
    private static final String url = "jdbc:mysql://localhost/gestion_distribution_carburant";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String uname = "root";
    private static final String password = "";

    public static java.sql.Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, uname, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
