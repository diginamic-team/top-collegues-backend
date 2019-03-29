package dev.top.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.top.controller.Avis;
import dev.top.entities.Collegue;
import dev.top.exception.CollegueException;
import dev.top.exception.TopCollegueException;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService {

    private CollegueRepo colRepo;
    
    public CollegueService(CollegueRepo collegueRepo) {
		this.colRepo = collegueRepo;
	}
    
    public Collegue save(Collegue collegue){
    	colRepo.save(collegue);
        return collegue;
}

	public List<Collegue> findAll() {
        return colRepo.findAll();
    }
	
    public Collegue findByPseudo(String pseudo) {
        return colRepo.findByPseudo(pseudo).orElseThrow(() -> new CollegueException("Personne avec ce pseudo dans la BDD"));

    }

	@Transactional
	public Collegue voter(String pseudo, Avis avis) {

		if(pseudo == null || avis == null) {
			throw new TopCollegueException("au moins un des paramètres n'est pas valorisé");
		}
		
		Collegue collegueTrouve = this.colRepo.findByPseudo(pseudo).orElseThrow(() -> new TopCollegueException("pseudo inexistant"));
		
		Integer score = collegueTrouve.getScore();
		
		if(avis.equals(Avis.AIMER)) {
			collegueTrouve.setScore(score + 100);
		} else if(avis.equals(Avis.DETESTER)) {
			collegueTrouve.setScore(score - 100);
		}
		
		return collegueTrouve;
		
	}

  
}