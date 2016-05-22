package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

public final class TesteIntervaloDoArquivo {
	private static final String ARQUIVO = TesteIntervaloDoArquivo.class
			.getResource("/numeros.txt").getFile();

	@Test
	public void leia() {
		final int[] numeros = { 2, 4, 5, 7, 8, 0, 1, 3 };
		final Sequencia sequencia = new IntervaloDoArquivo(new File(ARQUIVO));
		assertTrue(Arrays.equals(numeros, sequencia.numeros()));
	}
}
