import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection c = null;

        try {
            c = DriverManager.getConnection("jdbc:sqlite:H:\\STDM\\Code\\12-02-04-log4J-Example\\src\\test.db");

        } catch (Exception e) {
            logger.error("Datenbank konnte nicht geöffnet werden");

        }

        Statement stmt = c.createStatement();
        String query = "SELECT Wert FROM meineDaten";
        ResultSet result = stmt.executeQuery(query);

        if (result == null) {
        } else
        while (result.next()) {
            System.out.println(result.getString("Wert"));
        }
        result.close();

    }
}
