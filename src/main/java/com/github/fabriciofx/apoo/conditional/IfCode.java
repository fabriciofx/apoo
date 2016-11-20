package com.github.fabriciofx.apoo.conditional;

import java.util.concurrent.Callable;

public final class IfCode {
	private final Condition condition;

	public IfCode(final Condition condition) {
		this.condition = condition;
	}

	@SuppressWarnings("unchecked")
	public <T> T isTrue(final Callable<T> callable) throws Exception {
		return condition.evaluate() ? callable.call() : (T) new Object();
	}

	public void isTrue(final Runnable runnable) throws Exception {
		@SuppressWarnings("unused")
		final int dummy = condition.evaluate() ? new Object() {
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
