package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import java.util.Arrays;

public final class Incrementado implements Sequencia {
	private final Sequencia origem;
	private final int valor;

	public Incrementado(final Sequencia origem, final int valor) {
		this.origem = origem;
		this.valor = valor;
	}

	@Override
	public int[] numeros() {
		return Arrays.stream(origem.numeros()).map(n -> (n + valor)).toArray();
	}
}
