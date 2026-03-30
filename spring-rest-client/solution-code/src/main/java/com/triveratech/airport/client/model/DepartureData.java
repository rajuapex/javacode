package com.triveratech.airport.client.model;

import java.time.LocalTime;

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
public class DepartureData {
	private String flightNumber;
	private String destination;
	private String airlineName;
	private LocalTime time;

	private String terminal;

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	@Override
	public String toString() {
		return String.format("DepartureData [destination=%s,  airlineName=%s, flightNumber=%s, time=%s, terminal=%s]",
				destination, airlineName, flightNumber, time, terminal);
	}

}
