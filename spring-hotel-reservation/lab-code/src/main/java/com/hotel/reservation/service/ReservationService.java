package com.hotel.reservation.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hotel.reservation.model.Reservation;

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
public interface ReservationService {

	List<Reservation> getAllReservations();

	Optional<Reservation> getReservation(Integer reservationNumber);

	Reservation makeReservation(String nameOnReservation, LocalDate checkIn, int numberOfNights);

	Reservation updateReservation(Integer reservationNumber, String nameOnReservation, LocalDate checkIn,
			int numberOfNights);

	void cancelReservation(Integer reservationNumber);

}