package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public final class TesteIncrementado {
	@Test
	public void incrementa() {
		final int[] resultado = { 0, 1, 2, 3, 5, 7, 8 };
		final Sequencia ordenados = new Ordenado(
			new Numeros(2, 0, 1, 3, 8, 5, 7)
		);
		assertTrue(Arrays.equals(resultado, ordenados.numeros()));
	}
}
