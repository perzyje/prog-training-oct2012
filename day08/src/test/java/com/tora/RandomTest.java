package com.tora;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public final class RandomTest {
	private static final int ITERATION_PER_TEST = 32;
	private Random rnd;
	private List<Integer> lst, ref;
	private final int randSeed;

	@Parameters
	public static Collection<Integer[]> getSeeds() {
		List<Integer[]> result = new ArrayList<Integer[]>();
		result.add(new Integer[] { 1396385716 });
		result.add(new Integer[] { -1287302644 });
		result.add(new Integer[] { +1415926535 });
		result.add(new Integer[] { -1582786997 });
		result.add(new Integer[] { -337032840 });

		Random r = new Random();
		for (int i = 0; i < 10; ++i) {
			result.add(new Integer[] { r.nextInt() });
		}

		return result;
	}

	public RandomTest(int randSeed) {
		this.randSeed = randSeed;
	}

	@Test
	public void testAdd() throws Throwable {
		try {
			int iteration = 1 + rnd.nextInt(ITERATION_PER_TEST);
			for (int i = 0; i < iteration; ++i) {
				int position = ref.isEmpty() ? 0 : rnd.nextInt(ref.size());
				Integer value = getRandomInt();
				lst.add(position, value);
				ref.add(position, value);
				assertEquals(ref, lst);
			}
		} catch (Throwable t) {
			throw new Throwable("Exception during test with seed " + randSeed,
					t);
		}
	}

	@Test
	public void testSet() throws Throwable {
		try {
			initListsRandomly();
			for (int i = 0; i < ref.size(); ++i) {
				Integer value = getRandomInt();
				lst.set(i, value);
				ref.set(i, value);
				assertEquals(ref, lst);
			}
		} catch (Throwable t) {
			throw new Throwable("Exception during test with seed " + randSeed,
					t);
		}
	}

	private void initListsRandomly() {
		int iteration = 1 + rnd.nextInt(ITERATION_PER_TEST);
		for (int i = 0; i < iteration; ++i) {
			Integer value = getRandomInt();
			lst.add(value);
			ref.add(value);
		}
	}

	@Test
	public void testGet() throws Throwable {
		try {
			initListsRandomly();
			for (int i = 0; i < ref.size(); ++i) {
				assertEquals(ref.get(i), lst.get(i));
			}
		} catch (Throwable t) {
			throw new Throwable("Exception during test with seed " + randSeed,
					t);
		}
	}

	@Test
	public void testRemove() throws Throwable {
		try {
			initListsRandomly();
			while (!ref.isEmpty()) {
				int position = rnd.nextInt(ref.size());
				assertEquals(ref.remove(position), lst.remove(position));
				assertEquals(ref, lst);
			}
		} catch (Throwable t) {
			throw new Throwable("Exception during test with seed " + randSeed,
					t);
		}
	}

	@Test
	public void testIteratorUp() throws Throwable {
		try {
			initListsRandomly();
			ListIterator<Integer> iRef = ref.listIterator(), iLst = lst
					.listIterator();
			while (true) {
				assertEquals(iRef.hasNext(), iLst.hasNext());
				assertEquals(iRef.nextIndex(), iLst.nextIndex());
				if (!iRef.hasNext()) {
					break;
				}

				assertEquals(iRef.next(), iLst.next());
				Integer value = getRandomInt();
				iRef.set(value);
				iLst.set(value);

				if (null != value && 0 == value % 8) {
					value = getRandomInt();
					iRef.add(value);
					iLst.add(value);
				}

				assertEquals(ref, lst);
			}

			ref.clear();
			lst.clear();

			initListsRandomly();
			iRef = ref.listIterator();
			iLst = lst.listIterator();
			while (true) {
				assertEquals(iRef.hasNext(), iLst.hasNext());
				if (!iRef.hasNext()) {
					break;
				}
				assertEquals(iRef.next(), iLst.next());
				iRef.remove();
				iLst.remove();
				assertEquals(ref, lst);
			}
		} catch (Throwable t) {
			throw new Throwable("Exception during test with seed " + randSeed,
					t);
		}
	}

	@Test
	public void testIteratorDown() throws Throwable {
		try {
			initListsRandomly();
			ListIterator<Integer> iRef = ref.listIterator(ref.size()), iLst = lst
					.listIterator(lst.size());
			while (true) {
				assertEquals(iRef.hasPrevious(), iLst.hasPrevious());
				assertEquals(iRef.previousIndex(), iLst.previousIndex());
				if (!iRef.hasPrevious()) {
					break;
				}

				assertEquals(iRef.previous(), iLst.previous());
				Integer value = getRandomInt();
				iRef.set(value);
				iLst.set(value);

				if (null != value && 0 == value % 8) {
					value = getRandomInt();
					iRef.add(value);
					iLst.add(value);
				}

				assertEquals(ref, lst);
			}

			ref.clear();
			lst.clear();
			initListsRandomly();
			iRef = ref.listIterator(ref.size());
			iLst = lst.listIterator(lst.size());
			while (true) {
				assertEquals(iRef.hasPrevious(), iLst.hasPrevious());
				if (!iRef.hasPrevious()) {
					break;
				}

				assertEquals(iRef.previous(), iLst.previous());
				iRef.remove();
				iLst.remove();
				assertEquals(ref, lst);
			}
		} catch (Throwable t) {
			throw new Throwable("Exception during test with seed " + randSeed,
					t);
		}
	}

	@Test
	public void testRemoveAll() throws Throwable {
		try {
			initListsRandomly();
			while (!ref.isEmpty()) {
				Collection<Integer> c = Arrays.asList(ref.get(rnd.nextInt(ref
						.size())));
				assertEquals(ref.removeAll(c), lst.removeAll(c));
				assertEquals(ref, lst);
			}
		} catch (Throwable t) {
			throw new Throwable("Exception during test with seed " + randSeed,
					t);
		}
	}

	@Before
	public void setUp() {
		lst = new DoubleLinkedList<Integer>();
		ref = new LinkedList<Integer>();
		rnd = new Random(randSeed);
	}

	Integer getRandomInt() {
		return Integer.valueOf(rnd.nextInt(256));
	}
}
