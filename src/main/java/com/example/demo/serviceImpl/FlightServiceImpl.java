package com.example.demo.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Flight;
import com.example.demo.dto.FlightDto;
import com.example.demo.exception.FlightValidationException;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.Seatrepository;
import com.example.demo.service.FlightService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private Seatrepository seatRepository;
	

	@Override
	public FlightDto createFlight(FlightDto flightDto) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		flightDto.setFlightId(uuid);
		
		if(flightDto.getArrivalTime().isAfter(flightDto.getDepartureTime())) {
			throw new FlightValidationException("Arrival time must be before departure time.");
		}
		
		Flight flight=new Flight();
		flight.setFlightId(flightDto.getFlightId());
		flight.setAirline(flightDto.getAirline());
		flight.setArrivalTime(flightDto.getArrivalTime());
		flight.setDepartureTime(flightDto.getDepartureTime());
		flight.setFromLocation(flightDto.getFrom());
		flight.setPrice(flightDto.getPrice());
		flight.setToLocation(flightDto.getTo());
		flight.setTotalSeat(flightDto.getTotalSeat());
		flight.setAvailableSeats(flightDto.getAvailableSeats());
		flight.setFlightNumber(flightDto.getFlightNumber());;
		return flightRepository.save(flight).getFlightDto();
	}
	
	@Override
	public List<Flight> getListOfFlight() {
		// TODO Auto-generated method stub
		return flightRepository.findAll();
	}
	
	public List<Flight> findFlightByLocation(String departureLocation, String arrivalLocation){
		List<Flight> flight=flightRepository.findByFromLocationAndToLocation(departureLocation, arrivalLocation);
		return flight;
	}

	@Override
	public FlightDto bookOnlineTickets(FlightDto flightDto) {
		// TODO Auto-generated method stub
		log.info("seat booking initiated...");
		
		return null;
	}
}
