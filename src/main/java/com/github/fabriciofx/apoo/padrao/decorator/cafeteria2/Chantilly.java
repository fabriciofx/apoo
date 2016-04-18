package com.github.fabriciofx.apoo.padrao.decorator.cafeteria2;

public final class Chantilly implements Ingrediente {
	private final Ingrediente ingrediente;

	public Chantilly(final Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public double preco() {
		return ingrediente.preco() + 0.50;
	}

	@Override
	public Ingrediente ingrediente() {
		return ingrediente;
	}
}
