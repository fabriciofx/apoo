package com.github.fabriciofx.apoo.padrao.decorator.texto;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.github.fabriciofx.apoo.padrao.decorator.texto.Texto;
import com.github.fabriciofx.apoo.padrao.decorator.texto.TextoLimpo;
import com.github.fabriciofx.apoo.padrao.decorator.texto.TextoArquivado;
import com.github.fabriciofx.apoo.padrao.decorator.texto.TextoFiltrado;
import com.github.fabriciofx.apoo.padrao.decorator.texto.TextoMaiusculo;

public final class TesteTexto {
	private static final String LS = System.lineSeparator();
	private static final String TEXTO =
			"  fabrício   barros      cabral    " + LS
			+ "rua Do AsQUER 1982  	capital     " + LS
			+ "Pedro		do     BÓ";	
	private static final String ARQUIVO = TesteTexto.class
			.getResource("/texto.txt").getFile();

	@Test
	public void aparadoEMaiusculo() throws IOException {
		final Texto texto = new TextoMaiusculo(
				new TextoLimpo(
						new TextoSimples(TEXTO)
				)
		);
		
		assertEquals(texto.conteudo(),
				"FABRÍCIO BARROS CABRAL" + LS
				+ "RUA DO ASQUER 1982 CAPITAL" + LS
				+ "PEDRO DO BÓ"
		);
	}

	@Test
	public void aparadoMaiusculoEFiltrado() throws IOException {
		final Texto texto = new TextoFiltrado(
				new TextoMaiusculo(
						new TextoLimpo(
								new TextoSimples(TEXTO)
						)
				),
				".*PEDRO.*"
		);

		assertEquals(texto.conteudo(), "PEDRO DO BÓ");
	}
	
	@Test
	public void aparadoEMaiusculoDoArquivo() throws IOException {
		final Texto texto = new TextoMaiusculo(
				new TextoLimpo(
						new TextoArquivado(
								new File(ARQUIVO)
						)
				)
		);
		
		assertEquals(texto.conteudo(),
				"FABRÍCIO BARROS CABRAL" + LS
				+ "RUA DO ASQUER 1982 CAPITAL" + LS
				+ "PEDRO DO BÓ"
		);
	}

	@Test
	public void aparadoMaiusculoEFiltradoDoArquivo() throws IOException {
		final Texto texto = new TextoFiltrado(
				new TextoMaiusculo(
						new TextoLimpo(
								new TextoArquivado(
										new File(ARQUIVO)
								)
						)
				),
				".*PEDRO.*"
		);

		assertEquals(texto.conteudo(), "PEDRO DO BÓ");
	}
}
