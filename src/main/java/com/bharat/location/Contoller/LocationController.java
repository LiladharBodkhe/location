package com.bharat.location.Contoller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bharat.location.entities.Location;
import com.bharat.location.repo.LocationRepository;
import com.bharat.location.service.LocationService;
import com.bharat.location.util.EmailUtil;
import com.bharat.location.util.ReportUtil;

@Controller
public class LocationController {
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	ServletContext sc;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	
	
	@RequestMapping("/showcreate")
	
	public String showCreate()
	{
		//return "hello";
		//return "WEB_INF/jsps/CreateLocation.jsp";
		return "CreateLocation";
	}
	
	/*@RequestMapping("/show")
	public String Create()
	{
		return "http://localhost:4200/";
	}*/
	@RequestMapping(value="/saveloc", method=RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap)
	{
		System.out.println("hello world");
		Location locationsaved=service.saveLocation(location);
		String msg ="Location saved with Id : "+ locationsaved.getId();
		modelMap.addAttribute("msg",msg);
		//emailUtil.sendEmail("springboot767@gmail.com", "Location saved", "your location saved successfully saved");
		return "CreateLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocation(ModelMap modelMap)
	{
		List<Location> locations =service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	
	@RequestMapping("deletelocation")
	public String DeleteLocation(@RequestParam("id") int id,ModelMap modelMap)
	{
		//Location location =service.getLocationById(id);
		Location location=new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations =service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showupdate")
	public String showupdate(@RequestParam("id") int id,ModelMap modelMap)
	{
		Location location =service.getLocationById(id);
		modelMap.addAttribute("locations",location);
		return "updateLocation";
	}
	@RequestMapping("/updateloc")
	public String  updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap)
	{
		service.updateLocation(location);
		List<Location> locations =service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	@RequestMapping("/generatereport")
	public String generateReport()
	{
		String path =sc.getRealPath("/");
		List<Object[]> data=repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}

}
