package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import java.util.Arrays;

public final class Pares implements Sequencia {
	private final Sequencia origem;

	public Pares(final Sequencia origem) {
		this.origem = origem;
	}

	@Override
	public int[] numeros() {
		return Arrays.stream(origem.numeros()).filter(n -> (n % 2 == 0))
				.toArray();
	}
}
