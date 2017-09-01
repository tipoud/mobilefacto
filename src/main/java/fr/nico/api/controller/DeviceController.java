
package fr.nico.api.controller;

import fr.nico.api.entity.Device;
import fr.nico.api.repository.DeviceRepository;

import java.util.List;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/device/**")
public class DeviceController {
    
    @Autowired
    private DeviceRepository _deviceRepository;
    
    @RequestMapping(value = "/device/{id}", method=RequestMethod.GET)
    public Device getDeviceById(@PathVariable Long id) {
        return this._deviceRepository.findOne(id);
    }
    
    @RequestMapping(value = "/device/", method=RequestMethod.GET)
    public List<Device> getAllDevices() {
        return this._deviceRepository.findAll();
    }
    
    @RequestMapping(value = "/device/{id}/delete", method=RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        this._deviceRepository.delete(id);
    }
    
    @RequestMapping(value = "/device/", method=RequestMethod.POST)
    public Device saveDevice(@RequestBody Device device) {
        return this._deviceRepository.save(device);
    }
}