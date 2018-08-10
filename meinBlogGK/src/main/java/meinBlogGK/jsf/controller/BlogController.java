package meinBlogGK.jsf.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import meinBlogGK.jsf.enums.View;

@Named
@SessionScoped
public class BlogController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(BlogController.class);
	
	@Inject
	private Conversation conversation;

	public void oeffneAdminSeite() {

		if (conversation.isTransient()) {

			long conversationTimeout = 3600000;
			conversation.setTimeout(conversationTimeout);
			conversation.begin();
		}

		try {
			
			final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			context.redirect(context.getRequestContextPath() + View.AdminPage +"?cid="+conversation.getId());
		} catch (IOException e) {
			LOG.error(e.getMessage(),e);
		}
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
}
