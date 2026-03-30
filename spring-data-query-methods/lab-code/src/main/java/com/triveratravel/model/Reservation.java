package com.triveratravel.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;

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
@Entity
@Table(name = "RESERVATIONS")
public class Reservation extends AbstractPersistable<Integer> {

   public enum Status {
      NEW, CONFIRMED, CONFLICT, CANCELLED, ARRIVED, NO_SHOW
   }

   @Column(name = "RESERVATION_NUMBER")
   private Integer reservationNumber;

   @Column(name = "NAME")
   private String nameOnReservation;
   private LocalDate arrivalDate;
   @Enumerated(EnumType.STRING)
   private Status status = Status.NEW;
   @Column(name = "NIGHTS")
   private int numberOfNights;

   @ManyToOne
   private Hotel hotel;

   public Reservation() {
      super();
   }

   public Reservation(Hotel hotel, String nameOnReservation, LocalDate arrivalDate, int numberOfNights) {
      super();
      this.hotel = hotel;
      this.nameOnReservation = nameOnReservation;
      this.arrivalDate = arrivalDate;
      this.numberOfNights = numberOfNights;
   }

   public Integer getReservationNumber() {
      return reservationNumber;
   }

   public void setReservationNumber(Integer reservationNumber) {
      this.reservationNumber = reservationNumber;
   }

   public String getNameOnReservation() {
      return nameOnReservation;
   }

   public void setNameOnReservation(String nameOnReservation) {
      this.nameOnReservation = nameOnReservation;
   }

   public LocalDate getArrivalDate() {
      return arrivalDate;
   }

   public void setArrivalDate(LocalDate arrivalDate) {
      this.arrivalDate = arrivalDate;
   }

   public Status getStatus() {
      return status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }

   public int getNumberOfNights() {
      return numberOfNights;
   }

   public void setNumberOfNights(int numberOfNights) {
      this.numberOfNights = numberOfNights;
   }

   @Override
   public String toString() {
      return String.format("Reservation [id=%d, reservationNumber=%d, nameOnReservation=%s, checkIn=%tD, status=%s, numberOfNights=%d]",
              getId(), reservationNumber, nameOnReservation, arrivalDate, status, numberOfNights);
   }
}
