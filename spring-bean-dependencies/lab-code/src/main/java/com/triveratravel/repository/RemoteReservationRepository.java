package com.triveratravel.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

public class RemoteReservationRepository implements ReservationRepository {

	private List<Reservation> reservations = new ArrayList<>();

	public void init() {
		save(new Reservation("Sid", LocalDate.now(), 4));
		save(new Reservation("Scrat", LocalDate.now(), 4));
		save(new Reservation("Manfred", LocalDate.now(), 4));
		save(new Reservation("Diego", LocalDate.now(), 4));
		save(new Reservation("Eddie", LocalDate.now(), 4));
	}

	public Reservation save(Reservation reservation) {
		reservation.setId(reservations.size() + 1000);
		reservations.add(reservation);
		return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		return Collections.unmodifiableList(reservations);
	}

}
