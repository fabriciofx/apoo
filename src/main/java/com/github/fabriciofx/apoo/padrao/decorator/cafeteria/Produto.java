package com.github.fabriciofx.apoo.padrao.decorator.cafeteria;

import java.util.List;

public interface Produto {
	default String nome() {
		return getClass().getSimpleName();
	}

	double preco();

	List<String> composicao();
}
