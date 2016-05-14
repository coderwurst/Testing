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
	
	public void execute(String command) {
		Operation operation = null;
		if ("+".equals(command)) {
			operation = new AddOperation();		
		} else if ("-".equals(command)) {
			operation = new SubtractOperation();		
		} else if ("*".equals(command)) {
			operation = new MultiplicationOperation();		
		} else if ("/".equals(command)) {
			operation = new DivisionOperation();		
		} else if ("^".equals(command)) {
			operation = new SquareOperation();		
		}
		operation.apply(values);
	}

}
