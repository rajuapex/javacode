package com.triveratravel.controller;

import java.time.LocalTime;

import lombok.Data;

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
@Data
public class FlightDTO {
	private String flightNumber;
	private String destination;
	private String destinationCode;
	private String airlineName;
	private LocalTime departureTime;

}
