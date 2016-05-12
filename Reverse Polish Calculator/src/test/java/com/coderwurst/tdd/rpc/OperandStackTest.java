package com.coderwurst.tdd.rpc;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OperandStackTest {

	OperandStack stack;

	@Before
	public void setup() {
		stack = new OperandStack();
	}

	@Test
	public void testNewOperandStackPeekreturnsZero() {

		assertEquals(BigDecimal.ZERO, stack.peek());
	}

	@Test
	public void testPushNewValueOntoStack() {
		BigDecimal value = new BigDecimal(12);
		stack.push(value);
		assertEquals(value, stack.peek());
	}

	@Test
	public void testReplaceValueAtTopOfStack() {
		stack.push(new BigDecimal(22));
		
		BigDecimal newValue = new BigDecimal(66);
		stack.replaceTop(newValue);
		assertEquals(newValue, stack.peek());
	}
	
	@Test
	public void testReplacingTopWithEmptyStack() {
		BigDecimal value = new BigDecimal(22);
		stack.replaceTop(value);
		assertEquals(value, stack.peek());
	}
	
	@Test
	public void testPoppingValueFromStack() {
		BigDecimal value1 = new BigDecimal(100);
		BigDecimal value2 = new BigDecimal(50);
		stack.push(value1);
		stack.push(value2);
		stack.pop();
		assertEquals(value1, stack.peek());
	}
	
	@Test
	public void testPoppingAnEmptyStack() {
		stack.pop();
		assertEquals(BigDecimal.ZERO, stack.peek());
	}

}
