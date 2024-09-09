import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sqlite.SQLiteJDBCLoader;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Connection c = null;


        try {
            log.log(Level.INFO,"checking filepath");
            String FullFilePath = DoesFileExist("meineDB.db");
            log.log(Level.INFO, "check finished");
            Class.forName("org.sqlite.JDBC");
            log.log(Level.DEBUG, "Establishing connection");
            c = DriverManager.getConnection("jdbc:sqlite:" + FullFilePath);
            log.log(Level.INFO, "check finished");

            try (Statement stmt = c.createStatement()){
                String query = "SELECT name FROM meineDaten schema WHERE type= 'table' AND name NOT LIKE 'sqlite %'";
                log.log(Level.INFO, "Query: " + query);
                ResultSet rs = stmt.executeQuery(query);
                log.log(Level.INFO, "querry successfull");
            } catch (Exception e) {
                log.log(Level.FATAL, e.getClass().getName() + ": " + e.getMessage() );
                log.log(Level.FATAL,"Bad Query");
            }
        } catch ( Exception e ) {
            log.log(Level.FATAL, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        log.log(Level.INFO, "opened successfully");
    }

    public static String DoesFileExist(String Path) throws Exception, URISyntaxException {
        java.net.URL Resource = SQLiteJDBCLoader.class.getClassLoader().getResource(Path);
        if (Resource == null)
            throw new Exception("oops");
        URI FilePath = Resource.toURI();

        log.log(Level.INFO, FilePath);
        File f = new File(FilePath);
        if (!f.exists())
            throw new Exception("ooops");

        return String.valueOf(FilePath);
    }
}