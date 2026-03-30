package com.hotel.reservation.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reservation.model.Reservation;
import com.hotel.reservation.repository.ReservationRepository;
import com.hotel.reservation.service.ReservationService;
import com.hotel.reservation.service.impl.pdf.PDFProcessor;

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
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationNumberGenerator numberGenerator;

	@Autowired
	private ReservationRepository reservationRepository;

	public byte[] getReservationsPDF() {
		List<Reservation> allReservations = reservationRepository.findAll();
		return PDFProcessor.createPDF(allReservations);
	}

	public List<Reservation> getAllReservations() {
		List<Reservation> allReservations = reservationRepository.findAll();
		return allReservations;
	}

	public Optional<Reservation> getReservation(Integer reservationNumber) {
		Optional<Reservation> reservationById = reservationRepository.findByReservationNumber(reservationNumber);
		return reservationById;
	}

	public Reservation makeReservation(String nameOnReservation, LocalDate checkIn, int numberOfNights) {
		Reservation reservation = new Reservation();
		reservation.setReservationNumber(numberGenerator.getNextReservationNumber());
		reservation.setNameOnReservation(nameOnReservation);
		reservation.setCheckIn(checkIn);
		reservation.setNumberOfNights(numberOfNights);
		reservationRepository.save(reservation);

		return reservation;
	}

	public Reservation updateReservation(Integer reservationNumber, String nameOnReservation, LocalDate checkIn,
			int numberOfNights) {
		Optional<Reservation> persistedReservation = getReservation(reservationNumber);

		if (persistedReservation.isPresent()) {
			Reservation persisted = persistedReservation.get();
			persisted.setNameOnReservation(nameOnReservation);
			persisted.setNumberOfNights(numberOfNights);
			persisted.setCheckIn(checkIn);
			reservationRepository.save(persisted);
			return persisted;
		}
		return null;
	}

	public void cancelReservation(Integer reservationNumber) {
		Optional<Reservation> persistedReservation = getReservation(reservationNumber);
		persistedReservation.ifPresent(entity -> reservationRepository.delete(entity));
	}

}
