package com.coderwurst.tdd;

import java.util.LinkedHashMap;
import java.util.Map;

public class OneTabledResturant {

	private Map <String, String> bookableHours = new LinkedHashMap<String, String>();
	
	public OneTabledResturant() {
		System.out.println("Hello, the one table resturant is open for business...");
		System.out.println("The resturant is open from 4pm to midnight, daily...");
		System.out.println("You may book a table for today only...");
		
		setReservations();
		
		printReservations();
		
	}

	protected String printReservations() {
		StringBuilder reservations = new StringBuilder();
		System.out.println("The following reservations are still available:");
		for (String hour : bookableHours.keySet()) {
			System.out.println(hour + bookableHours.get(hour).toString());
			reservations.append(hour + bookableHours.get(hour).toString());
		}
		return reservations.toString();
		
	}
	
	protected String printAvailableSlots() {
		StringBuilder reservations = new StringBuilder();
		System.out.println("The following reservations are still available:");
		for (String hour : bookableHours.keySet()) {
			if ("available".equals(bookableHours.get(hour))) {
				System.out.println(hour);
				reservations.append(hour);
			}
		}
		return reservations.toString();

	}

	protected void setReservations() {
		for (int count = 4; count < 12; count++) {
			bookableHours.put(String.valueOf(count) + "pm", "available");
		}
	}

	protected String makeBooking(int booking) {

		String response;
		String request = String.valueOf(booking + "pm");
		String reservation = bookableHours.get(request);
		
		if (booking > 12 || booking < 4) {
			response = "Opening times are 4pm - 12am";
		} else if (reservation.equals("available")) {
			bookableHours.put(request, "booked");
			response = "Booking confirmed for " + request;
		} else {
			response = "Sorry, this slot is no longer available, available slots include:";
			printAvailableSlots();
		}
		return response;
	}

	public String removeBooking(int booking) {
		String response;
		String request = String.valueOf(booking + "pm");
		String reservation = bookableHours.get(request);
		
		if (reservation.equals("booked")) {
			bookableHours.put(request, "available");
			response = "Booking removed for " + request;
		} else {
			response = "This slot has not previously been booked";
			printAvailableSlots();
		}
		return response;
	}
	
}
