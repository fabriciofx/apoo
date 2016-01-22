package com.github.fabriciofx.apoo.padroes.decorator.texto;

public final class TextoImprimivel implements Texto {
	private final Texto texto;

	public TextoImprimivel(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() {
		return texto.conteudo().replaceAll("[^\\p{Print}]", "");
	}
}
