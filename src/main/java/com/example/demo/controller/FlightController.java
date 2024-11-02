package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Flight;
import com.example.demo.dto.FlightDto;
import com.example.demo.exception.FlightValidationException;
import com.example.demo.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@PostMapping("/create-flights")
	public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto){
		FlightDto createFlight=flightService.createFlight(flightDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createFlight);
	}
	
	@GetMapping("/flight-list")
	public ResponseEntity<List<Flight>> getListOfAllFlight(){
		List<Flight> flightDto=flightService.getListOfFlight();
		return ResponseEntity.status(HttpStatus.OK).body(flightDto);
	}
	
	@GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String from, @RequestParam String to) {
        List<Flight> flights= flightService.findFlightByLocation(from, to);
        if(flights == null || flights.isEmpty()) {
        	throw new FlightValidationException("No flights found");
        }
        return flights;
    }
	
	@PostMapping
	public ResponseEntity<FlightDto> bookFlightTicket(@RequestBody FlightDto flightDto){
		FlightDto bookTicket= flightService.bookOnlineTickets(flightDto);
		return null;
	}
}
