package com.rjo.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rjo.location.entities.Location;
import com.rjo.location.repository.LocationRepository;
import com.rjo.location.service.LocationService;
import com.rjo.location.util.EmailUtil;
import com.rjo.location.util.ReportUtil;

@Controller
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location Saved with Id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("tusuario852@gmail.com", "Location Criado", "Location created succesfully" );
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		System.out.println("entrou no /displayLocations...");
		List<Location> allLocations = service.getAllLocation();
		System.out.println("Saiu do metodo getAllocation()");
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		//Location location = service.getLocationById(id);
		System.out.println("entrou no /deleteLocation...");
		System.out.println("id:"+id);
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> allLocations = service.getAllLocation();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String updateLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap ) {
		System.out.println("entrou no updateLocation...");
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/report")
	public String generateReport() {
		String realPath = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(realPath, data);
		return "report";
	}

}
