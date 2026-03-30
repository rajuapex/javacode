package com.triveratravel.service;

import com.triveratravel.model.Reservation;
import com.triveratravel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC., Worldwide
 * <p>
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 * <p>
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 *
 * 
 */
@Service
public class HotelServiceImpl implements HotelService {

   @Autowired
   private ReservationRepository reservationRepository;

   /**
    * Find ONE reservation using the reservation number
    * @param reservationNumber The reservation number to find
    * @return an instance or Optional containing the reservation or an empty Optional
    */
   public Optional<Reservation> findReservation(Integer reservationNumber) {
      Reservation reservation = reservationRepository.findOneByReservationNumber(reservationNumber);
      return Optional.ofNullable(reservation);
   }

   /**
    * Find all the reservations made under the name provided
    * @param nameOnReservation The name on the reservation
    * @return A List containing zero or more reservations
    */
   public List<Reservation> findReservations(String nameOnReservation) {
      return reservationRepository.findByNameOnReservation(nameOnReservation);
   }

   /**
    * Find all reservations for a single hotel, where the name contains the value specified
    * @param hotelName The name of the hotel for which to find reservations
    * @param nameOnReservationLike The (partial) name to search for
    * @return A List containing zero or more reservations
    */
   public List<Reservation> findReservations(String hotelName, String nameOnReservationLike) {
      return reservationRepository.findByHotelNameAndNameOnReservationIsLike(hotelName, nameOnReservationLike);
   }

   /**
    * Get the NUMBER of reservations that was made for a given hotel
    * @param hotelName The hotel for which the reservations should be counted
    * @return A positive integer value
    */
   public int getNumberOfReservations(String hotelName) {
      return reservationRepository.countReservationsByHotelName(hotelName);
   }

   /**
    * Find all reservations for a given arrival date, SORTED (ASCENDING) by the name of the reservation
    * @param arrivalDate The arrival date
    * @return A List containing zero or more reservations, sorted by the name on the reservation
    */
   public List<Reservation> findReservations(LocalDate arrivalDate) {
      Sort sort = Sort.by("nameOnReservation").ascending();
      return reservationRepository.findReservationsByArrivalDate(arrivalDate, sort);
   }

   /**
    * Find all reservations for a given hotel, but making sure the result is divided over multiple pages
    * @param hotelName The name of the hotel
    * @param page The page number of results ( greater than zero )
    * @return A Page instance containing zero or more (at most 10) Reservation instances
    */
   public Page<Reservation> findReservations(String hotelName, int page) {
      PageRequest pageable = PageRequest.of(page - 1, 10);
      return reservationRepository.findReservationsByHotelName(hotelName, pageable);
   }
}
