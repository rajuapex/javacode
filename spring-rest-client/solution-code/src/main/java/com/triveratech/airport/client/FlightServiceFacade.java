package com.triveratech.airport.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.triveratech.airport.client.model.DepartureData;

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
public class FlightServiceFacade {

	@Value("${base.url}")
	private String baseURL;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * "/flights/departure/{flightNumber}"
	 */
	public DepartureData getFlightByFlightNumber(String flightNumber) {
		String URL = baseURL + "/flights/departure/{flightNumber}";
		return restTemplate.getForObject(URL, DepartureData.class, flightNumber);
	}

	/**
	 * "/flights/departures"
	 */
	public List<DepartureData> getAllFlights() {
		String URL = baseURL + "/flights/departures";

		ParameterizedTypeReference<List<DepartureData>> type = new ParameterizedTypeReference<>() {
		};

		ResponseEntity<List<DepartureData>> response = restTemplate.exchange(URL, HttpMethod.GET, null, type);

		return response.getBody();
	}

	/**
	 * "/flights/departures/{destinationCode}"
	 */
	public List<DepartureData> getFlightsDepartingTo(String destinationCode) {
		String URL = baseURL + "/flights/departures/{destinationCode}";

		UriTemplate uriTemplate = new UriTemplate(URL);
		URI uri = uriTemplate.expand(destinationCode);

		ParameterizedTypeReference<List<DepartureData>> type = new ParameterizedTypeReference<>() {	};

		ResponseEntity<List<DepartureData>> response = restTemplate.exchange(uri, HttpMethod.GET, null, type);

		return response.getBody();
	}

}
