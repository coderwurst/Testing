package com.coderwurst.tdd.rpc;

import java.math.BigDecimal;

public abstract class UnaryOperation implements Operation {

	@Override
	public void apply(OperandStack values) {
		BigDecimal value1 = values.peek();
		values.pop();
		values.replaceTop(calculate(value1));
	}

	protected abstract BigDecimal calculate(BigDecimal value1);

}
