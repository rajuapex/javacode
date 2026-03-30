package com.hotel.reservation.client;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hotel.reservation.client.config.JavaConfig;
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
public class MakeReservationClient {
	@Value("${base.url}")
	private String baseURL;

	@Autowired
	private RestTemplate restTemplate;

	public String makeReservation() {
		HotelReservation reservation = new HotelReservation("Jennifer", LocalDate.now(), 5);
		String URL = baseURL + "/reservations";
		String response = restTemplate.postForObject(URL, reservation, String.class);
		return response;
	}

	public static void main(String[] args) {
		try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				JavaConfig.class);) {
			MakeReservationClient client = applicationContext.getBean(MakeReservationClient.class);
			client.makeReservation();

		}
	}
}
