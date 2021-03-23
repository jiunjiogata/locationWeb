package com.rjo.location.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjo.location.entities.Location;
import com.rjo.location.repository.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	LocationRepository locationRep;
	
	@GetMapping
	public List<Location> getLocations(){
		return locationRep.findAll();
	}
	
	@PostMapping
	public 	Location createLocation(@RequestBody Location location) {
		return locationRep.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRep.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRep.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional <Location> getLocationById(@PathVariable("id") Integer id) {
		return locationRep.findById(id);
	}
}
