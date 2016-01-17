package com.github.fabriciofx.padroes.decorator.cafeteria2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.github.fabriciofx.apoo.padroes.decorator.cafeteria2.Canela;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria2.Chantilly;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria2.Chocolate;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria2.Expresso;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria2.Leite;
import com.github.fabriciofx.apoo.padroes.decorator.cafeteria2.Produto;

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
