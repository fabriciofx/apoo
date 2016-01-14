package com.github.fabriciofx.apoo.padroes.decorator.cafeteria;

import java.util.ArrayList;
import java.util.List;

public final class Leite implements Produto {
	private final Produto produto;

	public Leite(final Produto produto) {
		this.produto = produto;
	}

	@Override
	public double preco() {
		return produto.preco() + 0.80;
	}

	@Override
	public List<String> composicao() {
		List<String> ingredientes = new ArrayList<>(produto.composicao());
		ingredientes.add(getClass().getSimpleName());

		return ingredientes;
	}
}
