package com.triveratravel;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.triveratravel.model.PaymentStatus;
import com.triveratravel.model.Reservation;
import com.triveratravel.service.HotelService;
import com.triveratravel.service.InvalidCardException;
import com.triveratravel.service.PaymentException;
import org.springframework.context.annotation.Bean;

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
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(HotelService hotelService){
		return args -> {
			registerSid(hotelService);
			registerManfred(hotelService);
			registerDiego(hotelService);
			showAllReservations(hotelService);
		};
	}

	private static void registerSid(HotelService service) {
		try {
			service.makeReservation("Sid", "9999-9999-9999-9999", LocalDate.now(), 5);
			System.out.println(
					"UNEXPECTED RESULT, Sid uses invalid creditcard number, which should throw InvalidCardException");
		} catch (PaymentException e) {
			System.out.println(
					"UNEXPECTED RESULT, Sid uses invalid creditcard number, which should throw InvalidCardException Instead");
		} catch (InvalidCardException e) {
			System.out.println("Reservation of Sid failed, Transaction aborted");
		}
	}

	private static void registerManfred(HotelService service) {
		try {
			service.makeReservation("Manfred", "2014-0000-0000-3020", LocalDate.now(), 5);
			System.out.println("UNEXPECTED RESULT, Manfred uses 'En Route' card, which should throw PaymentException");
		} catch (PaymentException e) {
			System.out.printf("Reservation for Manfred was made (Status set to %s)%n",
					PaymentStatus.AWAITING_AUTHORIZATION);
		} catch (InvalidCardException e) {
			System.out.println("UNEXPECTED RESULT, Manfred uses valid 'En Route' card");
		}
	}

	private static void registerDiego(HotelService service) {
		try {
			Reservation reservation = service.makeReservation("Diego", "5100-0000-0000-0008", LocalDate.now(), 5);
			System.out.printf("Reservation for Diego was made (Status set to %s) -> %s%n", PaymentStatus.PAID,
					reservation);
		} catch (PaymentException e) {
			System.out.println("UNEXPECTED RESULT, Diego uses Mastercard which should allow payment");
		} catch (InvalidCardException e) {
			System.out.println("UNEXPECTED RESULT, Diego uses valid Mastercard");
		}
	}

	private static void showAllReservations(HotelService service) {
		System.out.println("------ All Reservations ------");
		List<Reservation> allReservations = service.getAllReservations();
		allReservations.forEach(System.out::println);
		System.out.println("------------------------------");
	}
}
