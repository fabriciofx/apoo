package com.github.fabriciofx.apoo.conditional;

import java.util.concurrent.Callable;

public final class If {
	private final boolean condition;

	public If(final boolean condition) {
		this.condition = condition;
	}

	@SuppressWarnings("unchecked")
	public <T> T isTrue(final Callable<T> callable) throws Exception {
		return condition ? callable.call() : (T) new Object();
	}

	public void isTrue(final Runnable runnable) throws Exception {
		@SuppressWarnings("unused")
		final int dummy = condition ? new Object() {
			public int hashCode() {
				runnable.run();
				return 0;
			};
		}.hashCode() : new Object() {
			public int hashCode() {
				return 0;
			};
		}.hashCode();
	}
}
