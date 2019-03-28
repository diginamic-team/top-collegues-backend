package dev.top.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.entities.Collegues;
import dev.top.repos.ColleguesRepo;

@Service
public class ColleguesService {

    @Autowired
    public ColleguesRepo colleguesRepo;

    public Optional<Collegues> findById(Integer id) {
        return colleguesRepo.findById(id);
    }

    public Optional<Collegues> findByPseudo(String pseudo) {
        return colleguesRepo.findByPseudo(pseudo);
    }

    public List<Collegues> findAll() {
        return colleguesRepo.findAll();
    }

}