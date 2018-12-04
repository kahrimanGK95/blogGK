package meinBlogGK.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import meinBlogGK.jsf.utils.DataConnect;

/**
 * Die Klasse LoginDAO enthält eine boolean-Methode validate, die dafür
 * zuständig ist, in der MySQL-Datenbank abzufragen, ob die eingegebenen Daten
 * richtig sind.
 * 
 * @author gokha
 *
 */
public class LoginDAO {

	private static final Logger LOG = LoggerFactory.getLogger(LoginDAO.class);

	public static boolean validate(String user, String password) {
		Connection connect = null;
		PreparedStatement ps = null;

		try {
			connect = DataConnect.getConnection();
			ps = connect.prepareStatement("Select username, password from users where username = ? and password = ?");

			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			DataConnect.close(connect);
		}
		return false;
	}
}
