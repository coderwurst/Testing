package com.coderwurst.tdd;

public class RegexExercise {

	private String regexForThreeOrMoreDigitsBesideEachOther = ".*\\d{3,}.*";
	private String result = "";

	public String returnAllNumbersWithThreeOrMoreDigits(String test) {

		while (test.length() >= 3) {
			// take substring of char 0 - 3
			String substring = test.substring(0, 3);
			// test regex
			if (containsThreeDigitsBesideEachOther(substring)) {
				// conc result to result string
				if (result.isEmpty()) {
					result = substring;
				} else {
					result = result + ", " + substring;
				}
				// remove added chars
				test = test.replace(substring, "");
				// test if necessary to repeat
				if (test.length() >= 3 && containsThreeDigitsBesideEachOther(test)) {
					returnAllNumbersWithThreeOrMoreDigits(test);
				}
				break;
			} else {
				test = test.substring(1);
			}
		}
		return result;
	}

	public boolean containsThreeDigitsBesideEachOther(String test) {
		if (test.matches(regexForThreeOrMoreDigitsBesideEachOther)) {
			return true;
		} else {
			return false;
		}
	}
}
