package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public final class TestePares {
	@Test
	public void apenasPares1() {
		final int[] resultado = { 2, 4 };
		final Sequencia pares = new Pares(
			new Intervalo(1, 5)
		);
		assertTrue(Arrays.equals(resultado, pares.numeros()));
	}

	@Test
	public void apenasPares2() {
		final int[] resultado = { 2, 4 };
		final Sequencia pares = new Pares(
			new Intervalo(1, 4)
		);
		assertTrue(Arrays.equals(resultado, pares.numeros()));
	}

	@Test
	public void apenasPares3() {
		final int[] resultado = { 2, 4 };
		final Sequencia pares = new Pares(
			new Intervalo(2, 5)
		);
		assertTrue(Arrays.equals(resultado, pares.numeros()));
	}

	@Test
	public void apenasPares4() {
		final int[] resultado = { 2, 4, 6 };
		final Sequencia pares = new Pares(
			new Intervalo(2, 6)
		);
		assertTrue(Arrays.equals(resultado, pares.numeros()));
	}
}
