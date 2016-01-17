package com.github.fabriciofx.apoo.padroes.decorator.cafeteria;

public final class Chocolate implements Ingrediente {
	private final Ingrediente ingrediente;

	public Chocolate(final Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public double preco() {
		return ingrediente.preco() + 0.70;
	}

	@Override
	public Ingrediente ingrediente() {
		return ingrediente;
	}
}
