package com.github.fabriciofx.apoo.conditional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public final class GreaterThanTest {
	@Test
	public void compareIntegers() {
		final Condition gt = new GreaterThan<Integer>(
			new Integer(3),
			new Integer(2)
		);
		assertTrue(gt.evaluate());
	}

	@Test
	public void compareIntegers2() {
		final Condition gt = new GreaterThan<Integer>(
			new Integer(2),
			new Integer(3)
		);
		assertFalse(gt.evaluate());
	}
	
	@Test
	public void compareStrings() {
		final Condition gt = new GreaterThan<String>(
			new String("dois"),
			new String("tres")
		);
		assertFalse(gt.evaluate());
	}

}
