package com.hotel.reservation.client;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.hotel.reservation.client.model.HotelReservation;

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
@Component
public class ReservationServiceFacadeImpl implements ReservationServiceFacade {

	@Value("${base.url}")
	private String baseURL;

	@Autowired
	private RestTemplate restTemplate;

	public List<HotelReservation> getAllReservations() {
		String URL = baseURL + "/reservations";

		return Collections.EMPTY_LIST;
	}

	public HotelReservation getReservationByReservationNumber(Integer reservationNumber) {
		String URL = baseURL + "/reservations/{reservationNumber}";
		return null;
	}

	public HotelReservation makeReservation(HotelReservation reservation) {
		String URL = baseURL + "/reservations";
		return null;
	}

	public void updateReservation(Integer reservatioNumber, HotelReservation reservation) {
		String URL = baseURL + "/reservations/{reservationNumber}";

	}

	void cancelReservation(@PathVariable Integer reservationNumber) {
		String URL = baseURL + "/reservations/{reservationNumber}";

	}
}
