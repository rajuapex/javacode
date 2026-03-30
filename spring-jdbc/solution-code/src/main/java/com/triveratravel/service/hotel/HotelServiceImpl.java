package com.triveratravel.service.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.triveratravel.model.PaymentStatus;
import com.triveratravel.model.Reservation;
import com.triveratravel.repository.ReservationRepository;
import com.triveratravel.repository.UpdateReservationQuery;
import com.triveratravel.service.CreditCardService;
import com.triveratravel.service.HotelService;
import com.triveratravel.service.InvalidCardException;
import com.triveratravel.service.PaymentException;

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
@Service
public class HotelServiceImpl implements HotelService {
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${number.of.rooms}")
	private int numberOfRooms;
	@Value("${price.per.night}")
	private BigDecimal pricePerNight;

	@Autowired
	private CreditCardService creditcardService;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private UpdateReservationQuery updateQuery;

	public Reservation makeReservation(String nameOnReservation, String creditCardNumber, LocalDate arrivalDate,
			int numberOfNights) throws PaymentException, InvalidCardException {

		Reservation reservation = new Reservation(nameOnReservation, arrivalDate, numberOfNights);
		reservationRepository.addReservation(reservation);

		BigDecimal totalPrice = pricePerNight.multiply(new BigDecimal(numberOfNights));
		try {
			creditcardService.makePayment(nameOnReservation, creditCardNumber, totalPrice);
			updateQuery.execute(reservation.getId(), PaymentStatus.PAID);
		} catch (PaymentException e) {
			updateQuery.execute(reservation.getId(), PaymentStatus.AWAITING_AUTHORIZATION);
			throw e;
		}

		return reservation;
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

}
