package com.triveratravel.client;

import java.util.List;

import com.triveratravel.model.Reservation;

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
public class ReservationEvent {
	private int httpStatusCode;
	private List<String> urls;
	private Reservation reservation;

	public ReservationEvent(int httpStatusCode, List<String> urls, Reservation reservation) {
		super();
		this.httpStatusCode = httpStatusCode;
		this.urls = urls;
		this.reservation = reservation;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public List<String> getUrls() {
		return urls;
	}

	public Reservation getReservation() {
		return reservation;
	}

}
