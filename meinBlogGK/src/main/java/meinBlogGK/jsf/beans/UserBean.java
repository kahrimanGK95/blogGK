package meinBlogGK.jsf.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import meinBlogGK.jsf.dao.LoginDAO;
import meinBlogGK.jsf.utils.SessionUtils;

@Named
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = -8852173624112892226L;
	
	private String password;
	private String username;
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String checkLogin() {
		boolean valid = LoginDAO.validate(username, password);
		String redirectPage = "";
		
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			redirectPage = "admin?faces-redirect=true";
		}
		return redirectPage;
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "loginPage.xhtml?faces-redirect=true";
	}
}
