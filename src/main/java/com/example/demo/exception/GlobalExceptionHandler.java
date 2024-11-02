package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	 	@ExceptionHandler(FlightValidationException.class)
	    public ResponseEntity<ErrorResponse> handleFlightValidationException(FlightValidationException ex) {
	        ErrorResponse errorResponse = new ErrorResponse("FLIGHT_VALIDATION_ERROR", ex.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }
}
