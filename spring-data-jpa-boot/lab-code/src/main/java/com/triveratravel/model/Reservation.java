package com.triveratravel.model;

import java.time.LocalDate;

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

public class Reservation {

	public enum Status {
		NEW, CONFIRMED, CONFLICT, CANCELLED
	}

	private String nameOnReservation;
	private LocalDate arrivalDate;
	private Status status = Status.NEW;
	private int numberOfNights;

	public Reservation() {
		super();
	}

	public Reservation(String nameOnReservation, LocalDate arrivalDate, int numberOfNights) {
		super();
		this.nameOnReservation = nameOnReservation;
		this.arrivalDate = arrivalDate;
		this.numberOfNights = numberOfNights;
	}

	public String getNameOnReservation() {
		return nameOnReservation;
	}

	public void setNameOnReservation(String nameOnReservation) {
		this.nameOnReservation = nameOnReservation;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	@Override
	public String toString() {
		return String.format("Reservation [nameOnReservation=%s, checkIn=%tD, status=%s, numberOfNights=%d]",
				nameOnReservation, arrivalDate, status, numberOfNights);
	}
}
