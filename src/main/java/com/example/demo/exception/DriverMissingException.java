package com.example.demo.exception;

public class DriverMissingException extends RuntimeException{
	
	public DriverMissingException() {
		
	}
	public DriverMissingException(String msg) {
		super(msg);
	}

}
