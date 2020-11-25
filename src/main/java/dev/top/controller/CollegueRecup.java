package dev.top.controller;

public class CollegueRecup {

    // le nom des attributs daoit respecter le nommage de la base de donnée où sont
    // recup les infos
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String photo;

    public CollegueRecup(){}

    public CollegueRecup(String nom, String prenom, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }

    public CollegueRecup(String nom, String prenom, String email, String adresse, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.photo = photo;
    }
    
    
	/**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}