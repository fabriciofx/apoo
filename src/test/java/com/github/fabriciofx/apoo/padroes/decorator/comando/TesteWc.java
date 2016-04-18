package com.github.fabriciofx.apoo.padroes.decorator.comando;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.github.fabriciofx.apoo.padroes.decorator.comando.Wc;

public final class TesteWc {
	private SistemaArquivo sa;

	@Before
	public void inicializa() throws IOException {
		sa = new SistemaArquivo();
	}

	@Test
	public void arquivo() throws IOException {
		final String resultado = new Wc(sa.arquivo("/tmp/a.txt")).execute();
		assertEquals("1 1 5", resultado);
	}
}
