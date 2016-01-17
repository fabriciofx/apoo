package com.github.fabriciofx.apoo.padroes.decorator.cafeteria;

public final class Leite implements Ingrediente {
	private final Ingrediente ingrediente;
	
	public Leite(final Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public double preco() {
		return ingrediente.preco() + 0.80;
	}

	@Override
	public Ingrediente ingrediente() {
		return ingrediente;
	}
}
