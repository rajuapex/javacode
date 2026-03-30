package com.triveratravel.repository.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.triveratravel.model.Reservation;

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
public class TestData {
	public static List<Reservation> testData() {
		List<Reservation> reservations = new ArrayList<>();
		reservations.add(new Reservation("Sid", LocalDate.now(), 4));
		reservations.add(new Reservation("Scrat", LocalDate.now(), 4));
		reservations.add(new Reservation("Manfred", LocalDate.now(), 4));
		reservations.add(new Reservation("Diego", LocalDate.now(), 4));
		reservations.add(new Reservation("Eddie", LocalDate.now(), 4));
		return reservations;
	}

}
