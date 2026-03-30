package com.triveratech.airport.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.triveratech.airport.client.configuration.JavaConfig;
import com.triveratech.airport.client.model.DepartureData;

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
public class TestClient {

	public static void main(String[] args) {
		TestClient tc = new TestClient();
		tc.test();
	}

	public void test() {

		try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				JavaConfig.class);) {

			FlightServiceFacade client = applicationContext.getBean(FlightServiceFacade.class);

			System.out.println("--- Retrieving Flight HA2336 ---");
			DepartureData flightByFlightNumber = client.getFlightByFlightNumber("HA2336");
			if (flightByFlightNumber != null) {
				System.out.println(flightByFlightNumber);
			}

			System.out.println("--- Retrieving all departures ---");
			List<DepartureData> allArrivals = client.getAllFlights();
			allArrivals.forEach(System.out::println);

			System.out.println("--- Retrieving all Las Vegas departures ---");
			List<DepartureData> allLASDepartureFlights = client.getFlightsDepartingTo("LAS");
			allLASDepartureFlights.forEach(System.out::println);

			System.out.println("-----------------------------------------");
			System.out.printf("Found %d departures%n", allArrivals.size());
			System.out.printf("Found %d flights departing to Las Vegas%n", allLASDepartureFlights.size());
		}
	}
}
