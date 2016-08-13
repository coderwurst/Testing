package com.coderwurst.tdd;

public class RegexExercise {
	
	private String regexForDigits = ".*\\d.*";
	private String regexForThreeOrMoreDigits = ".*\\d{3,}.*";
	
	public String returnAllNulbersWithThreeOrMoreDigits(String test) {
		
		return null;		
	}
	
	public boolean containsDigits(String test) {
		if (test.matches(regexForDigits)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean containsThreeDigits(String test) {
		if (test.matches(regexForThreeOrMoreDigits)) {
			return true;
		} else {
			return false;
		}
	}

}
