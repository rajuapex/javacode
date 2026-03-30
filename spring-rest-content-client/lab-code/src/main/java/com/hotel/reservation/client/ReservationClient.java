package com.hotel.reservation.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.hotel.reservation.client.config.JavaConfig;

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
public class ReservationClient {

	@Value("${base.url}")
	private String baseURL;

	@Autowired
	private RestTemplate restTemplate;

	public void getAllReservations() {
		UriTemplate uriTemplate = new UriTemplate(baseURL + "/reservations");
		URI uri = uriTemplate.expand();

		RequestEntity<Void> request = RequestEntity.get(uri).build();

		ResponseEntity<String> response = restTemplate.exchange(request, String.class);
		System.out.println(response.getBody());
	}

	public static void main(String[] args) {
		try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				JavaConfig.class);) {
			ReservationClient client = applicationContext.getBean(ReservationClient.class);
			client.getAllReservations();

		}
	}

}
