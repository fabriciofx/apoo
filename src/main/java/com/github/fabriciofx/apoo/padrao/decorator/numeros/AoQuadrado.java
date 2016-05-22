package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import java.util.Arrays;

public final class AoQuadrado implements Sequencia {
	private final Sequencia origem;
	
	public AoQuadrado(final Sequencia origem) {
		this.origem = origem;
	}

	@Override
	public int[] numeros() {
		return Arrays.stream(origem.numeros()).map(n -> (n * n)).toArray();
	}
}
