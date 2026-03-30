package com.hotel.reservation.client.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

public class HotelReservation {
	private Integer reservationNumber;
	private String nameOnReservation;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate checkIn;
	private int numberOfNights;

	public HotelReservation() {
		super();
	}

	public HotelReservation(String nameOnReservation, LocalDate checkIn, int numberOfNights) {
		super();
		this.nameOnReservation = nameOnReservation;
		this.checkIn = checkIn;
		this.numberOfNights = numberOfNights;
	}

	public Integer getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(Integer reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getNameOnReservation() {
		return nameOnReservation;
	}

	public void setNameOnReservation(String nameOnReservation) {
		this.nameOnReservation = nameOnReservation;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	@Override
	public String toString() {
		return String.format(
				"HotelReservation [reservationNumber=%s, nameOnReservation=%s, checkIn=%tD, numberOfNights=%d]%n",
				reservationNumber, nameOnReservation, checkIn, numberOfNights);
	}

}
