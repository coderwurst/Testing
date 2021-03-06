package com.coderwurst.tdd.rpc;

import java.math.BigDecimal;

public abstract class BinaryOperation implements Operation {

	@Override
	public void apply(OperandStack values) {
		BigDecimal value1 = values.peek();
		values.pop();
		BigDecimal value2 = values.peek();
		values.pop();
		values.replaceTop(calculate(value1, value2));
	}
	
	protected abstract BigDecimal calculate (BigDecimal value1, BigDecimal value2);

}
