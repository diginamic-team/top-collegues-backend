package dev.top.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // PATCH/collegues/PSEUDO
    @PatchMapping("/{pseudo}")
    public Collegues voter(@PathVariable String pseudo, @RequestBody VoteWeb vote) {

        return this.colleguesService.voter(pseudo, vote.getAction());
    }
  
}
