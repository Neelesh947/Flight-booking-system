package com.example.demo.exception;

public class FlightValidationException extends RuntimeException{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightValidationException(String message) {
	        super(message);
	    }
}
