package com.coderwurst.fizzbuzz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class FizzBuzzTest {
	
	// print 1 - 100
	// if x3 print FIZZ
	// if x5 print BUZZ
	// if x3 && x5 print FIZZ BUZZ
	
	FizzBuzz instance = new FizzBuzz();
	
	@Test
	public void testPrintOneToOneHundred() {
		ArrayList <String> result = instance.print();
		
		assertEquals("1", result.get(0));
		assertEquals("BUZZ", result.get(result.size() - 1));
	}
	
	@Test
	public void testFizzOnMultiplesOfThree() {
		ArrayList<String> result = instance.print();
		// test for first number divisible by 3
		assertEquals("FIZZ", result.get(2));
		// randomly select a number between 1 and 100
		int searchIndex = (int) (Math.random() * 99 + 1);
		// determine if divisible by 3 to use as test comparison
		while (searchIndex%3 != 0) {
			searchIndex = (int) (Math.random() * 99 + 1);
		}
		assertTrue(result.get(searchIndex -1).contains("FIZZ"));
	}
	
	@Test
	public void testBuzzOnMultiplesOfFive() {
		ArrayList<String> result = instance.print();
		// test for first number divisible by 5
		assertEquals("BUZZ", result.get(4));
		// randomly select a number between 1 and 100
		int searchIndex = (int) (Math.random() * 99 + 1);
		// determine if divisible by 5 to use as test comparison
		while (searchIndex%5 != 0) {
			searchIndex = (int) (Math.random() * 99 + 1);
		}
		assertTrue(result.get(searchIndex -1).contains("BUZZ"));
	}
	
	@Test
	public void testFizzBuzzOnMultiplesOfThreeAndFive() {
		ArrayList<String> result = instance.print();
		// test for first number divisible by 3 and 5
		assertEquals("FIZZ BUZZ", result.get(14));
		// randomly select a number between 1 and 100
		int searchIndex = (int) (Math.random() * 99 + 1);
		// determine if divisible by 3 & 5 to use as test comparison
		while ((searchIndex%3 != 0) || (searchIndex%5 != 0)) {
			searchIndex = (int) (Math.random() * 99 + 1);
		}
		assertEquals("FIZZ BUZZ", result.get(searchIndex -1));
	}

}
