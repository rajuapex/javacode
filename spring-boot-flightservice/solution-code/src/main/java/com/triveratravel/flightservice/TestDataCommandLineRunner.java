package com.triveratravel.flightservice;
/**
 * <p>
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 * <p>
 * Copyright (c) 2021 Trivera Technologies, LLC. http://www.triveratech.com
 *
 * 
 * </p>
 */

import com.triveratravel.flightservice.domain.Flight;
import com.triveratravel.flightservice.domain.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataCommandLineRunner implements CommandLineRunner {
   @Autowired
   private FlightRepository flightRepository;

   @Override
   public void run(String... args) throws Exception {
      flightRepository.save(new Flight("DL80", "Boston"));
      flightRepository.save(new Flight("KL603", "Amsterdam"));
      flightRepository.save(new Flight("UA807", "Las Vegas"));
      flightRepository.save(new Flight("DL800", "Atlanta"));
   }
}
