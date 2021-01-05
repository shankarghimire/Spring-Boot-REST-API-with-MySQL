package com.examples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.dao.VehicleRepository;
import com.examples.entity.Vehicle;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle findVehicleById(Long vehicleId) {
		return vehicleRepository.findByVehicleId(vehicleId);
	}

}
