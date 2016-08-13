package com.coderwurst.tdd;

public class RegexExercise {
	
	private String regex = ".*\\d+.*";
	
	public String returnAllNulbersWithThreeOrMoreDigits(String test) {

		
		
		return null;		
	}
	
	public boolean containsDigits(String test) {
		if (test.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

}
