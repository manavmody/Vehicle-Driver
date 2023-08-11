package com.example.demo.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Vehicle;
import com.example.demo.exception.DriverMissingException;
import com.example.demo.exception.VehicleNotFoundException;
public interface IVehicleService {

	public List<Vehicle> getAllVehicles();
	public Vehicle insertVehicle(Vehicle v) throws DriverMissingException;
	public void deleteById(int id) throws VehicleNotFoundException;
	public Vehicle updateVehicle(Vehicle v, int id) throws VehicleNotFoundException;
	public List<Vehicle> getVehicleByBrand(String brand);
	
	
	
	
}
