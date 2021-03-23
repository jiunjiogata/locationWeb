package com.rjo.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rjo.location.entities.Location;


public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	
	  @Query("SELECT type, count(type) FROM Location group by type") 
	  public List<Object[]> findTypeAndTypeCount();
	 
		
}
