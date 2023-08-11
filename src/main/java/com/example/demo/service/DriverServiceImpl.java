package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDriverDao;
import com.example.demo.entity.Driver;

@Service
public class DriverServiceImpl implements IDriverService {

	@Autowired
	private IDriverDao dao;
	@Override
	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		
		return dao.findAll();
	}

}
