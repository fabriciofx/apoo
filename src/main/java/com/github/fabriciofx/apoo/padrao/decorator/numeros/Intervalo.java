package com.github.fabriciofx.apoo.padrao.decorator.numeros;

public final class Intervalo implements Sequencia {
	private final int inicio;
	private final int fim;

	public Intervalo(final int inicio, final int fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	@Override
	public int[] numeros() {
		final int[] array = new int[fim - inicio + 1];
		for (int i = 0; i < array.length; i++) {
			array[i] = inicio + i;
		}
		return array;
	}
}
