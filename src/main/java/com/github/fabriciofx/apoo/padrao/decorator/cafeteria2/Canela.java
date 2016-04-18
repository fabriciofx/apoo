package com.github.fabriciofx.apoo.padrao.decorator.cafeteria2;

public final class Canela implements Ingrediente {
	private final Ingrediente ingrediente;

	public Canela(final Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public double preco() {
		return ingrediente.preco() + 0.30;
	}

	@Override
	public Ingrediente ingrediente() {
		return ingrediente;
	}	
}
