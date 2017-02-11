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
	@Test
	public void aparadoEMaiusculo() throws IOException {
		final String eol = System.lineSeparator();
		final String conteudo = String.format(
			"%s%s%s%s%s",
			"  fabrício   barros      cabral    ",
			eol,
			"rua Do AsQUER 1982  	capital     ",
			eol,
			"Pedro		do     BÓ"	
		);
		final Texto texto = new TextoMaiusculo(
			new TextoLimpo(
				new TextoSimples(conteudo)
			)
		);		
		assertEquals(
			texto.conteudo(),
			String.format(
				"%s%s%s%s%s",
				"FABRÍCIO BARROS CABRAL",
				eol,
				"RUA DO ASQUER 1982 CAPITAL",
				eol,
				"PEDRO DO BÓ"
			)
		);
	}

	@Test
	public void aparadoMaiusculoEFiltrado() throws IOException {
		final String eol = System.lineSeparator();
		final String conteudo = String.format(
			"%s%s%s%s%s",
			"  fabrício   barros      cabral    ",
			eol,
			"rua Do AsQUER 1982  	capital     ",
			eol,
			"Pedro		do     BÓ"	
		);
		final Texto texto = new TextoFiltrado(
			new TextoMaiusculo(
				new TextoLimpo(
					new TextoSimples(conteudo)
				)
			),
			".*PEDRO.*"
		);
		assertEquals(texto.conteudo(), "PEDRO DO BÓ");
	}
	
	@Test
	public void aparadoEMaiusculoDoArquivo() throws IOException {
		final String eol = System.lineSeparator();
		final String arquivo = TesteTexto.class
			.getResource("/texto.txt")
			.getFile();
		final Texto texto = new TextoMaiusculo(
			new TextoLimpo(
					new TextoArquivado(
							new File(arquivo)
					)
			)
		);
		assertEquals(
			texto.conteudo(),
			String.format(
				"%s%s%s%s%s",
				"FABRÍCIO BARROS CABRAL",
				eol,
				"RUA DO ASQUER 1982 CAPITAL",
				eol,
				"PEDRO DO BÓ"
			)
		);
	}

	@Test
	public void aparadoMaiusculoEFiltradoDoArquivo() throws IOException {
		final String arquivo = TesteTexto.class
			.getResource("/texto.txt")
			.getFile();
		final Texto texto = new TextoFiltrado(
			new TextoMaiusculo(
				new TextoLimpo(
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
