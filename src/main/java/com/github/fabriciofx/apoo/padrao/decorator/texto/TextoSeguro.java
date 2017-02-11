package com.github.fabriciofx.apoo.padrao.decorator.texto;

import java.io.IOException;

public final class TextoSeguro implements Texto {
	private final Texto origem;
	
	public TextoSeguro(final Texto origem) {
		this.origem = origem;
	}
	
	@Override
	public String conteudo() throws IOException {
		if (origem == null || origem.conteudo().isEmpty()) {
			throw new IOException("texto inválido: null ou vazio");
		}
		return origem.conteudo();
	}
}
