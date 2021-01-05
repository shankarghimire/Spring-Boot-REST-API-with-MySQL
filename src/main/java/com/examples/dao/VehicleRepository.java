package com.examples.dao;

import org.springframework.data.repository.CrudRepository;

import com.examples.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	Vehicle findByVehicleId(Long vehicleId);
}
