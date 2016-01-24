package com.github.fabriciofx.apoo.padroes.decorator.texto;

public final class TextoAparado implements Texto {
	private final Texto texto;

	public TextoAparado(final Texto texto) {
		this.texto = texto;
	}

	@Override
	public String conteudo() {
		return texto.conteudo()
				.replaceAll("^\\s+|\\s+$|\\s*(" + System.lineSeparator()
						+ ")\\s*|(\\s)\\s*", "$1$2")
				.replaceAll("[\\t\\f]+", " ");
	}
}
