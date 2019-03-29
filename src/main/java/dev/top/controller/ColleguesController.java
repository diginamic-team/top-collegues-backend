package dev.top.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.service.CollegueService;


@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class ColleguesController {

	@Autowired
    private CollegueService collegueService;
	
	@GetMapping
    public List<Collegue> findAll() {
        return this.collegueService.findAll();
    }
	// PATCH /collegues/PSEUDO
	@PatchMapping("/{pseudo}")
	public Collegue voter(@PathVariable String pseudo, @RequestBody VoteWeb vote) {
		
		return this.collegueService.voter(pseudo, vote.getAction());
		
	}
	
	@PostMapping
    public CollegueDTO AjoutCollegue(@RequestBody CollegueDTO c) {
		return c;
    	
}
	
}