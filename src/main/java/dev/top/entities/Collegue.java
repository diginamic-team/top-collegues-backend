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
    @JsonIgnore
    private Integer id;

    private Integer score;

    private String photo;

    private String pseudo;
    
    private String email;

    private String prenom;

    public Collegue(Integer id, Integer score, String photo, String pseudo) {
        
        this.id = id;
        this.score = score;
        this.photo = photo;
        this.pseudo = pseudo;    
       }
    
       public Collegue(Integer id, Integer score, String photo, String pseudo, String email, String prenom) {
		super();
		this.id = id;
		this.score = 500;
		this.photo = photo;
		this.pseudo = pseudo;
		this.email = email;
		this.prenom = prenom;
	}



	public Collegue() {
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Collegue [id=" + id + ", score=" + score + ", photo=" + photo + ", pseudo=" + pseudo + ", email="
				+ email + ", prenom=" + prenom + "]";
	}
    
    
}
	
	

