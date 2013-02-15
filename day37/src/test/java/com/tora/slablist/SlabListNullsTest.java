package com.tora.slablist;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SlabListNullsTest extends SlabListRandomTest {
	public SlabListNullsTest(int randSeed) {
		super(randSeed);
	}

	@Override
	Integer getRandomInt() {
		return null;
	}
}
