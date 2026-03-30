package com.hotel.reservation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
@Component
public class TestDataCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ReservationService reservationService;

	@Override
	public void run(String... args) throws Exception {
		reservationService.makeReservation("Fred Flinstone", LocalDate.now(), 4);
		reservationService.makeReservation("Barney Rubble", LocalDate.now().plusDays(3), 1);
		reservationService.makeReservation("Joe Rockhead", LocalDate.now().plusDays(7), 2);
	}

}
