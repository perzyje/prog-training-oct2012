package com.tora.calculator;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.util.Random;

public final class DriverTest {
	private ByteArrayOutputStream out;
	private Driver driver;

	@Test
	public void testDriver() {
		driver.consume("ADD 4\n");
		driver.consume("DIVIDE BY 5\n\r");
		driver.consume("MULTIPLY BY 2");
		driver.consume("SUBSTRACT 10");
		driver.consume("DISPLAY RESULT");
		driver.consume("ADD 2");
		driver.consume("DISPLAY RESULT");

		assertEquals(String.format("%.1f%n%.1f%n",
				(4.0d / 5.0d * 2.0d) - 10.0d,
				(4.0d / 5.0d * 2.0d) - 10.0d + 2.0d), out.toString());
	}

	@Test
	public void testDriverRandom() {
		Random r = new Random();
		int val;
		int now;
		double accumulator=0;
		StringBuilder sb =new StringBuilder();
		for (int i = 0; i < r.nextInt(); i++) {
			val=r.nextInt(5);
			switch (val) {
			case 0:
				//add
				now=r.nextInt();
				accumulator+=now;
				driver.consume("ADD "+now);
				break;
			case 1:
				//substract
				now=r.nextInt();
				accumulator-=now;
				driver.consume("SUBSTRACT "+now);
				break;
			case 2:
				//multiply
				now=r.nextInt();
				accumulator*=now;
				driver.consume("MULTIPLY BY "+now);
				break;
			case 3:
				//divide
				now=r.nextInt();
				accumulator/=now;
				driver.consume("DIVIDE BY "+now);
				break;
			case 4:
				sb.append(accumulator+"\n");
				driver.consume("DISPLAY RESULT");
				break;
			
			default:
				break;
			}
		}
		sb.append(accumulator+"\n");
		driver.consume("DISPLAY RESULT");
		assertEquals(sb.toString(),out.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnknownCommand() {
		driver.consume("FAKE COMMAND");
	}

	@Test(expected = NullPointerException.class)
	public void testNullLine() {
		driver.consume(null);
	}

	@Before
	public void setUp() {
		out = new ByteArrayOutputStream();
		driver = new Driver(out);
	}
}