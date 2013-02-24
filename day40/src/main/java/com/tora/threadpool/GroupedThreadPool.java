package com.tora.threadpool;

import java.util.*;
import java.util.concurrent.*;

public final class GroupedThreadPool extends AbstractExecutorService {
	public GroupedThreadPool(final int threadCount) {
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit)
			throws InterruptedException {
		return true;
	}

	@Override
	public void execute(Runnable command) {
		if (command instanceof OrderedTask) {
			execute((OrderedTask) command);
		} else {
			execute(new RunnableWrapper(command));
		}
	}

	public void execute(OrderedTask command) {
		command.run();
	}

	private final static class RunnableWrapper implements OrderedTask {
		private final Runnable runnable;

		RunnableWrapper(Runnable runnable) {
			this.runnable = runnable;
		}

		@Override
		public void run() {
			runnable.run();
		}

		@Override
		public boolean isCompatible(OrderedTask that) {
			return true;
		}
	}
}
