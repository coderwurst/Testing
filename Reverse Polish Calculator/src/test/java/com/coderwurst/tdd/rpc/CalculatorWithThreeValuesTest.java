package com.coderwurst.tdd.rpc;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CalculatorWithThreeValuesTest {

	Calculator calculator;
	private BigDecimal value1;
	private BigDecimal value2;
	private BigDecimal value3;

	@Before // run before every test
	public void setupCalculatorWithThreeValues() {
		calculator = new Calculator();

		value1 = new BigDecimal(1);
		value2 = new BigDecimal(22);
		value3 = new BigDecimal(33);

		// add these 3 values to the stack
		calculator.setAccumulator(value1);
		calculator.enter();
		calculator.setAccumulator(value2);
		calculator.enter();
		calculator.setAccumulator(value3);

	}

	@Test
	public void testAccumulatorAfterPushingThreeValues() {
		assertEquals (value3, calculator.getAccumulator());
	}
	
	@Test
	public void testAccumulatorAfterSingleDrop() {
		calculator.drop();
		
		assertEquals (value2, calculator.getAccumulator());
	}
	
	@Test
	public void testAccumulatorAfterDroppingTwice() {
		calculator.drop();
		calculator.drop();
		
		assertEquals (value1, calculator.getAccumulator());
	}


}
