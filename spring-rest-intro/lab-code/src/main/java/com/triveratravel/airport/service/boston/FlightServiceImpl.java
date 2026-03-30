package com.triveratravel.airport.service.boston;

import com.triveratravel.airport.service.repository.FlightRepository;
import com.triveratravel.airport.service.FlightService;
import com.triveratravel.airport.service.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Service
public class FlightServiceImpl implements FlightService {

   @Autowired
   private FlightRepository flightRepository;

   public List<Flight> getDepartures() {
      return flightRepository.findAll();
   }

   public List<Flight> getDeparturesByDestination(String destinationCode) {
      return flightRepository.findByDestinationCode(destinationCode);
   }

   public Flight getDepartureByFlightNumber(String flightNumber) {
      return flightRepository.findByFlightNumber(flightNumber).orElse(null);
   }
}
