package com.github.fabriciofx.apoo.padroes.decorator.texto;

import java.io.IOException;

public final class TextoMinusculo implements Texto {
	private final Texto texto;

	public TextoMinusculo(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() throws IOException {
		return texto.conteudo().toLowerCase();
	}
}
