package com.coderwurst.tdd.rpc;

import java.math.BigDecimal;

public class SquareOperation extends UnaryOperation {

	@Override
	protected BigDecimal calculate(BigDecimal value1) {
		return value1.multiply(value1);
	}
}
