package dev.top.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.top.controller.Avis;
import dev.top.controller.CollegueFormulaire;
import dev.top.controller.CollegueRecup;
import dev.top.entities.Collegues;
import dev.top.exception.CheckCollegue;
import dev.top.exception.TopCollegueException;
import dev.top.repos.ColleguesRepo;

@Service
public class ColleguesService {

    @Autowired
    private ColleguesRepo colleguesRepo;

    public ColleguesService(ColleguesRepo colleguesRepo) {
        this.colleguesRepo = colleguesRepo;
    }

    public Optional<Collegues> findById(Long id) {
        return colleguesRepo.findById(id);
    }

    public Optional<Collegues> findByPseudo(String pseudo) {
        return colleguesRepo.findByPseudo(pseudo);
    }

    public List<Collegues> findAll() {
        return colleguesRepo.findAll();
    }

    public void save(Collegues col) {
        this.colleguesRepo.save(col);
    }

    @Transactional
    public Collegues voter(String pseudo, Avis avis) {

        if (pseudo == null || avis == null) {
            throw new TopCollegueException("au moins un des parametres n'est pas valorisé");
        }

        Collegues collegueTrouve = this.colleguesRepo.findByPseudo(pseudo)
                .orElseThrow(() -> new TopCollegueException("pseudo inexistant"));

        Integer score = collegueTrouve.getScore();

        if (avis.equals(Avis.AIMER)) {
            collegueTrouve.setScore(score + 100);
        } else if (avis.equals(Avis.DETESTER)) {
            collegueTrouve.setScore(score - 100);
        }
        return collegueTrouve;
    }

    @Transactional
    public Collegues creerNewCollegue(CollegueFormulaire cf) {

        if (cf.getMatricule() == null) {

            throw new CheckCollegue("matricule non saisie");

        } else {

            final String url = "https://tommy-sjava.cleverapps.io/collegues?matricule=" + cf.getMatricule();
            RestTemplate restTemplate = new RestTemplate();
            CollegueRecup[] resultat = restTemplate.getForObject(url, CollegueRecup[].class);

            if (resultat.length == 0) {

                throw new CheckCollegue("Collegue inexistant");

            } else {

                Collegues newCol = new Collegues();

                newCol.setScore(100);
                newCol.setPseudo(cf.getPseudo());

                if (cf.getPhotoUrl() == null) {

                    newCol.setImageUrl(resultat[0].getPhoto());

                } else {

                    newCol.setImageUrl(cf.getPhotoUrl());
                }

                colleguesRepo.save(newCol);

                return newCol;
            }
        }
    }
}
