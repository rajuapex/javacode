package com.triveratravel.airport.service.repository;

import com.triveratravel.airport.service.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC., Worldwide
 * <p>
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 * <p>
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 *
 * 
 */
public interface FlightRepository extends JpaRepository<Flight, Integer> {

  List<Flight> findByDestinationCode(String destinationCode);

   Optional<Flight> findByFlightNumber(String flightNumber);
}
