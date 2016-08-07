package com.coderwurst.tdd;

public class PasswordValidator {
	
	public PasswordValidator(String password) {
		if (password.length() <= 5) {
			throw new IllegalArgumentException("Password must contain at least 5 characters");
		} else if (checkForDigits(password)) {
			throw new IllegalArgumentException("Password must contain at least 4 digits");
		} else if (password.contains("_")) {
			throw new IllegalArgumentException("Password cannot contain any underscores");
		} else if (checkForUpperAndLowerCase(password)) {
			throw new IllegalArgumentException("Password must contain lower and upper case chars");
		}
	}

	private boolean checkForUpperAndLowerCase(String password) {
		if (!hasUpperCase(password) || !hasLowerCase(password)) {
			return false;
		}
		return true;
	}
	
	private boolean hasUpperCase(CharSequence data) {
	    String password = String.valueOf(data);
	    boolean hasUppercase = !password.equals(password.toLowerCase());
	    return hasUppercase;
	}

	private boolean hasLowerCase(CharSequence data) {
	    String password = String.valueOf(data);
	    boolean hasLowercase = !password.equals(password.toUpperCase());
	    return hasLowercase;
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
