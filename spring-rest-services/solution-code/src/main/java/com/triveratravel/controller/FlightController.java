package com.triveratravel.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.triveratravel.model.Flight;
import com.triveratravel.service.JTravelService;

@RestController
public class FlightController {

	@Autowired
	private JTravelService travelService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/flights/{destinationCode}")
	public ResponseEntity<List<FlightDTO>> searchFlightsByDestinationCode(@PathVariable String destinationCode) {
		List<Flight> flights = travelService.searchFlightsByDestinationCode(destinationCode);
		if (flights.size() == 0) {
			return ResponseEntity.notFound().build();
		}

		List<FlightDTO> dto = flights.stream().map(f -> modelMapper.map(f, FlightDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}
}
