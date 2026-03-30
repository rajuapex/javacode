package com.triveratravel.service.creditcard;

import com.triveratravel.service.InvalidCardException;
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
public class CreditCardValidator {
	public CreditCardType validateCard(String number) throws InvalidCardException {
		String ccNumber = reformatNumber(number);
		applyLUHNFormula(ccNumber);
		return getCardType(ccNumber);
	}

	private String reformatNumber(String number) throws InvalidCardException {
		if (number == null)
			throw new InvalidCardException("Card number cannot be null");
		number = number.trim();
		number = number.replace(" ", "");
		number = number.replace("-", "");
		if ("".equals(number))
			throw new InvalidCardException("Card number cannot be an empty String");

		try {
			Double.parseDouble(number);
		} catch (NumberFormatException e) {
			throw new InvalidCardException("Number is nog a numeric value");
		}
		return number;
	}

	private CreditCardType getCardType(String number) throws InvalidCardException {
		// Visa first digit is 4, length 13, 15 or 16
		String prefix = number.substring(0, 1);
		if ("4".equals(prefix) && (number.length() == 13 || number.length() == 15 || number.length() == 16)) {
			return CreditCardType.VISA;
		}

		// Master Card prefix 51 ... 55 length 16
		prefix = number.substring(0, 2);
		if (prefix.compareTo("51") >= 0 && prefix.compareTo("55") <= 0 && number.length() == 16) {
			return CreditCardType.MASTERCARD;
		}

		// American Express prefix 34 or 37 length 15
		if (prefix.equals("34") || prefix.equals("37") && number.length() == 15) {
			return CreditCardType.AMERICAN_EXPRESS;
		}

		// DISCOVER prefix 60 length 16
		if (prefix.equals("60") && number.length() == 16) {
			return CreditCardType.DISCOVER;
		}

		// En Route prefix 2014 or 2149 length = 15
		prefix = number.substring(0, 4);
		if (prefix.equals("2014") || prefix.equals("2149") && number.length() == 15) {
			return CreditCardType.EN_ROUTE;
		}

		// Diner's Club prefix=300 ... 305 or 36 or 38 length=14
		prefix = number.substring(0, 2);
		String prefix3 = number.substring(0, 3);
		if ((prefix.equals("36") || prefix.equals("38")
				|| (prefix3.compareTo("300") >= 0 && prefix3.compareTo("305") <= 0)) && number.length() == 14) {
			return CreditCardType.DINERS_CLUB;
		}

		throw new InvalidCardException("Not a valid Credit Card, or Credit Card not supported");
	}

	private void applyLUHNFormula(String n) throws InvalidCardException {
		int j = n.length();
		String[] s1 = new String[j];
		for (int i = 0; i < n.length(); i++)
			s1[i] = "" + n.charAt(i);
		int checksum = 0;
		for (int i = s1.length - 1; i >= 0; i -= 2) {
			int k;
			if (i > 0) {
				k = Integer.valueOf(s1[i - 1]) * 2;
				if (k > 9) {
					String s = "" + k;
					k = Integer.valueOf(s.substring(0, 1)) + Integer.valueOf(s.substring(1));
				}
				checksum += Integer.valueOf(s1[i]) + k;
			} else
				checksum += Integer.valueOf(s1[0]);
		}
		if (!((checksum % 10) == 0)) {
			throw new InvalidCardException("LUHN check failed");
		}
	}

}
