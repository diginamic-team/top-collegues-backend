package dev.top.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Collegue {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String pseudo;
	private Integer score;
	private String imageUrl;
	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	private String dateNaissance;
	private String sexe;
	private String adresse;
	private String password;
	private String photo;
	private String[] subalternes;
	private String departement;
	
	
	
	public Collegue() {
		super();
	}


	public Collegue(String pseudo, Integer score, String imageUrl) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.imageUrl = imageUrl;
	}

	
	
	public Collegue(String pseudo, Integer score, String imageUrl, String matricule, String nom,
			String prenom, String email, String dateNaissance, String sexe,String adresse, String password,
			String[] subalternes, String departement) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.imageUrl = imageUrl;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.password = password;
		this.subalternes = subalternes;
		this.departement = departement;
	}


	@JsonIgnore
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
		
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	
	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String[] getSubalternes() {
		return subalternes;
	}


	public void setSubalternes(String[] subalternes) {
		this.subalternes = subalternes;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	@Override
	public String toString() {
		return "Collegue [id=" + id+ ",pseudo=" + pseudo + ", score=" + score + ", imageUrl=" + imageUrl + "]";
	}
	
	
}
