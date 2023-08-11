package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vehicledetails")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleid;
	

	private String modelno;

	
	private String company;
	private String description;
	
	//creating table using foreign key
	//using create in application props will create a new column and delete old 
	@OneToOne(cascade =CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="driverno",referencedColumnName="driverid")
	private Driver driver;
	
	public Vehicle() {}
	public Vehicle(int vehicleid, String modelno, String company, String description, Driver driver) {
		super();
		this.vehicleid = vehicleid;
		this.modelno = modelno;
		this.company = company;
		this.description = description;
		this.driver = driver;
	}
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getModelno() {
		return modelno;
	}
	public void setModelno(String modelno) {
		this.modelno = modelno;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleid=" + vehicleid + ", modelno=" + modelno + ", company=" + company + ", description="
				+ description + ", driver=" + driver + "]";
	}
	
	
	
	
	
}
