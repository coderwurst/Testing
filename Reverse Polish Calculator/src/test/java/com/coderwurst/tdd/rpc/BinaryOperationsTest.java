package com.coderwurst.tdd.rpc;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BinaryOperationsTest {
	
	private Calculator calculator;
	
	@Before
	public void createCalculatorWithTwoValues() {
		calculator = new Calculator();
		calculator.setAccumulator(new BigDecimal(20));
		calculator.enter();
		calculator.setAccumulator(new BigDecimal(4));		
	}
	
	@Test
	public void testAdd() {
		calculator.execute("+");
		assertEquals(new BigDecimal(24), calculator.getAccumulator());
	}
	
	@Test
	public void testSubtract() {
		calculator.execute("-");
		assertEquals(new BigDecimal(16), calculator.getAccumulator());
	}
	
	@Test
	public void testMultiply() {
		calculator.execute("*");
		assertEquals(new BigDecimal(80), calculator.getAccumulator());
	}
	
	@Test
	public void testDivide() {
		calculator.execute("/");
		assertEquals(new BigDecimal(5), calculator.getAccumulator());
	}
	
}
