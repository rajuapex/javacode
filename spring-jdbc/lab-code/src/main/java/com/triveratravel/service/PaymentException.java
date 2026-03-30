package com.triveratravel.service;

import com.triveratravel.service.CreditCardService.CreditCardType;

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
@SuppressWarnings("serial")
public class PaymentException extends Exception {
	private CreditCardType creditCardType;
	private String name;

	public PaymentException() {
		super();
	}

	public PaymentException(String message, CreditCardType type, String name) {
		super(message);
		this.creditCardType = type;
		this.name = name;
	}

	public PaymentException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentException(Throwable cause) {
		super(cause);
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public String getName() {
		return name;
	}

}
