package dev.top.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService {

    @Autowired
    private CollegueRepo collegueRepo;

    public Collegue save(Collegue collegue){
        collegueRepo.save(collegue);
        return collegue;
    }
    
    public Optional<Collegue> findById(Long id) {
        return collegueRepo.findById(id);
    }

    public List<Collegue> findAll() {
        return collegueRepo.findAll();
    }
  
}