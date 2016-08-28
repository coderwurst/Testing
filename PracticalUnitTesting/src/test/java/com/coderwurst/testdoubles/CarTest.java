package com.coderwurst.testdoubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class CarTest {

	private Car mySeat = Mockito.mock(Car.class);

	@Test
	public void testIfCarIsCar() {
		assertTrue(mySeat instanceof Car);
	}
	
	// more info to defaults @Mockito Javadocs org.mockito.internal.stubbing.defaultanswers
	@Test
	public void testDefaultBehaviourOfTestDouble() {
		assertFalse("new test doubles should return false as default for boolean values", mySeat.needsFuel());
		assertEquals("new test double should return 0.0 for double values", 0.0, mySeat.getEngineTemperature(), 0.0);
	}
	
	@Test
	public void testStubbing() {
		assertFalse("new test doubles should return false as default for boolean values", mySeat.needsFuel());
		
		when(mySeat.needsFuel()).thenReturn(true);
		
		assertTrue("double should return stubbed value", mySeat.needsFuel());
	}
	
	@Test (expected = RuntimeException.class)
	public void testExceptionHandlingBehaviour() {
		
		when(mySeat.getEngineTemperature()).thenThrow(new RuntimeException());
		
		mySeat.getEngineTemperature();		
	}
	
	@Test
	public void testToVerifySomeBehaviour() {
		mySeat.driveTo("Belfast");
		mySeat.needsFuel();
		
		verify(mySeat).driveTo("Belfast");
		verify(mySeat).needsFuel();
	}

}
