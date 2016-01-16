package com.github.fabriciofx.apoo.padroes.decorator.cafeteria;

public interface Ingrediente {
	default String nome() {
		return getClass().getSimpleName();
	}

	double preco();

	final Ingrediente PURO = new Ingrediente() {
		@Override
		public double preco() {
			return 0.0;
		}
	};
}
