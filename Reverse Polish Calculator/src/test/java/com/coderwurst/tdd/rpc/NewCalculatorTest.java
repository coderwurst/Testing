package com.coderwurst.tdd.rpc;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;;


public class NewCalculatorTest {
	
	Calculator calculator;
	
	@Before												// run before every test
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void testNewCalculatorHasAnAccumulatorOfZero() {
		assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
	}
	
	@Test
	public void testSetAccumulatorVlaue() {
		// given
		BigDecimal value = new BigDecimal(23);
		calculator.setAccumulator(value);
		// then
		assertEquals(value, calculator.getAccumulator());
	}

}
