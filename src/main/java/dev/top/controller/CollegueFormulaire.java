package dev.top.controller;

public class CollegueFormulaire {

    private String matricule;
    private String pseudo;
    private String photoUrl;

    public CollegueFormulaire() {
    }

    public CollegueFormulaire(String matricule, String pseudo, String photoUrl) {
        this.matricule = matricule;
        this.pseudo = pseudo;
        this.photoUrl = photoUrl;
    }

    public CollegueFormulaire(String pseudo, String photoUrl) {
        this.pseudo = pseudo;
        this.photoUrl = photoUrl;
    }

    /**
     * @return the matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * @param matricule the matricule to set
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the photoUrl
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * @param photoUrl the photoUrl to set
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}