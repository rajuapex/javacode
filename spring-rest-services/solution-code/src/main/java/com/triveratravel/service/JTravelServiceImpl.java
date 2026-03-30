package com.triveratravel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveratravel.model.Flight;
import com.triveratravel.model.Reservation;
import com.triveratravel.repository.FlightDepartureRepository;
import com.triveratravel.repository.ReservationsRepository;

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
@Service
public class JTravelServiceImpl implements JTravelService {

	@Autowired
	private FlightDepartureRepository flightDepartureRepository;

	@Autowired
	private ReservationsRepository reservationsRepository;

	@Override
	public List<Flight> searchFlightsByDestinationCode(String destinationCode) {
		return flightDepartureRepository.findFlightsByDestinationCode(destinationCode);
	}

	@Override
	public Optional<Reservation> findReservationByReservationNumber(Integer reservationNumber) {
		return reservationsRepository.findById(reservationNumber);
	}

	@Override
	public Reservation makeReservation(String nameOnReservation, String flightNumber) {
		Flight flight = flightDepartureRepository.getOne(flightNumber);
		Reservation flightReservation = new Reservation();
	
		flightReservation.setNameOnReservation(nameOnReservation);
		flightReservation.setFlight(flight);
		reservationsRepository.save(flightReservation);
		return flightReservation;
	}
}
