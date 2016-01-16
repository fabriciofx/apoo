package com.github.fabriciofx.padroes.decorator.cafeteria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Cafe;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Canela;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Chantilly;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Chocolate;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Expresso;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Ingrediente;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria.Leite;

public final class TesteCafeteria {

	@Test
	public void criaUmCappuccino() {
		final Cafe cappuccino = new Expresso(new Chantilly(
				new Canela(new Chocolate(new Leite(Ingrediente.PURO)))));
		
		assertEquals(3.8, cappuccino.preco(), 0.0001);
	}
}
