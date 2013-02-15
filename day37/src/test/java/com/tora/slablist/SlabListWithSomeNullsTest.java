package com.tora.slablist;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SlabListWithSomeNullsTest extends SlabListRandomTest {
	public SlabListWithSomeNullsTest(int randSeed) {
		super(randSeed);
	}

	@Override
	Integer getRandomInt() {
		Integer result = Integer.valueOf(rnd.nextInt(256));
		return 42 == result ? null : result;
	}
}
