package com.coderwurst.tdd.rpc;

import java.math.BigDecimal;

public class MultiplicationOperation extends BinaryOperation {

	@Override
	protected BigDecimal calculate(BigDecimal value1, BigDecimal value2) {
		return value1.multiply(value2);
	}

}
