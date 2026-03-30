package com.triveratravel.airport.service;

import com.triveratravel.airport.service.model.Flight;

import java.util.List;

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
public interface FlightService {

	/**
	 * Get all Flights departing today
	 * 
	 * @return a List containing zero or more Flight objects
	 */
	List<Flight> getDepartures();

	/**
	 * Get all Flights departing to a particular destination
	 * 
	 * @param destinationCode The 3-letter code of the destination of the flight
	 * @return a List containing zero or more Flight objects
	 */
	List<Flight> getDeparturesByDestination(String destinationCode);

	/**
	 * Lookup a flight by its flight number
	 * 
	 * @param flightNumber The flightNumber to retrieve
	 * @return the flight for the given FlightNumber or null
	 */
	Flight getDepartureByFlightNumber(String flightNumber);

}