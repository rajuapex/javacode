package com.triveratravel.service;

import java.util.List;

import com.triveratravel.model.Reservation;
import com.triveratravel.repository.ReservationRepository;

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

public class HotelService {
	private String hotelName;
	private int numberOfRooms;
	private ReservationRepository reservationRepository;

	public String getHotelName() {
		return hotelName;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public void setReservationRepository(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public List<Reservation> getReservations() {
		List<Reservation> allReservations = reservationRepository.findAll();
		return allReservations;
	}
}
