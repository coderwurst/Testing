package com.coderwurst.tdd.rpc;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class UnaryOperationsTest {
	
	private Calculator calculator;
	
	@Before
	public void createCalculatorWithTwoValues() {
		calculator = new Calculator();
		calculator.setAccumulator(new BigDecimal(4));
		calculator.enter();		
	}
	
	@Test
	public void testSquared() {
		calculator.execute("^");
		assertEquals(new BigDecimal(16), calculator.getAccumulator());
	}
	
	@Test
	public void testAddCustomOperators() {
		// allow user to enter operator name
		// allow user to enter operator symbol
		// allows user to enter number of inputs
		// create new concrete class with Name+Operation, extending either Binary or Unary Abstract Class
	}
	
}
