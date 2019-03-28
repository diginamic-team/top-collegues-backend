package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.service.CollegueService;


@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	private CollegueService collegueServ;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueServ.findAll();
	}

	@PatchMapping("/{pseudo}")
	public Collegue calculScore(@PathVariable String pseudo, @RequestBody Action action) {
	
		return this.collegueServ.voter(pseudo, action.getAction());
	}

}
