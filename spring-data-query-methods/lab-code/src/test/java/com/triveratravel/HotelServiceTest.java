package com.triveratravel;

import com.triveratravel.model.Reservation;
import com.triveratravel.service.HotelService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


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

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class HotelServiceTest {

   @Autowired
   private HotelService hotelService;

   /*
    * Find a single a reservation using the Reservation Number
    */
   @Test
   public void test1() {
      Optional<Reservation> reservation1 = hotelService.findReservation(1002);
      Optional<Reservation> reservation2 = hotelService.findReservation(999);
      assertThat(reservation1, not(Optional.empty()));
      assertThat(reservation2, is(Optional.empty()));
   }

   /**
    * Find a reservation using the exact Name on the Reservation
    */
   @Test
   public void test2() {
      String nameOnReservation = "Olivia Peterson";
      List<Reservation> reservations = hotelService.findReservations(nameOnReservation);
      List<Integer> reservationNumbers = reservations.stream().map(Reservation::getReservationNumber).collect(Collectors.toList());

      assertThat(reservations, hasSize(1));
      assertThat(reservationNumbers, contains(new Integer(1068)));
   }

   /**
    * Find reservations within a single hotel, where the name starts with S
    */
   @Test
   public void test3() {
      String hotelName = "The TriveraTravel Lodge";
      String nameOnReservationLike = "S%";

      List<Reservation> reservations = hotelService.findReservations(hotelName, nameOnReservationLike);
      List<Integer> reservationNumbers = reservations.stream().map(Reservation::getReservationNumber).collect(Collectors.toList());

      assertThat(reservations, hasSize(3));
      assertThat(reservationNumbers, containsInAnyOrder(new Integer(1030), new Integer(1034), new Integer(1035)));
   }

   /**
    * Test the number of reservations made for a single hotel.
    */
   @Test
   public void test4() {
      String hotelName = "Duke's Bed and Breakfast";
      int numberOfReservations = hotelService.getNumberOfReservations(hotelName);
      assertThat(numberOfReservations, is(8));
   }

   /**
    * Find all reservations with an arrival date of Yesterday, sorted by name
    */
   @Test
   public void test5() {
      LocalDate yesterday = LocalDate.now().minusDays(1);
      List<Reservation> reservations = hotelService.findReservations(yesterday);
      List<Integer> reservationNumbers = reservations.stream().map(Reservation::getReservationNumber).collect(Collectors.toList());
      assertThat(reservations, hasSize(3));
      assertThat(reservationNumbers, contains(new Integer(1006), new Integer(1063), new Integer(1037)));
   }

   /**
    * Find all the reservations for a single hotel, but using a pages approach
    */
   @Test
   public void test6() {
      String hotelName = "The TriveraTravelSphere";
      Page<Reservation> page1 = hotelService.findReservations(hotelName, 1);
      Page<Reservation> page2 = hotelService.findReservations(hotelName, 2);
      Page<Reservation> page6 = hotelService.findReservations(hotelName, 6);
      List<Integer> reservationNumbersPage1 = page1.get().map(Reservation::getReservationNumber).collect(Collectors.toList());
      List<Integer> reservationNumbersPage2 = page2.get().map(Reservation::getReservationNumber).collect(Collectors.toList());
      List<Integer> reservationNumbersPage6 = page6.get().map(Reservation::getReservationNumber).collect(Collectors.toList());

      assertThat(page1.getTotalElements(), is(55L));
      assertThat(page2.getTotalPages(), is(6));

      assertThat(reservationNumbersPage1, containsInAnyOrder(new Integer(1038), new Integer(1039), new Integer(1040), new Integer(1041), new Integer(1042), new Integer(1043), new Integer(1044), new Integer(1045), new Integer(1046), new Integer(1047)));
      assertThat(reservationNumbersPage2, containsInAnyOrder(new Integer(1048), new Integer(1049), new Integer(1050), new Integer(1051), new Integer(1052), new Integer(1053), new Integer(1054), new Integer(1055), new Integer(1056), new Integer(1057)));
      assertThat(reservationNumbersPage6, containsInAnyOrder(new Integer(1088), new Integer(1089), new Integer(1090), new Integer(1091), new Integer(1092)));
   }

}
