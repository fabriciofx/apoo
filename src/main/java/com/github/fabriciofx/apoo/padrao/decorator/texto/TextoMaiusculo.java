package com.github.fabriciofx.apoo.padrao.decorator.texto;

import java.io.IOException;

public final class TextoMaiusculo implements Texto {
	private final Texto texto;

	public TextoMaiusculo(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() throws IOException {
		return texto.conteudo().toUpperCase();
	}
}
