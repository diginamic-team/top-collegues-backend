package dev.top.service;

public class CollegueExterne {

	private String matricule;
	private String nom;
	private String photo;
	
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "CollegueExterne [matricule=" + matricule + ", nom=" + nom + ", photo=" + photo + "]";
	}
	
		
}
