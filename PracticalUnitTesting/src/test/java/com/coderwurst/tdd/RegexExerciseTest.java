package com.coderwurst.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegexExerciseTest {

	RegexExercise regex = new RegexExercise();
	
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
	public void testReturnsTrueForStringWithThreeDigits() {
		boolean result = regex.containsThreeDigits("abc123");
		
		assertTrue(result);
	}
	
	@Test
	public void testReturnsFalseForStringWithLessThanThreeDigits() {
		boolean result = regex.containsThreeDigits("abc12");
		
		assertFalse(result);
	}
	
}
