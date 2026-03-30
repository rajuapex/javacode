package com.triveratravel.client;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.triveratravel.model.Flight;
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
@Component
public class JTravelFacade {

	@Value("${base.url}")
	private String baseURL;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public Reservation getReservation(Integer reservationNumber) {
		ResponseEntity<Reservation> entity;
		try {
			entity = restTemplate.getForEntity(baseURL + "/reservations/{reservationNumber}", Reservation.class,
					reservationNumber);
		} catch (RestClientException e) {
			applicationEventPublisher.publishEvent(new ReservationExceptionEvent(e));
			e.printStackTrace();
			return null;
		}
		return entity.getBody();
	}

	public void makeReservation(String nameOnReservation, String flightNumber) {
		Reservation reservation = new Reservation();
		reservation.setNameOnReservation(nameOnReservation);
		reservation.setFlightNumber(flightNumber);

		ResponseEntity<Reservation> responseEntity;
		try {
			responseEntity = restTemplate.postForEntity(baseURL + "/reservations", reservation, Reservation.class);
		} catch (RestClientException e) {
			applicationEventPublisher.publishEvent(new ReservationExceptionEvent(e));
			e.printStackTrace();
			return;
		}

		int statusCodeValue = responseEntity.getStatusCodeValue();
		List<String> locations = responseEntity.getHeaders().get("Location");
		ReservationEvent reservationEvent = new ReservationEvent(statusCodeValue, locations, responseEntity.getBody());
		applicationEventPublisher.publishEvent(reservationEvent);
	}

	public List<Flight> getFlightsByDestinationCode(String destinationCode) {
		String URL = baseURL + "/flights/{destinationCode}";
		UriTemplate uriTemplate = new UriTemplate(URL);
		URI uri = uriTemplate.expand(destinationCode);

		ParameterizedTypeReference<List<Flight>> type = new ParameterizedTypeReference<List<Flight>>() {
		};
		ResponseEntity<List<Flight>> response;
		try {
			response = restTemplate.exchange(uri, HttpMethod.GET, null, type);
		} catch (RestClientException e) {
			applicationEventPublisher.publishEvent(new ReservationExceptionEvent(e));
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}

		return response.getBody();
	}
}
