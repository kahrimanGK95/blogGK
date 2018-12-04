package meinBlogGK.jsf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Die Klasse DataConnect erzeugt per JDBC die Verbindung zu der MySQL-Datenbank
 * und leitet Abfragen und Ergebnisse zwischen der Anwendung und der Datenbank
 * weiter.
 * 
 * @author gokha
 *
 */
public class DataConnect {

	private static final Logger LOG = LoggerFactory.getLogger(DataConnect.class);

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://db:3306/meinbloggk?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
			return con;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
