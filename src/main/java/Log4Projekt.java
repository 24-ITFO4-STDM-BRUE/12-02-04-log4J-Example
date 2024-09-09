import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Log4Projekt {
    // Logger für diese Klasse erstellen
    private static final Logger logger = Logger.getLogger(Log4Projekt.class.getName());

    public static void main(String[] args) {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:meineDB.db");
            logger.info("Opened database successfully");
            logger.warning("eine Warnung ausgeben");
            logger.severe("wichtige Fehler ausgeben");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getClass().getName() + ": " + e.getMessage(), e);
            System.exit(0);
        }
    }
}