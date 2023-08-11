package com.example.demo.controller;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vehicle;
import com.example.demo.exception.DriverMissingException;
import com.example.demo.exception.VehicleNotFoundException;
import com.example.demo.service.IVehicleService;
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/vehicle")
public class VehicleController {

	
	@Autowired
	private IVehicleService service;
	
	@GetMapping(value="/get",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vehicle>> getVehicleList(){
		List<Vehicle> list2 = service.getAllVehicles();
		return new ResponseEntity<List<Vehicle>>(list2,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v1) throws DriverMissingException{
		Vehicle veh1 = service.insertVehicle(v1);
		return new ResponseEntity<Vehicle>(veh1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteVehicle(@PathVariable int id) {
		service.deleteById(id);
		return "deleted";
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle v1,@PathVariable("id")int id) throws VehicleNotFoundException {
		Vehicle veh1=service.updateVehicle(v1,id);
		if(veh1==null) {
			throw new VehicleNotFoundException("Invalid id");
		}				
		return new ResponseEntity<Vehicle>(veh1,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/brand/{name}")
	public List<Vehicle> getVehicleByBrand(@PathVariable("name") String brand){
		return service.getVehicleByBrand(brand);
	}
	
	
//	@ExceptionHandler(value = VehicleNotFoundException.class)
//	public ResponseEntity handleVehicleId(VehicleNotFoundException ve) {
//		return new ResponseEntity("Vehicle id is invaliddd",HttpStatus.CONFLICT);
//	}
}
