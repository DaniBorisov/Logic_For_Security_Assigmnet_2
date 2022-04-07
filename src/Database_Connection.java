import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database_Connection{

    private final String url = "jdbc:postgresql://127.0.0.1:5432/LFS";
    private final String user = "postgres";
    private final String password = "kolelo123";

    public Connection connect() {
        Connection conn = null;
        try {
//            Class.forName("org.postgresql.Driver")
//            ;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database_Connection app = new Database_Connection();
        app.connect();


    }
}