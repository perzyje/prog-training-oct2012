package com.tora.calculator;

import java.io.*;

public final class Calculator {
	private Calculator() {
	}

	public static void main(String[] args) throws IOException {
		Driver driver = new Driver(System.out);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			driver.consume(line);
		}
	}
}
