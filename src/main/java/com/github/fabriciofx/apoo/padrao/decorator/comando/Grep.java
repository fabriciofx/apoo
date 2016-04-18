package com.github.fabriciofx.apoo.padrao.decorator.comando;

import java.io.IOException;

public final class Grep implements Comando {
	private final transient Comando comando;
	private final transient String padrao;

	public Grep(final Comando comando, final String padrao) {
		this.comando = comando;
		this.padrao = padrao;
	}

	@Override
	public String execute() throws IOException {
		final String[] linhas = comando.execute().split("\n");
		final StringBuilder filtrados = new StringBuilder();
		for (final String linha : linhas) {
			if (linha.matches(padrao)) {
				filtrados.append(linha);
			}
		}
		return filtrados.toString();
	}

	@Override
	public String toString() {
		try {
			return execute();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
