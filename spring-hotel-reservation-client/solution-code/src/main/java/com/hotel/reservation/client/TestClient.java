package com.hotel.reservation.client;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
public class TestClient {

	public static void main(String[] args) {
		TestClient tc = new TestClient();
		tc.test();

	}

	public void test() {
		try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				JavaConfig.class);) {

			ReservationServiceFacadeImpl facade = applicationContext.getBean(ReservationServiceFacadeImpl.class);

			HotelReservation reservation = new HotelReservation("Jack Smith", LocalDate.now().plusDays(4), 7);
			HotelReservation confirmed = facade.makeReservation(reservation);

			Integer reservationNumber = confirmed == null ? -1 : confirmed.getReservationNumber();
			waitForEnter("Reservation [%d] added:[%s]", reservationNumber, confirmed);

			HotelReservation reservationByNumber = facade.getReservationByReservationNumber(reservationNumber);
			waitForEnter("Reservation [%d] Found:[%s]", reservationNumber, reservationByNumber);

			if (reservationByNumber != null) {
				reservationByNumber.setNumberOfNights(3);
				facade.updateReservation(reservationNumber, reservationByNumber);
				waitForEnter("Reservation [%d] Updated", reservationNumber);
			}

			HotelReservation reservationByNumber2 = facade.getReservationByReservationNumber(reservationNumber);
			waitForEnter("Reservation [%d] Found:[%s]", reservationNumber, reservationByNumber2);

			facade.cancelReservation(reservationNumber);
			waitForEnter("Reservation [%d] Deleted", reservationNumber);

			List<HotelReservation> allReservations = facade.getAllReservations();
			allReservations.forEach(System.out::println);
		}
	}

	public void waitForEnter(String message, Object... args) {
		System.out.printf(message + "%nPress ENTER to continue.%n", args);

		try {
			System.in.read(new byte[2]);
		} catch (IOException e) {
			// ignore
		}
		System.out.println("------------------------------------------");
	}
}
