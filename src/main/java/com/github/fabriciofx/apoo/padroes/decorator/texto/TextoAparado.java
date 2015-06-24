package com.github.fabriciofx.apoo.padroes.decorator.texto;

public final class TextoAparado implements Texto {
	private final Texto texto;

	public TextoAparado(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String leia() {
		return texto.leia().trim().replaceAll("\\s+", " ");
	}
}
