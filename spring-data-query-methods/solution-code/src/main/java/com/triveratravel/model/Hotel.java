package com.triveratravel.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "HOTELS")
public class Hotel extends AbstractPersistable<Integer> {
   private String name;
   private String city;
   private String state;
   private int numberOfRooms;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public int getNumberOfRooms() {
      return numberOfRooms;
   }

   public void setNumberOfRooms(int numberOfRooms) {
      this.numberOfRooms = numberOfRooms;
   }

   @Override
   public String toString() {
      return String.format("Hotel [name=%s, city=%s, state=%s, numberOfRooms=%d]", name, city, state, numberOfRooms);
   }

}
