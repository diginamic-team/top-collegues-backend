package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.entities.NouveauCollegue;
import dev.top.exception.CollegueException;
import dev.top.service.CollegueService;
import dev.top.service.NouveauCollegueService;

@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class ColleguesController {

	@Autowired
	private CollegueService collegueService;

	@Autowired
	private NouveauCollegueService nouveauCollegueService;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueService.findAll();
	}
	
	@PostMapping
	public void OutputFiltersertCollegue(@RequestBody NouveauCollegue collegue) {
		this.collegueService.save(this.nouveauCollegueService.getNouveauCollegues(collegue));
	}

	// PATCH /collegues/PSEUDO
	@PatchMapping("/{pseudo}")
	public Collegue voter(@PathVariable String pseudo, @RequestBody VoteWeb vote) {

		return this.collegueService.voter(pseudo, vote.getAction());
	}
	
	@GetMapping(
	        params = "pseudo"
	)

	@PostMapping
	public void AjoutCollegue(@RequestBody CollegueDTO c) {
		System.out.println(c.getNom());

		boolean exist = true;
		Collegue col = new Collegue();

		try {
			col = collegueService.findByPseudo(c.getNom());
		} catch (CollegueException e) {
			exist = false;
		}

		if (!exist) {

			collegueService.save(Utils.recupDonne(c));

		} else {
			throw new CollegueException("Une personne avec ce pseudo existe dejà");
		}
	}

}
