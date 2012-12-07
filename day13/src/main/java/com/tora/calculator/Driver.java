package com.tora.calculator;

import java.io.OutputStream;

final class Driver {
	private double value;
	private OperationFactory operationFactory;

	public Driver(OutputStream dest) {
		this.value = 0.0;
		this.operationFactory = new OperationFactory(dest);
	}

	public void consume(String string) {
		value = operationFactory.getOperation(string).execute(value, string);
	}
}
