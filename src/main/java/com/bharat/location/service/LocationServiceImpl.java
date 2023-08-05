package com.bharat.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharat.location.entities.Location;
import com.bharat.location.repo.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationRepository locationrepository;
	
	@Override
	
	public Location saveLocation(Location location) {
		System.out.println("welcome"+ location);
		return locationrepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationrepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		// TODO Auto-generated method stub
		locationrepository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return locationrepository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		return locationrepository.findAll();
	}

}
