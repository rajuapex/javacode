package com.hotel.reservation.service.impl.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.hotel.reservation.model.Reservation;

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
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("unused")
public class JAXBReservation {
	private Integer reservationNumber;
	private String nameOnReservation;
	private String checkIn;
	private int numberOfNights;

	public JAXBReservation(Reservation reservation) {
		reservationNumber = reservation.getReservationNumber();
		nameOnReservation = reservation.getNameOnReservation();
		checkIn = reservation.getCheckIn().toString();
		numberOfNights = reservation.getNumberOfNights();
	}

}
