package com.tora.maps;

import org.junit.*;
import java.util.*;
import java.util.concurrent.*;
import static org.junit.Assert.*;

public final class MultiThreadedHashmap {
	private final static int PARALLELIZATION = 2*Runtime.getRuntime().availableProcessors()+1;
	
	private ExecutorService runners;
	private Map<Integer, Integer> map;
	private int sum;
	
	@Test
	@Ignore
	public void testOne() throws Exception {
		for (int i = 0; i < PARALLELIZATION; ++i) {
			runners.execute(new Runnable() {
				@Override
				public void run() {
					Random r = new Random();
					for (int i = 0; i < 10*1024*1024; ++i) {
						map.remove(getValue(r));
						map.put(getValue(r), getValue(r));
					}
				}
			});
		}
		runners.shutdown();
		assertTrue(runners.awaitTermination(30, TimeUnit.SECONDS));
	}
	
	@Test
	@Ignore
	public void testTwo() throws Exception {
		final Random r = new Random();
		for (int i = 0; i < PARALLELIZATION; ++i) {
			runners.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10*1024*1024; ++i) {
						map.remove(getValue(r));
						map.put(getValue(r), getValue(r));
					}
				}
			});
		}
		runners.shutdown();
		assertTrue(runners.awaitTermination(30, TimeUnit.SECONDS));
	}
	
	@Test
	@Ignore
	public void testThree() throws Exception {
		for (int i = 0; i < PARALLELIZATION; ++i) {
			runners.execute(new Runnable() {
				@Override
				public void run() {
					Random r = new Random();
					int sum = 0;
					for (int i = 0; i < 10*1024*1024; ++i) {
						sum += map.get(getValue(r));
					}
					assertEquals(MultiThreadedHashmap.this.sum, sum);
				}
			});
		}
		runners.shutdown();
		assertTrue(runners.awaitTermination(30, TimeUnit.SECONDS));
	}

	@Before
	public void setUp() {
		runners = Executors.newFixedThreadPool(PARALLELIZATION);
//		runners = Executors.newSingleThreadExecutor();
		map = new HashMap<Integer, Integer>();
		
		Random r = new Random();
		sum = 0;
		for (int i = 0; i < 1024; ++i) {
			Integer value = getValue(r);
			map.put(getValue(r), value);
			sum += value;
		}
	}
	
	private Integer getValue(Random r) {
		return Integer.valueOf( (int) (r.nextGaussian() * 100) % 10);
	}
}
