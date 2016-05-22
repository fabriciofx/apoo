package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import java.util.Arrays;

public final class Ordenado implements Sequencia {
	private final Sequencia origem;

	public Ordenado(final Sequencia origem) {
		this.origem = origem;
	}

	@Override
	public int[] numeros() {
		return Arrays.stream(origem.numeros()).sorted().toArray();
	}
}
