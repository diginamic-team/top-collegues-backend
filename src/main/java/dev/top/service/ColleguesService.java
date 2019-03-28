package dev.top.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.controller.Avis;
import dev.top.entities.Collegues;
import dev.top.exception.TopCollegueException;
import dev.top.repos.ColleguesRepo;

@Service
public class ColleguesService {

    @Autowired
    private ColleguesRepo colleguesRepo;

    public ColleguesService(ColleguesRepo colleguesRepo) {
        this.colleguesRepo = colleguesRepo;
    }

    public Optional<Collegues> findById(Integer id) {
        return colleguesRepo.findById(id);
    }

    public Optional<Collegues> findByPseudo(String pseudo) {
        return colleguesRepo.findByPseudo(pseudo);
    }

    public List<Collegues> findAll() {
        return colleguesRepo.findAll();
    }

    @Transactional
	public Collegues voter(String pseudo, Avis avis) {

        if (pseudo == null || avis == null) {
            throw new TopCollegueException("au moins un des parametres n'est pas valorisé");
        }
        
        Collegues collegueTrouve = this.colleguesRepo.findByPseudo(pseudo).orElseThrow(() -> new TopCollegueException("pseudo inexistant"));
        
        Integer score = collegueTrouve.getScore();

        if (avis.equals(Avis.AIMER)) {
            collegueTrouve.setScore(score + 100);
        }else if (avis.equals(Avis.DETESTER)) {
            collegueTrouve.setScore(score - 100);
        }  
        return collegueTrouve;      
    }

}