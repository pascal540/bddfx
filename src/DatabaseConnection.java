import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private Connection databaseLink;

    public Connection getConnection() {
        String db = "connection";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + db;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, user, password);
            System.out.println("Connecté  !!! ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de conenction");
        }

        return databaseLink;

    }

}