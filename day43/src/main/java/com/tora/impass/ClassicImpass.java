package com.tora.impass;

import java.util.concurrent.Semaphore;

public final class ClassicImpass {
	public static void main(String[] args) {
		final Object l1 = new Object(), l2 = new Object();
		final Semaphore s = new Semaphore(0);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (l1) {
					s.acquireUninterruptibly();
					synchronized (l2) {
						System.out.println("TODO1");
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (l2) {
					s.release();
					synchronized (l1) {
						System.out.println("TODO2");
					}
				}
			}
		}).start();
	}
}
