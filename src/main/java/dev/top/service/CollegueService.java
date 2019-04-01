package dev.top.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import dev.top.controller.EnumAction;
import dev.top.entities.Collegue;
import dev.top.entities.NouveauCollegue;
import dev.top.exception.TopCollegueException;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService {

	private CollegueRepo colRepo;

	public CollegueService(CollegueRepo collegueRepo) {
		this.colRepo = collegueRepo;
	}

	public List<Collegue> findAll() {
		return colRepo.findAll();
	}

	@Transactional // pour faire un rollback et ne rien sauver en base si problème
	public Collegue voter(String pseudo, EnumAction action) {

		if (pseudo == null || action == null) {
			throw new TopCollegueException("au moins un des paramètres n'est pas valorisé");
		}

		Collegue collegueTrouve = this.colRepo.findByPseudo(pseudo)
				.orElseThrow(() -> new TopCollegueException("Pseudo inexistant"));

		Integer score = collegueTrouve.getScore();

		if (action.equals(EnumAction.AIMER)) {
			collegueTrouve.setScore(score + 100);
		} else if (action.equals(EnumAction.DETESTER)) {
			collegueTrouve.setScore(score - 100);
		}

		return collegueTrouve;
	}

	public Collegue getCollegueExterneJson(NouveauCollegue nouveauCollegue) {
		System.out.println(nouveauCollegue);

		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "https://tommy-sjava.cleverapps.io/collegues";
		CollegueExterne[] response = restTemplate
				.getForObject(resourceUrl + "?matricule=" + nouveauCollegue.getMatricule(), CollegueExterne[].class);

		Collegue colaAjouter = new Collegue();

		if (response.length == 0) {
			throw new TopCollegueException("Ce matricule n'existe pas");
		} else {

			if (this.colRepo.findByPseudo(nouveauCollegue.getPseudo()).isPresent()) {

				CollegueExterne collegueExterne = response[0];

				colaAjouter.setPseudo(nouveauCollegue.getPseudo());

				colaAjouter.setNom(collegueExterne.getNom());

				colaAjouter.setPrenom(collegueExterne.getPrenom());

				colaAjouter.setDateNaissance(collegueExterne.getDateNaissance());

				colaAjouter.setEmail(collegueExterne.getEmail());

				colaAjouter.setMatricule(collegueExterne.getMatricule());

				colaAjouter.setSexe(collegueExterne.getSexe());

				colaAjouter.setDepartement(collegueExterne.getDepartement());

				colaAjouter.setSubalternes(collegueExterne.getSubalternes());

				colaAjouter.setPassword(collegueExterne.getPassword());

				colaAjouter.setAdresse(collegueExterne.getAdresse());

				if (StringUtils.isEmpty(nouveauCollegue.getImageUrl())) {
					colaAjouter.setImageUrl(collegueExterne.getPhoto());
				} else {
					colaAjouter.setImageUrl(nouveauCollegue.getImageUrl());
				}

				colaAjouter.setScore(0);

				this.colRepo.save(colaAjouter);

			} else {
				throw new TopCollegueException("Pseudo déjà existant");
			}
		}
		;

		return colaAjouter;

	}

	public Collegue findCollegue(String pseudo) {
		return this.colRepo.findByPseudo(pseudo).orElseThrow(() -> new TopCollegueException("Pseudo inexistant"));
	}

}
