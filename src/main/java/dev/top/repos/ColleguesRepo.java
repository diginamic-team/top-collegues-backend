package dev.top.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.top.entities.Collegues;

@Repository
public interface ColleguesRepo extends JpaRepository<Collegues, Long> {

    Optional<Collegues> findById(Long id);

    Optional<Collegues> findByPseudo(String pseudo);

    List<Collegues> findAll();

}