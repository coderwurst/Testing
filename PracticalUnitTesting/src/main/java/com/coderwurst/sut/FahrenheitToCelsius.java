package com.coderwurst.sut;

/**
 * include both toFahrenheit and toCelcius methods
 * Paramerterised Tests to eliminate code repetition
 * 
 * example in book of how tests should look
 * 
 */
public class FahrenheitToCelsius {

	public static double convertCelsiusToFahrenheit(double value) {
		return (value * 1.8) + 32;
	}
	
	public static double convertFahrenheitToCelsius(double value) {
		return (value - 32) / 1.8;
	}
	
}
