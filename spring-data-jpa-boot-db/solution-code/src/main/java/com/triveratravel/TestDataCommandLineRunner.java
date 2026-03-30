package com.triveratravel;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.triveratravel.service.HotelService;

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
	private HotelService hotelService;

	@Override
	public void run(String... args) throws Exception {
		hotelService.makeReservation("Diego", LocalDate.now(), 5);
		hotelService.makeReservation("Sid", LocalDate.now().plusDays(1), 4);

	}

}
