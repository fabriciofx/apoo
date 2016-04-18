package com.github.fabriciofx.apoo.padrao.decorator.texto;

import java.io.IOException;

public final class TextoImprimivel implements Texto {
	private final Texto texto;

	public TextoImprimivel(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() throws IOException {
		return texto.conteudo().replaceAll("[^\\p{Print}]", "");
	}
}
