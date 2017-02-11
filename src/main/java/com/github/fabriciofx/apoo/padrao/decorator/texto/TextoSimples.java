package com.github.fabriciofx.apoo.padrao.decorator.texto;

import java.io.IOException;

public final class TextoSimples implements Texto {
	private final String conteudo;

	public TextoSimples(final String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String conteudo() throws IOException {
		return conteudo;
	}
}
