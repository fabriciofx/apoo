package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public final class TesteOrdenado {
	@Test
	public void ordena() {
		final int[] resultado = { 2, 6, 18, 66 };
		final Sequencia numeros = new Ordenado(
			new Incrementado(
				new AoQuadrado(
					new Pares(
						new Numeros(8, 3, 0, 5, 1, 4, 2, 7)
					)
				),
				2
			)
		);
		assertTrue(Arrays.equals(resultado, numeros.numeros()));
	}
}
