package dev.top.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.top.controller.EnumAction;
import dev.top.entities.Collegue;
import dev.top.exception.TopCollegueException;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService  {

	private CollegueRepo colRepo;
	
	public CollegueService(CollegueRepo collegueRepo) {
		this.colRepo = collegueRepo;
	}
	
	public List<Collegue> findAll(){
		return colRepo.findAll();
	}
	
	
	@Transactional //pour faire un rollback et ne rien sauver en base
	public Collegue voter(String pseudo, EnumAction action) {
		
		if(pseudo == null || action == null) {
			throw new TopCollegueException("au moins un des paramètres n'est pas valorisé");
		}
		
		Collegue collegueTrouve = this.colRepo.findByPseudo(pseudo).orElseThrow(()-> new TopCollegueException("Pseudo inexistant"));
		
		Integer score = collegueTrouve.getScore();
		
		if(action.equals(EnumAction.AIMER)) {
			collegueTrouve.setScore(score + 100);
		}else if(action.equals(EnumAction.DETESTER)) {
			collegueTrouve.setScore(score - 100);
		}
		
		return collegueTrouve;
	}
	
}
