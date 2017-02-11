package com.github.fabriciofx.apoo.padrao.decorator.texto;

import java.io.IOException;

public final class TextoLimpo implements Texto {
	private final Texto texto;

	public TextoLimpo(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() throws IOException {
		final String eol = System.lineSeparator();
		return texto.conteudo()
			.replaceAll(
				String.format("^\\s+|\\s+$|\\s*(%s)\\s*|(\\s)\\s*", eol),
				"$1$2"
			)
			.replaceAll("[\\t\\f]+", " ");
	}
}
