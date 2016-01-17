package com.github.fabriciofx.apoo.padroes.decorator.cafeteria2;

import java.util.List;

public interface Produto {
	default String nome() {
		return getClass().getSimpleName();
	}

	double preco();

	List<String> composicao();
}
