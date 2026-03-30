package com.triveratravel.airport.service.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
@Entity
@Table(name = "FLIGHTS")
public class Flight extends AbstractPersistable<Integer> {
	private String destination;
	private String destinationCode;

	private String airlineName;
	private String airlineCode;
	private String flightNumber;
	private LocalTime time;
	private String terminal;
	private boolean codeShare;

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

	public String getDestinationCode() {
		return destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public boolean isCodeShare() {
		return codeShare;
	}

	public void setCodeShare(boolean codeShare) {
		this.codeShare = codeShare;
	}

	@Override
	public String toString() {
		return String.format(
				"Flight [destination=%s, destinationCode=%s, airlineName=%s, airlineCode=%s, flightNumber=%s, time=%s, terminal=%s, codeShare=%s]",
				destination, destinationCode, airlineName, airlineCode, flightNumber, time, terminal, codeShare);
	}

}
