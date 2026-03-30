package com.triveratravel;

import com.triveratravel.model.Hotel;
import com.triveratravel.model.Reservation;
import com.triveratravel.model.Reservation.Status;
import com.triveratravel.repository.HotelRepository;
import com.triveratravel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

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
@Component
public class TestDataCommandLineRunner implements CommandLineRunner {
   private LocalDate today = LocalDate.now();

   @Autowired
   private ReservationRepository reservationRepository;
   @Autowired
   private HotelRepository hotelRepository;

   private AtomicInteger lastGivenResevationNumber = new AtomicInteger(1000);

   @Override
   public void run(String... args) throws Exception {
      addReservations();
   }

   private void addReservations() {
      Hotel hotel1 = addHotel("The TriveraTravel Inn", "North Conway", "NH", 105);

      makeReservation(hotel1, "James Smith", -2, 4);
      makeReservation(hotel1, "Patricia Johnson", 7, 3);
      makeReservation(hotel1, "Jennifer Williams", 9, 2);
      makeReservation(hotel1, "Michael Jones", -18, 4);
      makeReservation(hotel1, "Elizabeth Brown", 7, 6);
      makeReservation(hotel1, "Barbara Davis", -1, 2);
      makeReservation(hotel1, "Richard Miller", -19, 5);
      makeReservation(hotel1, "Jessica Wilson", 4, 7);
      makeReservation(hotel1, "Thomas  Moore", -17, 5);
      makeReservation(hotel1, "Margaret Taylor", 13, 5);
      makeReservation(hotel1, "Christopher Anderson", 5, 7);
      makeReservation(hotel1, "Nancy Thomas", 5, 6);
      makeReservation(hotel1, "Lisa Jackson", -9, 3);
      makeReservation(hotel1, "Anthony White", 10, 6);
      makeReservation(hotel1, "Dorothy Harris", 18, 2);
      makeReservation(hotel1, "Sandra Martin", 20, 7);
      makeReservation(hotel1, "Paul Thompson", -11, 6);
      makeReservation(hotel1, "Kimberly Garcia", -6, 7);
      makeReservation(hotel1, "Andrew Martinez", 9, 5);
      makeReservation(hotel1, "Emily Robinson", 16, 4);

      Hotel hotel2 = addHotel("The TriveraTravel Lodge", "Naples", "ME", 12);
      makeReservation(hotel2, "Carol Clark", 10, 7);
      makeReservation(hotel2, "Joshua Rodriguez", 10, 3);
      makeReservation(hotel2, "Kevin Lewis", -5, 5);
      makeReservation(hotel2, "Brian Lee", 16, 6);
      makeReservation(hotel2, "Deborah Walker", 20, 2);
      makeReservation(hotel2, "Ronald Hall", -13, 5);
      makeReservation(hotel2, "Rebecca Allen", -14, 2);
      makeReservation(hotel2, "Laura Young", -4, 4);
      makeReservation(hotel2, "Jeffrey Hernandez", -2, 4);
      makeReservation(hotel2, "Sharon King", -10, 5);
      makeReservation(hotel2, "Cynthia Wright", 4, 3);
      makeReservation(hotel2, "Kathleen Lopez", -13, 5);
      makeReservation(hotel2, "Nicholas Hill", 14, 1);
      makeReservation(hotel2, "Shirley Scott", -14, 3);
      makeReservation(hotel2, "Stephen Green", -11, 5);
      makeReservation(hotel2, "Jonathan  Adams", 7, 4);
      makeReservation(hotel2, "Ruth Baker", -1, 3);

      Hotel hotel3 = addHotel("The TriveraTravelSphere", "Las Vegas", "NV", 256);
      makeReservation(hotel3, "Brenda Gonzalez", 14, 6);
      makeReservation(hotel3, "Scott Nelson", 16, 3);
      makeReservation(hotel3, "Brandon  Carter", 10, 7);
      makeReservation(hotel3, "Katherine Mitchell", 12, 5);
      makeReservation(hotel3, "Benjamin Perez", 11, 2);
      makeReservation(hotel3, "Gregory Roberts", 8, 2);
      makeReservation(hotel3, "Catherine Turner", 8, 1);
      makeReservation(hotel3, "Samuel Phillips", 18, 1);
      makeReservation(hotel3, "Debra Campbell", 15, 4);
      makeReservation(hotel3, "Alexander Parker", -20, 5);
      makeReservation(hotel3, "Janet Evans", -10, 1);
      makeReservation(hotel3, "Dennis Edwards", -3, 7);
      makeReservation(hotel3, "Jerry Collins", 7, 3);
      makeReservation(hotel3, "Maria Stewart", 10, 7);
      makeReservation(hotel3, "Aaron Sanchez", 16, 2);
      makeReservation(hotel3, "Diane Morris", -3, 1);
      makeReservation(hotel3, "Julie Rogers", 8, 2);
      makeReservation(hotel3, "Douglas Reed", 12, 3);
      makeReservation(hotel3, "Peter Cook", -17, 3);
      makeReservation(hotel3, "Adam Morgan", 13, 2);
      makeReservation(hotel3, "Victoria Bell", 1, 3);
      makeReservation(hotel3, "Kelly Murphy", 3, 6);
      makeReservation(hotel3, "Walter Bailey", -19, 2);
      makeReservation(hotel3, "Kyle Rivera", 6, 4);
      makeReservation(hotel3, "Harold Cooper", 7, 1);
      makeReservation(hotel3, "Martha Richardson", -1, 7);
      makeReservation(hotel3, "Judith Cox", 13, 2);
      makeReservation(hotel3, "Gerald Howard", -17, 1);
      makeReservation(hotel3, "Megan Ward", -18, 3);
      makeReservation(hotel3, "Roger Torres", 6, 5);
      makeReservation(hotel3, "Olivia Peterson", 9, 1);
      makeReservation(hotel3, "Terry Gray", -18, 2);
      makeReservation(hotel3, "Lawrence Ramirez", 7, 4);
      makeReservation(hotel3, "Alice James", 12, 4);
      makeReservation(hotel3, "Christian Watson", 6, 7);
      makeReservation(hotel3, "Hannah Brooks", 0, 5);
      makeReservation(hotel3, "Austin Kelly", 12, 7);
      makeReservation(hotel3, "Joe Sanders", -14, 7);
      makeReservation(hotel3, "Albert Price", -4, 2);
      makeReservation(hotel3, "Teresa Bennett", -2, 2);
      makeReservation(hotel3, "Sara Wood", -9, 5);
      makeReservation(hotel3, "Janice Barnes", -12, 4);
      makeReservation(hotel3, "Bryan Ross", 11, 5);
      makeReservation(hotel3, "Bruce Henderson", 14, 5);
      makeReservation(hotel3, "Grace Coleman", 8, 4);
      makeReservation(hotel3, "Judy Jenkins", 1, 4);
      makeReservation(hotel3, "Dylan Perry", 16, 6);
      makeReservation(hotel3, "Madison Powell", 8, 1);
      makeReservation(hotel3, "Beverly Long", -10, 3);
      makeReservation(hotel3, "Alan Patterson", 4, 6);
      makeReservation(hotel3, "Marilyn Hughes", -13, 6);
      makeReservation(hotel3, "Amber Flores", 16, 3);
      makeReservation(hotel3, "Danielle Washington", -19, 7);
      makeReservation(hotel3, "Gabriel Butler", 0, 5);
      makeReservation(hotel3, "Louis Simmons", -17, 4);

      Hotel hotel4 = addHotel("Duke's Bed and Breakfast", "Aspen", "CO", 4);
      makeReservation(hotel4, "Diana Foster", 8, 4);
      makeReservation(hotel4, "Abigail Gonzales", -18, 2);
      makeReservation(hotel4, "Vincent Bryant", -12, 4);
      makeReservation(hotel4, "Philip Alexander", -7, 2);
      makeReservation(hotel4, "Logan Russell", -7, 1);
      makeReservation(hotel4, "Alexis Griffin", -6, 3);
      makeReservation(hotel4, "Tiffany Diaz", -16, 2);
      makeReservation(hotel4, "Johnny Hayes", 8, 4);
   }

   private Hotel addHotel(String name, String city, String state, int numberofRooms) {
      Hotel hotel = new Hotel();
      hotel.setCity(city);
      hotel.setState(state);
      hotel.setName(name);
      hotel.setNumberOfRooms(numberofRooms);
      hotelRepository.save(hotel);
      return hotel;
   }

   private void makeReservation(Hotel hotel, String name, int daysAfterToday, int numberOfNights) {
      LocalDate arrivalDate = today.plusDays(daysAfterToday);
      LocalDate departureDate = arrivalDate.plusDays(numberOfNights);
      Reservation reservation = new Reservation(hotel, name, today.plusDays(daysAfterToday), numberOfNights);
      reservation.setReservationNumber(lastGivenResevationNumber.addAndGet(1));

      if (departureDate.isBefore(today)) {
         reservation.setStatus(Status.ARRIVED);
      }

      if (arrivalDate.isBefore(today) && departureDate.isAfter(today)) {
         reservation.setStatus(Status.CONFIRMED);
      }
      reservationRepository.save(reservation);
   }

}
