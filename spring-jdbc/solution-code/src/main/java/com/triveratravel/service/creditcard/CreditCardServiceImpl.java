package com.triveratravel.service.creditcard;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.triveratravel.service.CreditCardService;
import com.triveratravel.service.InvalidCardException;
import com.triveratravel.service.PaymentException;

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
@Service
public class CreditCardServiceImpl implements CreditCardService {

	public CreditCardType makePayment(String name, String creditCardNumber, BigDecimal amount)
			throws PaymentException, InvalidCardException {
		CreditCardValidator validator = new CreditCardValidator();
		CreditCardType type = validator.validateCard(creditCardNumber); // throws InvalidCardException when number is
																		// invalid or not supported
		if (type.equals(CreditCardType.MASTERCARD) || type.equals(CreditCardType.AMERICAN_EXPRESS))
			return type;
		throw new PaymentException("Authorization could not be completed, phone Card company", type, name);
	}
}
