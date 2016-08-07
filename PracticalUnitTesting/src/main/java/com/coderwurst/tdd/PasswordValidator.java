package com.coderwurst.tdd;

public class PasswordValidator {
	
	private static final int MIN_LENGTH = 5;
	private static final String UNDERSCORE = "_";

	public PasswordValidator(String password) {
		if (password.length() <= MIN_LENGTH) {
			throw new IllegalArgumentException("Password must contain at least 5 characters");
		} else if (checkForDigits(password)) {
			throw new IllegalArgumentException("Password must contain at least 4 digits");
		} else if (password.contains(UNDERSCORE)) {
			throw new IllegalArgumentException("Password cannot contain any underscores");
		} else if (!hasUpperCase(password) || !hasLowerCase(password)) {
			throw new IllegalArgumentException("Password must contain lower and upper case chars");
		}
	}
	
	private boolean hasUpperCase(String password) {
	    return !password.equals(password.toLowerCase());
	}

	private boolean hasLowerCase(String password) {
	    return !password.equals(password.toUpperCase());
	}

	private boolean checkForDigits(String password) {
		int count = 0;
		for (int i = 0; i < password.length(); i++) {
		    if (Character.isDigit(password.charAt(i))) {
		        count++;
		    }
		}
		
		if (count <= 4) {
			return true;
		}		
		return false;
	}

}
