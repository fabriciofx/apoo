package com.github.fabriciofx.padroes.decorator.texto;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.github.fabriciofx.apoo.padroes.decorator.texto.ArquivoTexto;
import com.github.fabriciofx.apoo.padroes.decorator.texto.Texto;
import com.github.fabriciofx.apoo.padroes.decorator.texto.TextoAparado;
import com.github.fabriciofx.apoo.padroes.decorator.texto.TextoMaiusculo;

public final class TesteTexto {
	@Test
	public void aparadoEMaiusculo() {
		final String arquivo = TesteTexto.class.getResource("/texto.txt")
				.getFile();
		final Texto texto = new TextoMaiusculo(new TextoAparado(
				new ArquivoTexto(new File(arquivo))));
		assertEquals(texto.leia(),
				"FABRÍCIO BARROS CABRAL RUA DO ASQUER 1982 CAPITAL PEDRO DO BÓ");
	}
}
