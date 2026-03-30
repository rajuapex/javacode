package com.triveratravel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.triveratravel.model.Reservation;
import com.triveratravel.repository.ReservationRepository;

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
public class InitializeApplicationData implements CommandLineRunner {

	@Autowired
	private ReservationRepository repository;

	@Override
	public void run(String... args) throws Exception {
		List<Reservation> reservations = new ArrayList<>();
		reservations.add(new Reservation("Sid", LocalDate.now(), 4));
		reservations.add(new Reservation("Scrat", LocalDate.now(), 4));
		reservations.add(new Reservation("Manfred", LocalDate.now(), 4));
		reservations.add(new Reservation("Diego", LocalDate.now(), 4));
		reservations.add(new Reservation("Eddie", LocalDate.now(), 4));

		reservations.forEach(repository::save);
	}

}
