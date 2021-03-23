package com.rjo.location.service;

import java.util.List;

import com.rjo.location.entities.Location;

public interface LocationService {
	
	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationById(Integer id);

	List<Location> getAllLocation();
	
}
