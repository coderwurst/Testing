package com.coderwurst.sut;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {
	
	private final static int VALID_AMOUNT = 5;
	private final static String VALID_CURRENCY = "GBP";
	
	private static final Object [] getMoney() {
		return new Object [] {
				new Object [] { 10, "USD" },
				new Object [] { 22, "EUR"}
		};
	}
	
	private static final Object [] getInvalidAmount() {
		return new Integer [] [] { {-12345}, {-5}, {-1} };
	}
	
	private static final Object [] getInvalidCurrency() {
		return new String [] [] { { null }, { "" }	};
	}
	
	
	@Test
	@Parameters(method = "getMoney")
	public void testConstructorShouldSetAmountAndCurrency(int amount, String currency) {
		
		// given
		Money result = new Money(amount, currency);
		
		// then
		assertEquals("amount should equal: " + String.valueOf(amount) , amount, result.getAmount());
		assertEquals("currency should be in: " + currency, currency, result.getCurrency());
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	@Parameters(method = "getInvalidAmount")
	public void testConstructorShouldThrowIAEForInvalidAmount (int invalidAmount) {
		Money result = new Money (invalidAmount, VALID_CURRENCY);
	}
	
	@Test (expected=IllegalArgumentException.class)
	@Parameters(method = "getInvalidCurrency")
	public void testConstructorShouldThrowIAEForInvalidCurrency (String invalidCurrency) {
		Money result = new Money (VALID_AMOUNT, invalidCurrency);
	}

}
