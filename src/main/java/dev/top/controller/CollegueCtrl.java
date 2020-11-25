package dev.top.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegues;
import dev.top.service.ColleguesService;

@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueCtrl {

    @Autowired
    private ColleguesService colleguesService;

    @GetMapping
    public List<Collegues> findAll() {
        return this.colleguesService.findAll();
    }

    // GET /collegues?pseudo=XXX, request dans dataservice coté front
    @GetMapping(params = "pseudo")
    public Optional<Collegues> findByPseudo(@RequestParam("pseudo") String pseudo) {

        return this.colleguesService.findByPseudo(pseudo);
    }

    // PATCH/collegues/PSEUDO
    @PatchMapping("/{pseudo}")
    public Collegues voter(@PathVariable String pseudo, @RequestBody VoteWeb vote) {

        return this.colleguesService.voter(pseudo, vote.getAction());
    }

    @PostMapping
    public Collegues creerNewCollegue(@RequestBody CollegueFormulaire colForm) {

        return this.colleguesService.creerNewCollegue(colForm);
    }

}
