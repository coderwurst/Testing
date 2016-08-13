package com.coderwurst.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class RegexExerciseTest {

	RegexExercise regex = new RegexExercise();
	
	public Object [] validTestStrings() {
		return new Object [] {
				new Object [] {"123", "123"},
				new Object [] {"somewhere154digit", "154"},
				new Object [] {"cdefg 345 12bb23", "345"},
				new Object [] {"cdefg 345 12bbb33 678tt", "345, 678"},
				new Object [] {"morethan123456789", "123, 456, 789"}
		};
	}
	
	public Object [] invalidTestStrings() {
		return new Object [] {
				new Object [] {"blah blah"},
				new Object [] {"noDigitsHere"},
				new Object [] {"abc 12"},
				new Object [] {"one two three"}
		};
	}
	
	@Test
	@Parameters(method = "validTestStrings")
	public void testReturnsTrueForStringWithThreeDigits(String test, String value) {
		boolean result = regex.containsThreeDigitsBesideEachOther(test);
		
		assertTrue(result);
	}
	
	@Test
	@Parameters(method = "invalidTestStrings")
	public void testReturnsFalseForStringWithLessThanThreeDigits(String test) {
		boolean result = regex.containsThreeDigitsBesideEachOther(test);
		
		assertFalse(result);
	}
	
	@Test
	@Parameters(method = "validTestStrings")
	public void testRreturnAllNumbersWithThreeOrMoreDigits(String test, String value) {
		String result = regex.returnAllNumbersWithThreeOrMoreDigits(test);
		
		assertEquals(value, result);
	}
	
}
