package com.github.fabriciofx.apoo.padroes.decorator.cafeteria2;

import java.util.ArrayList;
import java.util.List;

public final class Expresso implements Cafe {
	private final Ingrediente ingrediente;

	public Expresso(final Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public double preco() {
		return ingrediente.preco() + 1.50;
	}

	@Override
	public List<Ingrediente> ingredientes() {
		final List<Ingrediente> ingredientes = new ArrayList<>();
		
		for (Ingrediente i = ingrediente; i != Ingrediente.PURO; i = i
				.ingrediente()) {
			ingredientes.add(i);
		}

		return ingredientes;
	}
}
