package com.github.fabriciofx.apoo.padrao.decorator.cafeteria2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.fabriciofx.apoo.padrao.decorator.cafeteria2.Cafe;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria2.Canela;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria2.Chantilly;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria2.Chocolate;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria2.Expresso;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria2.Ingrediente;
import com.github.fabriciofx.apoo.padrao.decorator.cafeteria2.Leite;

public final class TesteCafeteria {
	private String ingredientesToString(final List<Ingrediente> ingredientes) {
		final List<String> nomes = new ArrayList<>();

		for (final Ingrediente i : ingredientes) {
			nomes.add(i.nome());
		}

		return Arrays.toString(nomes.toArray());
	}

	@Test
	public void criaUmCappuccino() {
		final Cafe cappuccino = new Expresso(new Chantilly(
				new Canela(new Chocolate(new Leite(Ingrediente.PURO)))));

		assertEquals(3.8, cappuccino.preco(), 0.0001);
		assertEquals("[Chantilly, Canela, Chocolate, Leite]",
				ingredientesToString(cappuccino.ingredientes()));
	}
}
