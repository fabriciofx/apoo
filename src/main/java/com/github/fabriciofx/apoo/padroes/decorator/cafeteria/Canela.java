package com.github.fabriciofx.apoo.padroes.decorator.cafeteria;

public final class Canela implements Ingrediente {
	private final Ingrediente ingrediente;

	public Canela(final Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public double preco() {
		return ingrediente.preco() + 0.30;
	}
}
