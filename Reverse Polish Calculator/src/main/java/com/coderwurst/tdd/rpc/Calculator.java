package com.coderwurst.tdd.rpc;

import java.math.BigDecimal;

public class Calculator {

	private OperandStack values = new OperandStack ();;
	
	public BigDecimal getAccumulator() {
			return values.peek();		// method to return value at top of stack (accumulator)
	}

	public void setAccumulator(BigDecimal value) {
		values.replaceTop(value);				// push new value on top of stack
	}

	public void enter() {
		// push current value in accumulator into the stack
		values.push(getAccumulator());		
	}

	public void drop() {
		// remove the value at the top of the stack
		values.pop();
	}

}
