package dev.top.controller;

import java.util.List;
import dev.top.entities.Collegue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.top.repos.CollegueRepo;


@RestController()
@RequestMapping("/collegues")
public class ColleguesController {

	@Autowired
    private CollegueRepo colleguesRepo;
	
	@GetMapping
    public List<Collegue> findAll() {
        return this.colleguesRepo.findAll();
    }
}
