package com.triveratravel.controller;

import java.net.URI;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.triveratravel.model.Reservation;
import com.triveratravel.service.JTravelService;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC., Worldwide
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * 
 */
@RestController
public class ReservationController {

	@Autowired
	private JTravelService travelService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/reservations/{reservationNumber}")
	public ResponseEntity<ReservationDTO> getReservation(@PathVariable Integer reservationNumber) {
		Optional<Reservation> reservationOptional = travelService.findReservationByReservationNumber(reservationNumber);

		Optional<ReservationDTO> dtoOptional = reservationOptional.map(r -> modelMapper.map(r, ReservationDTO.class));

		return ResponseEntity.of(dtoOptional);
	}

	@PostMapping("/reservations")
	public ResponseEntity<ReservationDTO> makeReservation(@RequestBody ReservationDTO request) {
		Reservation reservation = travelService.makeReservation(request.getNameOnReservation(),
				request.getFlightNumber());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(reservation.getReservationNumber()).toUri();

		ReservationDTO dto = modelMapper.map(reservation, ReservationDTO.class);
		return ResponseEntity.created(uri).body(dto);
	}

}
