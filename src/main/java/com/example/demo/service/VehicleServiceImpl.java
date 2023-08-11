package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVehicleDao;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.DriverMissingException;
import com.example.demo.exception.VehicleNotFoundException;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	private IVehicleDao dao;

	@Override
	public List<Vehicle> getAllVehicles() {
		return dao.findAll();
	}

	@Override
	public Vehicle insertVehicle(Vehicle v) throws DriverMissingException{
		if(v.getDriver()==null) {
			throw new DriverMissingException();
		}
		return dao.save(v);
	}
	
	@Override
	public void deleteById(int id) throws VehicleNotFoundException{
		
		dao.deleteById(id);
		
	}
	

	@Override
	public Vehicle updateVehicle(Vehicle v1,int id ) throws VehicleNotFoundException{
		
		if(dao.existsById(id)) {
			return dao.save(v1);
		}else {
			throw new VehicleNotFoundException();
		}
		
		
	}

	@Override
	public List<Vehicle> getVehicleByBrand(String brand) {
		return dao.getVehicleByBrand(brand);
	}
	
	
	
	

	
	
	
	
}
