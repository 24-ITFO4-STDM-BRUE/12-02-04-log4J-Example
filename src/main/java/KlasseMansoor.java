import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class KlasseMansoor {

        public static void main(String[] args) {
            Connection c = null;
            System.out.println("vor dem try");
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:H:\\STDM\\DbZugreifen\\meineDB.db");
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
                System.out.println("Opened database successfully");
            }
            System.out.println("Opened database successfully");

        }

    }
