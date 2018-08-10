package meinBlogGK.jsf.enums;

public enum View {
	
	AdminPage("admin.xhtml");
	
	private final String adresse;
	
	private View(String adress) {
		this.adresse = adress;
	}

	public String getAdresse() {
		return adresse;
	}
	
	
	public boolean equalsAdresse(String otheradress) {
		return adresse.equals(otheradress);
	}
	
	public String toString() {
		return this.adresse;
	}
}
