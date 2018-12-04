package meinBlogGK.jsf.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import meinBlogGK.jsf.dao.LoginDAO;
import meinBlogGK.jsf.utils.SessionUtils;

/**
 * Die Klasse UserBean stellt die notwendigen Attribute und Methoden für das
 * Login/Logout zur Verfügung.
 * 
 * @author gokha
 *
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = -8852173624112892226L;

	private String password;
	private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Methode überprüft die Anmeldedaten und leitet zu der Blog-Seite weiter.
	 * 
	 * @return Seite, zu der weitergeleitet wird
	 */
	public String checkLogin() {
		boolean valid = LoginDAO.validate(username, password);
		String redirectPage = "";

		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			redirectPage = "blogPage?faces-redirect=true";
		}
		return redirectPage;
	}

	/**
	 * Ist für das Logout zuständig und leitet zur Startseite zurück.
	 * @return Startseite
	 */
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "loginPage.xhtml?faces-redirect=true";
	}
}
