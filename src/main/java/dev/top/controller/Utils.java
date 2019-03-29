package dev.top.controller;

import org.springframework.web.client.RestTemplate;

import dev.top.entities.Collegue;
import dev.top.exception.TopCollegueException;

public class Utils {

public static Collegue recupDonne( CollegueDTO c) {
		
		final String uri = "https://tommy-sjava.cleverapps.io/collegues?matricule="+c.getMatricule();
 	    System.err.println(uri);
 	    RestTemplate restTemplate = new RestTemplate();
 	    CollegueDTO [] result = restTemplate.getForObject(uri, CollegueDTO[].class);
		 
 	   Collegue collegueToAdd =   new Collegue();
 	    if(result.length==0) {
 	    throw new TopCollegueException("Personne ne possede ce matricule");
 	    }else {
 	    	
 	    	collegueToAdd.setPseudo(c.getNom());
	    	collegueToAdd.setScore(800);
	    	if(c.getPhoto() == null) {
	    		collegueToAdd.setPhoto(result[0].getPhoto());
	    	}else {
 	    		collegueToAdd.setPhoto(c.getPhoto());
 	    	}
		
 	    }
 	    return collegueToAdd;

	}
}
