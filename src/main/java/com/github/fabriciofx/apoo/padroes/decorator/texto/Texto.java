package com.github.fabriciofx.apoo.padroes.decorator.texto;

import java.io.IOException;

public interface Texto {
	String conteudo() throws IOException;

	final public class Simples implements Texto {
		private final String conteudo;

		public Simples(final String conteudo) {
			this.conteudo = conteudo;
		}

		@Override
		public String conteudo() throws IOException {
			return conteudo;
		}
	}
}
