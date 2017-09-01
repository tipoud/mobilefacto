package fr.nico.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.nico.api.entity.Developer;

public interface DeveloperRepository extends JpaRepository<Developer,Long> {

	Developer findOne(Long id);

	List<Developer> findAll();

}
