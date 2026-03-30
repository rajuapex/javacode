package com.triveratravel.airport.rest.controller;

import com.triveratravel.airport.service.FlightService;
import com.triveratravel.airport.service.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/flights")
public class FlightController {

   @Autowired
   private FlightService flightService;

   @GetMapping("/departures")
   public List<Flight> getAllFlights() {
      return flightService.getDepartures();
   }

   @GetMapping("/departures/{destinationCode}")
   public List<Flight> getFlightsDepartingTo(@PathVariable String destinationCode) {
      return flightService.getDeparturesByDestination(destinationCode);
   }

   @GetMapping("/departure/{flightNumber}")
   public Flight getFlightByFlightNumber(@PathVariable String flightNumber) {
      return flightService.getDepartureByFlightNumber(flightNumber);
   }
}
