package dev.top.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import dev.top.entities.Collegue;

@Repository
public interface CollegueRepo extends JpaRepository<Collegue, Long> {

	// create
	public Collegue save(Collegue collegue);

	// read

	public Optional<Collegue> findById(Long id);
	
	public List<Collegue> findAll();

}
