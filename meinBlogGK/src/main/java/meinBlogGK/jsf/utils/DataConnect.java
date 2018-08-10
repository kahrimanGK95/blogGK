package meinBlogGK.jsf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataConnect {

	private static final Logger LOG = LoggerFactory.getLogger(DataConnect.class);
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3308/meinbloggk", "root", "");
			return con;
		} catch(Exception e) {
			LOG.error(e.getMessage(),e);
			return null;
		}
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		}catch (SQLException e) {
			LOG.error(e.getMessage(),e);
		}
	}
}
