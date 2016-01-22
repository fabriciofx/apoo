package com.github.fabriciofx.apoo.padroes.decorator.texto;


public final class TextoMinusculo implements Texto {
	private final Texto texto;

	public TextoMinusculo(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() {
		return texto.conteudo().toLowerCase();
	}
}
