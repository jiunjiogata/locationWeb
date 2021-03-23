package com.rjo.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rjo.location.entities.Location;
import com.rjo.location.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository repository; 
	
	@Override
	public Location saveLocation(Location location) {
		System.out.println("dentro do metodo: saveLocation");
			return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		System.out.println("dentro do metodo: updateLocation");
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);
	}

	@Override
	public Location getLocationById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		System.out.println("dentro do metodo: getAllLocation");
		return repository.findAll();
	}

}
