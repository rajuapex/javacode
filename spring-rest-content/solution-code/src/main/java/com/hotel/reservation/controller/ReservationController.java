package com.hotel.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.reservation.model.Reservation;
import com.hotel.reservation.service.ReservationService;

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
	private ReservationService reservationService;

	@GetMapping(path = "/reservations")
	List<Reservation> getAllReservations() {
		return reservationService.getAllReservations();
	}

	@GetMapping(path = { "/reservations", "/reservationsPDF" }, produces = { MediaType.APPLICATION_PDF_VALUE })
	ResponseEntity<byte[]> getReservationsPDF() {
		byte[] pdf = reservationService.getReservationsPDF();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdf);
	}

	@PostMapping("/reservations")
	Reservation makeReservation(@RequestBody Reservation reservation) {
		return reservationService.makeReservation(reservation.getNameOnReservation(), reservation.getCheckIn(),
				reservation.getNumberOfNights());
	}

}
