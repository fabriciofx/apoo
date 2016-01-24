package com.github.fabriciofx.padroes.decorator.texto;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.github.fabriciofx.apoo.padroes.decorator.texto.Texto;
import com.github.fabriciofx.apoo.padroes.decorator.texto.TextoAparado;
import com.github.fabriciofx.apoo.padroes.decorator.texto.TextoArquivado;
import com.github.fabriciofx.apoo.padroes.decorator.texto.TextoFiltrado;
import com.github.fabriciofx.apoo.padroes.decorator.texto.TextoMaiusculo;

public final class TesteTexto {
	@Test
	public void aparadoEMaiusculo() {
		final String arquivo = TesteTexto.class.getResource("/texto.txt")
				.getFile();
		final Texto texto = new TextoMaiusculo(
				new TextoAparado(
						new TextoArquivado(
								new File(arquivo)
						)
				)
		);

		final String LS = System.lineSeparator();
		assertEquals(texto.conteudo(),
				"FABRÍCIO BARROS CABRAL" + LS
				+ "RUA DO ASQUER 1982 CAPITAL" + LS
				+ "PEDRO DO BÓ"
		);
	}

	@Test
	public void aparadoMaiusculoEFiltrado() {
		final String arquivo = TesteTexto.class.getResource("/texto.txt")
				.getFile();
		final Texto texto = new TextoFiltrado(
				new TextoMaiusculo(
						new TextoAparado(
								new TextoArquivado(
										new File(arquivo)
								)
						)
				),
				".*PEDRO.*"
		);

		assertEquals(texto.conteudo(), "PEDRO DO BÓ");
	}
}
