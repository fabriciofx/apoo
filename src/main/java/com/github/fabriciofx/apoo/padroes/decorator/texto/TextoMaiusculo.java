package com.github.fabriciofx.apoo.padroes.decorator.texto;


public final class TextoMaiusculo implements Texto {
	private final Texto texto;

	public TextoMaiusculo(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() {
		return texto.conteudo().toUpperCase();
	}
}
