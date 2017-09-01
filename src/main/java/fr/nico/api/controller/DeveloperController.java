package fr.nico.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.nico.api.entity.Developer;
import fr.nico.api.repository.DeveloperRepository;

@RestController
@RequestMapping(value="/developer/**")
public class DeveloperController {
    
    @Autowired
    private DeveloperRepository _developerRepository;
    
    @RequestMapping(value = "/developer/{id}", method=RequestMethod.GET)
    public Developer getDeveloperById(@PathVariable Long id) {
        return this._developerRepository.findOne(id);
    }
    
    @RequestMapping(value = "/developer/", method=RequestMethod.GET)
    public List<Developer> getAllDevelopers() {
        return this._developerRepository.findAll();
    }
    
    @RequestMapping(value = "/developer/{id}/delete", method=RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        this._developerRepository.delete(id);
    }
    
    @RequestMapping(value = "/developer/", method=RequestMethod.POST)
    public Developer saveDeveloper(@RequestBody Developer developer) {
        return this._developerRepository.save(developer);
    }
}
	
