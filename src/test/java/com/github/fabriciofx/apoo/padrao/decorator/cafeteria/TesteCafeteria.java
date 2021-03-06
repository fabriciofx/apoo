package com.github.fabriciofx.apoo.padrao.decorator.cafeteria;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.github.fabriciofx.apoo.padrao.decorator.cafeteria.Canela;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria.Chantilly;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria.Chocolate;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria.Expresso;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria.Leite;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria.Produto;

public final class TesteCafeteria {

	@Test
	public void criaUmCappuccino() {
		final Produto cappuccino = new Chantilly(
				new Canela(new Chocolate(new Leite(new Expresso()))));
		
		assertEquals(3.8, cappuccino.preco(), 0.0001);
		assertEquals("[Expresso, Leite, Chocolate, Canela, Chantilly]",
				Arrays.toString(cappuccino.composicao().toArray()));
	}
}
