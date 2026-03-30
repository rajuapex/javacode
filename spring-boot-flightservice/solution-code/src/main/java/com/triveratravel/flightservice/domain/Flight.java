package com.triveratravel.flightservice.domain;
/**
 * <p>
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 * <p>
 * Copyright (c) 2021 Trivera Technologies, LLC. http://www.triveratech.com
 *
 * 
 * </p>
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {
   @Id
   @GeneratedValue
   private long id;
   private String flightNumber;
   private String destination;

   public Flight() {
   }

   public Flight(String flightNumber, String destination) {
      this.flightNumber = flightNumber;
      this.destination = destination;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getFlightNumber() {
      return flightNumber;
   }

   public void setFlightNumber(String flightNumber) {
      this.flightNumber = flightNumber;
   }

   public String getDestination() {
      return destination;
   }

   public void setDestination(String destination) {
      this.destination = destination;
   }
}
