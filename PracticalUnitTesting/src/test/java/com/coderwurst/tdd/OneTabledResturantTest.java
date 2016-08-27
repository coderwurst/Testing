package com.coderwurst.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OneTabledResturantTest {

	private OneTabledResturant oneTableResturant = new OneTabledResturant();

	@Test
	public void testReturnBookableHours() {

		String result = oneTableResturant.printReservations();

		for (int count = 4; count < 12; count++) {
			assertTrue(result.contains(String.valueOf(count) + "pm"));
		}
	}

	@Test
	public void testMakeBooking() {

		for (int count = 4; count < 12; count++) {
			String result = oneTableResturant.makeBooking(count);

			assertEquals("Booking confirmed for " + count + "pm", result);
		}
	}

	@Test
	public void testReturnBookedHours() {

		String result = oneTableResturant.makeBooking(6);

		assertEquals("Booking confirmed for 6pm", result);

		String retry = oneTableResturant.makeBooking(6);

		assertTrue(retry.contains("Sorry, this slot is no longer available, available slots include"));
		assertFalse(retry.contains("6pm"));

	}

	@Test
	public void testRemoveBooking() {

		String result = oneTableResturant.makeBooking(10);

		assertEquals("Booking confirmed for 10pm", result);

		String remove = oneTableResturant.removeBooking(10);

		assertEquals("Booking removed for 10pm", remove);
	}

	@Test
	public void testInformUserBookingIsOutsideWorkingHours() {

		for (int count = 1; count < 4; count++) {
			String result = oneTableResturant.makeBooking(count);

			assertEquals("Opening times are 4pm - 12am", result);
		}
	}
}
