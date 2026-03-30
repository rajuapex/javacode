package com.triveratravel.service;

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
public class InvalidCardException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCardException() {
		super();
	}

	public InvalidCardException(String message) {
		super(message);
	}

	public InvalidCardException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCardException(Throwable cause) {
		super(cause);
	}

}
