package com.github.fabriciofx.apoo.padroes.decorator.comando;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.github.fabriciofx.apoo.padroes.decorator.comando.Cut;

public final class TesteCut {
	@Test
	public void camposSemDelimitador() throws IOException {
		final String frase = "O carro custa 24 parcelas de R$ 500,00";
		final String O = new Cut(frase, 1).execute();
		final String custa = new Cut(frase, 3).execute();
		final String vinteQuatro = new Cut(frase, 4).execute();
		final String quinhentosReais = new Cut(frase, 8).execute();
		assertEquals("O", O);
		assertEquals("custa", custa);
		assertEquals("24", vinteQuatro);
		assertEquals("500,00", quinhentosReais);
	}

	@Test
	public void camposComDelimitador() throws IOException {
		final String frase = "O-carro-custa-24-parcelas-de-R$-500,00";
		final String O = new Cut(frase, "-", 1).execute();
		final String custa = new Cut(frase, "-", 3).execute();
		final String vinteQuatro = new Cut(frase, "-", 4).execute();
		final String quinhentosReais = new Cut(frase, "-", 8).execute();
		assertEquals("O", O);
		assertEquals("custa", custa);
		assertEquals("24", vinteQuatro);
		assertEquals("500,00", quinhentosReais);
	}
}
