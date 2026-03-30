package com.triveratravel.service;

import java.time.LocalDate;
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
public interface HotelService {

	Reservation makeReservation(String nameOnReservation, String creditCardNumber, LocalDate arrivalDate,
			int numberOfNights) throws PaymentException, InvalidCardException;

	List<Reservation> getAllReservations();
}
