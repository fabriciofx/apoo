package com.github.fabriciofx.apoo.padrao.decorator.texto;

import java.io.IOException;

public final class TextoFiltrado implements Texto {
	private final Texto texto;
	private final String filtro;

	public TextoFiltrado(final Texto texto, final String filtro) {
		this.texto = texto;
		this.filtro = filtro;
	}

	@Override
	public String conteudo() throws IOException {
		final StringBuilder sb = new StringBuilder();
		final String[] linhas = texto.conteudo().split(System.lineSeparator());
		for (final String linha : linhas) {
			if (linha.matches(filtro)) {
				sb.append(linha);
			}
		}
		return sb.toString();
	}
}
