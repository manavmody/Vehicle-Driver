
package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="driverdetails")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name="seq",initialValue=100001,allocationSize=1)
	private int driverid;
	
	@Column(name="dname")
	private String name;
	
	private long contactno;
	public Driver() {}
	public Driver(int driverid, String name, long contactno) {
		super();
		this.driverid = driverid;
		this.name = name;
		this.contactno = contactno;
	}
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
//	@Override
//	public String toString() {
//		return "Driver [driverid=" + driverid + ", name=" + name + ", contactno=" + contactno + "]";
//	}
	
	
	
}
