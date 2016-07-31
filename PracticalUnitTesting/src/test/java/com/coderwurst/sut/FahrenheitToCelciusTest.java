package com.coderwurst.sut;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitToCelciusTest {

	private static final Object [] getCelsiusData() {
		return new Object [] {
				new Object [] { 0.00, 32.0 },
				new Object [] { 10, 50.0}, 
				new Object [] { 100, 212.0 }
		};
	}
	
	private static final Object [] getFahrenheitData() {
		return new Object [] {
				new Object [] { 0.00, -17.78 },
				new Object [] { 90, 32.22},
				new Object [] { 180, 82.22}
			};
	}
	
	
	@Test
	@Parameters(method = "getCelsiusData")
	public void testConversionToFahrenheit(double value, double result) {
		assertEquals(result, FahrenheitToCelsius.convertCelsiusToFahrenheit(value), 0.1);
	}
	
	@Test
	@Parameters(method = "getFahrenheitData")
	public void testConvertToCelsius(double value, double result) {
		assertEquals(result, FahrenheitToCelsius.convertFahrenheitToCelsius(value), 0.1);
	}
	
}
