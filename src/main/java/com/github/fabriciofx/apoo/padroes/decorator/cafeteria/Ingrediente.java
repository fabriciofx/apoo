package com.github.fabriciofx.apoo.padroes.decorator.cafeteria;

public interface Ingrediente {
	final Ingrediente PURO = new Ingrediente() {
		@Override
		public double preco() {
			return 0.0;
		}

		@Override
		public Ingrediente ingrediente() {
			return PURO;
		}
	};

	default String nome() {
		return getClass().getSimpleName();
	}

	double preco();
	
	Ingrediente ingrediente();
}
