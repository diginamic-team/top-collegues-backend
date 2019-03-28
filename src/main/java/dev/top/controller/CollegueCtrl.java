package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.EnumAction;
import dev.top.entities.Action;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	private CollegueRepo collegueRepo;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
	}

	@PatchMapping
	@RequestMapping("/{pseudo}")
	public Collegue calculScore(@PathVariable("pseudo") String pseudo, @RequestBody Action action) {

		Collegue col = this.collegueRepo.findByPseudo(pseudo);

		if (col != null) {

			if (action.getAction().equals(EnumAction.AIMER)) {

				Integer score = col.getScore();
				score += 10;
				col.setScore(score);

			} else if (action.getAction().equals(EnumAction.DETESTER)) {

				Integer score = col.getScore();
				score -= 5;
				col.setScore(score);
			}

		} else {
			System.out.println("ce pseudo n'existe pas");
		}
		return col;
	}

}
