package dev.top.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.top.entities.Collegues;

@Repository
public interface ColleguesRepo extends JpaRepository<Collegues, Integer> {

    public Optional<Collegues> findById(Integer id);

    public Optional<Collegues> findByPseudo(String pseudo);

    public List<Collegues> findAll();

}