package com.coderwurst.sut;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {
	
	private static final Object [] getTestString() {
		return new String [] [] { { "hello", "olleh" }, { "goodbye", "eybdoog" }, {"super dooper", "repood repus"}};
	}
	
	@Test
	@Parameters(method = "getTestString")
	public void testStringReverse(String testString, String expectedResult) {
		
		// given
		String result = StringReverse.reverse(testString);
					
		// then
		assertEquals("String should be reversed", expectedResult, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testReverseMethodWithIllegalArgument() {
		
		// given
		String result = StringReverse.reverse(null);
		
	}

}
