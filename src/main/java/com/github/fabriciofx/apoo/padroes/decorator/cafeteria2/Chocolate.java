package com.github.fabriciofx.apoo.padroes.decorator.cafeteria2;

import java.util.ArrayList;
import java.util.List;

public final class Chocolate implements Produto {
	private final Produto produto;

	public Chocolate(final Produto produto) {
		this.produto = produto;
	}

	@Override
	public double preco() {
		return produto.preco() + 0.70;
	}

	@Override
	public List<String> composicao() {
		List<String> ingredientes = new ArrayList<>(produto.composicao());
		ingredientes.add(getClass().getSimpleName());

		return ingredientes;
	}
}
