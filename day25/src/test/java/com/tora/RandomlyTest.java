package com.tora;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

import java.util.*;

@RunWith(org.junit.runners.Parameterized.class)
public final class RandomlyTest {
	private final String rndSeedMessage;
	private final long randomSeed;
	
	private Random rnd;
	private Map<String, Integer> reference, target;
	private List<Map.Entry<String, Integer>> items;

	@Parameters
	public static Collection<Object[]> getRunConfigurations() {
		List<Long> seeds = new ArrayList<Long>();
		seeds.add(-42L);
		seeds.add(314159265359L);
		seeds.add(271828182846L);
		for (int i = 0; i < 10; ++i) {
			seeds.add(System.currentTimeMillis() + 100*i);
		}

		List<Object[]> result = new ArrayList<Object[]>(seeds.size());
		for (long seed : seeds) {
			result.add(new Object[] { seed });
		}
		return result;
	}

	public RandomlyTest(long randomSeed) {
		this.randomSeed = randomSeed;
		this.rndSeedMessage = "Random seed: " + randomSeed;
	}

	@Test
	public void testAddRemove() {
		for (int i = 0; i < 1024; ++i) {
			Map.Entry<String, Integer> entry = items.get(rnd.nextInt(items.size()));
			switch (rnd.nextInt(2)) {
			case 0:
				if (reference.containsKey(entry.getKey())) {
					continue;
				}
				reference.put(entry.getKey(), entry.getValue());
				target.put(entry.getKey(), entry.getValue());
				break;
			case 1:
				Integer ref = reference.remove(entry.getKey());
				Integer trg = target.remove(entry.getKey());
				assertEquals(rndSeedMessage, ref, trg);
				break;
			}
			assertEquals(rndSeedMessage, reference.size(), target.size());
			assertEquals(rndSeedMessage, reference, target);
			assertEquals(rndSeedMessage, reference.entrySet(),
					target.entrySet());
			assertEquals(rndSeedMessage, reference.keySet(), target.keySet());
			Set<Integer> ref1 = new HashSet<Integer>(reference.values()), 
				trg1 = new HashSet<Integer>(target.values());
			assertEquals(rndSeedMessage, ref1, trg1);
		}
	}

	@Test
	public void testEntrySetIterator() {
		for (Map.Entry<String, Integer> e : items) {
			reference.put(e.getKey(), e.getValue());
			target.put(e.getKey(), e.getValue());
		}

		Iterator<Map.Entry<String, Integer>> itRef = reference.entrySet()
				.iterator(), itTrg = target.entrySet().iterator();

		while (true) {
			boolean refNext = itRef.hasNext(), trgNext = itTrg.hasNext();
			assertEquals(rndSeedMessage, refNext, trgNext);
			if (!refNext) {
				break;
			}

			switch (rnd.nextInt(2)) {
			case 0:
				itRef.next();
				itTrg.next();
				break;
			case 1:
				itRef.next();
				itTrg.next();
				itRef.remove();
				itTrg.remove();
				break;
			}

			assertEquals(rndSeedMessage, reference.size(), target.size());
		}
	}

	@Before
	public void setUp() {
		Map<String, Integer> elems = new TreeMap<String, Integer>();
		for (int i = 1; i <= 101; ++i) {
			elems.put(Integer.toString(i), 102 - i);
		}
		items = Collections
				.unmodifiableList(new ArrayList<Map.Entry<String, Integer>>(
						elems.entrySet()));

		rnd = new Random(randomSeed);
		reference = new HashMap<String, Integer>();
		target = new TreeMap<String, Integer>();
	}
}