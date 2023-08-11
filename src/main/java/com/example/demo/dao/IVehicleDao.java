package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vehicle;

@Repository
public interface IVehicleDao extends JpaRepository<Vehicle, Integer> {

	@Query("Select v from Vehicle v where v.company =?1")
	List<Vehicle> getVehicleByBrand(String brand);

	
}
