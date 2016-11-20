package com.github.fabriciofx.apoo.conditional;

public final class EqualTo<T> implements Condition {
	private final Comparable<T> comparable;
	private final T object;

	public EqualTo(final Comparable<T> comparable, final T object) {
		this.comparable = comparable;
		this.object = object;
	}
	
	@Override
	public Boolean evaluate() {
		return comparable.compareTo(object) == 0;
	}
}
