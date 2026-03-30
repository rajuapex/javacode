package com.hotel.reservation.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

		ParameterizedTypeReference<List<HotelReservation>> type = new ParameterizedTypeReference<>() {
		};
		ResponseEntity<List<HotelReservation>> response = restTemplate.exchange(URL, HttpMethod.GET, null, type);
		return response.getBody();
	}

	public HotelReservation getReservationByReservationNumber(Integer reservationNumber) {
		String URL = baseURL + "/reservations/{reservationNumber}";
		return restTemplate.getForObject(URL, HotelReservation.class, reservationNumber);
	}

	public HotelReservation makeReservation(HotelReservation reservation) {
		String URL = baseURL + "/reservations";
		return restTemplate.postForObject(URL, reservation, HotelReservation.class);
	}

	public void updateReservation(Integer reservatioNumber, HotelReservation reservation) {
		String URL = baseURL + "/reservations/{reservationNumber}";
		restTemplate.put(URL, reservation, reservatioNumber);
	}

	void cancelReservation(@PathVariable Integer reservationNumber) {
		String URL = baseURL + "/reservations/{reservationNumber}";
		restTemplate.delete(URL, reservationNumber);
	}
}
