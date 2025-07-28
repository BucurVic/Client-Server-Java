package Inot.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {
    private Properties props;
    private Connection instance = null;
    private static final Logger logger = LogManager.getLogger();

    public DbUtils(Properties props) {
        this.props = props;
    }

    private Connection getNewConnection() {
        logger.traceEntry();

        String driver = props.getProperty("inot.jdbc.driver");
        String url = props.getProperty("inot.jdbc.url");
        String user = props.getProperty("inot.jdbc.user");
        String password = props.getProperty("inot.jdbc.pass");

        logger.info("Connecting to {}", url);
        logger.info("User: {}", user);
        logger.info("Password: {}", password);
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Eroare stabilire conexiune" + e);
        } catch (ClassNotFoundException e) {
            logger.error("Eroare incarcare driver" + e);
            System.out.println("Eroare incarcare driver" + e);
        }
        logger.traceExit();
        return conn;
    }

    public Connection getConnection() {
        logger.traceEntry();
        try{
            if (instance == null || instance.isClosed()) {
                instance = getNewConnection();
            }
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Eroare stabilire conexiune" + e);
        }
        logger.traceExit();
        return instance;
    }
}
