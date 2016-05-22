package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public final class TesteComposicao {
	@Test
	public void compoe() {
		final int[] resultado = { 100, 101, 102, 103, 200 };
		final Sequencia incrementados = new Incrementado(
			new Numeros(0, 1, 2, 3, 100),
			100
		);
		assertTrue(Arrays.equals(resultado, incrementados.numeros()));
	}
}
