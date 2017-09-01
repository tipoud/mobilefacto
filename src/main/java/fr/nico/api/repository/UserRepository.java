package fr.nico.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.nico.api.entity.Device;
import fr.nico.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOne(Long id);

    User findByUsername(String username);
    
    List<User> findAll();
    
}
