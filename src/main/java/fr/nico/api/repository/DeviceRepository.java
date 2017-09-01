package fr.nico.api.repository;

import fr.nico.api.entity.Device;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
	
    Device findOne(Long id);
    
    List<Device> findAll();
  
}
