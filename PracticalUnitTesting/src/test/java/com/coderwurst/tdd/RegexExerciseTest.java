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
				new Object [] {"123"},
				new Object [] {"somewhere154digit"},
				new Object [] {"morethan123456789"}
		};
	}
	
	public Object [] invalidTestStrings() {
		return new Object [] {
				new Object [] {"blah blah"},
				new Object [] {"noDigitsHere"},
				new Object [] {"one two three"}
		};
	}
	
	@Test
	public void testReturnsTrueWhenStringContainsDigits() {
		boolean result = regex.containsDigits("abc123");
		
		assertTrue(result);
	}
	
	@Test
	public void testReturnsFalseWhenStringContainsDigits() {
		boolean result = regex.containsDigits("abcdef");
		
		assertFalse(result);
	}
	
	@Test
	@Parameters(method = "validTestStrings")
	public void testReturnsTrueForStringWithThreeDigits(String test) {
		boolean result = regex.containsThreeDigits(test);
		
		assertTrue(result);
	}
	
	@Test
	@Parameters(method = "invalidTestStrings")
	public void testReturnsFalseForStringWithLessThanThreeDigits(String test) {
		boolean result = regex.containsThreeDigits(test);
		
		assertFalse(result);
	}
	
}
