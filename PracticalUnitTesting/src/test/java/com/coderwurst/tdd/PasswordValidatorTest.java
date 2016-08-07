package com.coderwurst.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

	public Object [] passwords() {
		return new Object [] {
				new Object [] {"helloPassword"},
				new Object [] {"password1"},
				new Object [] {"updateThisPassword"}
		};
	}
	
	public Object [] invalidLength() {
		return new Object [] {
				new Object [] {"hello"},
				new Object [] {"boo"},
				new Object [] {"hoo"}
		};
	}
	
	public Object [] invalidDigits() {
		return new Object [] {
				new Object [] {"hel1o"},
				new Object [] {"12"},
				new Object [] {"Name123"}
		};
	}
	
	public Object [] invalidUnderscore() {
		return new Object [] {
				new Object [] {"this12PasswordIs_44"},
				new Object [] {"eclipse_1234"},
				new Object [] {"Jonny5434_"}
		};
	}
	
	public Object [] invalidCase() {
		return new Object [] {
				new Object [] {"this12passwordis44"},
				new Object [] {"ECLIPSE"},
				new Object [] {"jonny5434"}
		};
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method = "invalidLength")
	public void testPasswordIsOfAppropriateLength(String invalidPassword) {
		PasswordValidator password = new PasswordValidator(invalidPassword);
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method = "invalidDigits")
	public void testPasswordShouldContainAtLeastFourDigits(String invalidPassword) {
		PasswordValidator password = new PasswordValidator(invalidPassword);
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method = "invalidUnderscore")
	public void testPasswordShouldNotContainAnyUnderscores(String invalidPassword) {
		PasswordValidator password = new PasswordValidator(invalidPassword);
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method = "invalidCase")
	public void testPasswordShouldContainUpperAndLowerCase(String invalidPassword) {
		PasswordValidator password = new PasswordValidator(invalidPassword);
	}
	
	
}
