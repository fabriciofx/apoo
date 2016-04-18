package com.github.fabriciofx.apoo.padrao.decorator.comando;

import java.io.IOException;
import java.nio.file.Path;

public final class Wc implements Comando {
	private final transient Fluxo fluxo;

	public Wc(final String arquivo) {
		this(new Fluxo.Arquivo(arquivo));
	}

	public Wc(final Path arquivo) {
		this(new Fluxo.Arquivo(arquivo));
	}

	public Wc(final Comando comando) {
		this(new Fluxo.Executavel(comando));
	}

	public Wc(final Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	@Override
	public String execute() throws IOException {
		int numLinhas, numPalavras = 0, numBytes = 0;
		final String[] linhas = fluxo.dados().split("\n");
		numLinhas = linhas.length;
		for (final String linha : linhas) {
			final String[] palavras = linha.trim().split("\\s+");
			numPalavras += palavras.length;
			for (final String palavra : palavras) {
				numBytes += palavra.getBytes().length;
			}
		}
		return String.format("%d %d %d", numLinhas, numPalavras, numBytes);
	}
}
