package com.triveratravel.service;

import java.util.List;
import java.util.Optional;

import com.triveratravel.model.Flight;
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
public interface JTravelService {

	List<Flight> searchFlightsByDestinationCode(String destinationCode);

	Optional<Reservation> findReservationByReservationNumber(Integer reservationNumber);

	Reservation makeReservation(String nameOnReservation, String flightNumber);

}