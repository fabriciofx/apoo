package com.github.fabriciofx.apoo.padrao.decorator.cafeteria;

import java.util.Arrays;
import java.util.List;

public final class Expresso implements Produto {
	@Override
	public double preco() {
		return 1.50;
	}

	@Override
	public List<String> composicao() {
		return Arrays.asList("Expresso");
	}
}
