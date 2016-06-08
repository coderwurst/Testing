package com.coderwurst.fizzbuzz;

import java.util.ArrayList;

public class FizzBuzz {

	private static final int LIST_SIZE = 100;
	private static final String FIZZ = "FIZZ";
	private static final String BUZZ = "BUZZ";

	public ArrayList <String> print() {

		int value;
		ArrayList<String> outputValue = new ArrayList<String>();
		
		for (value = 1; value <= LIST_SIZE; value ++) {
			if ((value % 3) == 0 && (value % 5) == 0) {
				System.out.println(FIZZ + " " + BUZZ);
				outputValue.add(FIZZ + " " + BUZZ);
			} else if ((value % 3) == 0) {
				System.out.println(FIZZ);
				outputValue.add(FIZZ);
			} else if ((value % 5) == 0) {
				System.out.println(BUZZ);
				outputValue.add(BUZZ);
			} else {
				System.out.println(value);
				outputValue.add(String.valueOf(value));
			}
		}
		
		return outputValue;
	}

}
