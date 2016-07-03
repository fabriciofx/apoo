package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public final class TesteAoQuadrado {
	@Test
	public void quadrados() {
		final int[] resultado = { 0, 1, 4, 9, 16, 25 };
		final Sequencia quadrados = new AoQuadrado(new Intervalo(0, 5));
		assertTrue(Arrays.equals(resultado, quadrados.numeros()));
	}
}
