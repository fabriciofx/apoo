package com.github.fabriciofx.apoo.padroes.decorator.cafeteria2;

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
