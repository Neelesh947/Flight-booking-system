package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Flight;
import com.example.demo.dto.FlightDto;

public interface FlightService {

	FlightDto bookOnlineTickets(FlightDto flightDto);

	FlightDto createFlight(FlightDto flightDto);

	List<Flight> getListOfFlight();

	List<Flight> findFlightByLocation(String from, String to);

}
