package dev.top.entities;

public class NouveauCollegue {

	private String matricule;
	private String pseudo;
	private String imageUrl;
	
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "NouveauCollegue [matricule=" + matricule + ", pseudo=" + pseudo + ", urlImage=" + imageUrl + "]";
	}
	
		
}
