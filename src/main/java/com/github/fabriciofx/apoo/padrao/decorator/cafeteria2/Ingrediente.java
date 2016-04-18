package com.github.fabriciofx.apoo.padrao.decorator.cafeteria2;

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
