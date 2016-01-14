package com.github.fabriciofx.padroes.decorator.cafeteria;

import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Canela;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Chantilly;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Chocolate;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Expresso;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Produto;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Leite;

public final class TesteCafeteria {
	public static void main(String[] args) {
		final Produto cappuccino = new Chantilly(
				new Canela(new Chocolate(new Leite(new Expresso()))));
		System.out.println("Preço do Cappuccino: " + cappuccino.preco());
	}
}
