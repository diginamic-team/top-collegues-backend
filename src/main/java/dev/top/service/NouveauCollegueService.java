package dev.top.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Collegue;
import dev.top.entities.NouveauCollegue;
import dev.top.exception.TopCollegueException;

@Service
public class NouveauCollegueService<NouveauCollegueRepo> {

 
    public Collegue getNouveauCollegues(NouveauCollegue c) {
        final String uri = "https://tommy-sjava.cleverapps.io/collegues?matricule=" + c.getMatricule();
        RestTemplate restTemplate = new RestTemplate();
        NouveauCollegue[] result = restTemplate.getForObject(uri, NouveauCollegue[].class);
        Collegue nouveauCol = new Collegue();
        if (result.length==0) {
            throw new TopCollegueException("le matricule saisi n'existe pas");
        }else{
            if (c.getPhoto()==null || c.getPhoto().isEmpty()){
                nouveauCol.setPhoto(result[0].getPhoto());
            }else{
                nouveauCol.setPhoto(c.getPhoto());
            }
            nouveauCol.setPseudo(c.getNom());
            nouveauCol.setScore(100);
           
            nouveauCol.setEmail(result[0].getEmail());
            nouveauCol.setPrenom(result[0].getPrenom());
        }
        return nouveauCol;
    }
}
