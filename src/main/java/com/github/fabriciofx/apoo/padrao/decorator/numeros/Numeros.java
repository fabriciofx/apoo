package com.github.fabriciofx.apoo.padrao.decorator.numeros;

public final class Numeros implements Sequencia {
	private final int[] numeros;

	public Numeros(final int... numeros) {
		this.numeros = numeros;
	}

	@Override
	public int[] numeros() {
		return numeros;
	}
}
