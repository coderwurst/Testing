package com.coderwurst.sut;

public class StringReverse {
	
	public static String reverse(String s) {
		if (!(s instanceof String)) {
			throw new IllegalArgumentException("invalid argument type");
		}
		StringBuilder reversedString = new StringBuilder (s.length());
		for (int i =0; i < s.length();  i++) {
			reversedString.append(s.charAt(i));
		}
		
		return reversedString.reverse().toString();
	}
}
