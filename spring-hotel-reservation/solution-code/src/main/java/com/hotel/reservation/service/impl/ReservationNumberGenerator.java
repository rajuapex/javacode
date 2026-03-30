package com.hotel.reservation.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

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
@Component
@ApplicationScope
public class ReservationNumberGenerator {

	private AtomicInteger lastGivenResevationNumber;

	@PostConstruct
	protected void init() {
		lastGivenResevationNumber = new AtomicInteger(1000);
	}

	public Integer getNextReservationNumber() {
		return lastGivenResevationNumber.addAndGet(1);
	}

}
