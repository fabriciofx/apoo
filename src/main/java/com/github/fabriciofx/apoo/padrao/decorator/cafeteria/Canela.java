package com.github.fabriciofx.apoo.padrao.decorator.cafeteria;

import java.util.ArrayList;
import java.util.List;

public final class Canela implements Produto {
	private final Produto produto;

	public Canela(final Produto produto) {
		this.produto = produto;
	}

	@Override
	public double preco() {
		return produto.preco() + 0.30;
	}

	@Override
	public List<String> composicao() {
		List<String> ingredientes = new ArrayList<>(produto.composicao());
		ingredientes.add(getClass().getSimpleName());

		return ingredientes;
	}
}
