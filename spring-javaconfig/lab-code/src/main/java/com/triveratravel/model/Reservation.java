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

	private Integer id;
	private String nameOnReservation;
	private LocalDate arrivalDate;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public boolean arrivesAt(LocalDate date) {
		return this.arrivalDate.equals(date);
	}

	@Override
	public String toString() {
		return String.format("Reservation [id=%d, nameOnReservation=%s,checkIn=%tD, numberOfNights=%d]", id,
				nameOnReservation, arrivalDate, numberOfNights);
	}

}
