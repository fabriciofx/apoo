package com.github.fabriciofx.apoo.ed.lista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public final class TesteLista {
	@Test
	public void vazia() {
		Lista<String> lista = new Lista<>();

		assertEquals(0, lista.tamanho());
	}

	@Test
	public void um() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");

		assertEquals(1, lista.tamanho());
		assertEquals("[Pedro]", lista.toString());
	}

	@Test
	public void varios() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");
		lista = lista.adiciona("Maria");
		lista = lista.adiciona("João");

		assertEquals(3, lista.tamanho());
		assertEquals("[João,Maria,Pedro]", lista.toString());
	}

	@Test
	public void limpa() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");
		lista = lista.adiciona("Maria");
		lista = lista.adiciona("João");
		lista = lista.limpa();

		assertEquals(0, lista.tamanho());
		assertEquals("[]", lista.toString());
	}

	@Test
	public void contemVazia() {
		Lista<String> lista = new Lista<>();

		assertFalse(lista.contem("Pedro"));
	}

	@Test
	public void contemComUm() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");

		assertTrue(lista.contem("Pedro"));
	}

	@Test
	public void contemComVarios() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");
		lista = lista.adiciona("Maria");
		lista = lista.adiciona("João");

		assertTrue(lista.contem("Pedro"));
		assertTrue(lista.contem("Maria"));
		assertTrue(lista.contem("João"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void obtemPosicaoNegativa() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");

		lista.obtem(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void obtemVazia() {
		Lista<String> lista = new Lista<>();

		lista.obtem(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void obtemAlemDoMaximo() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");

		lista.obtem(1);
	}

	@Test
	public void obtemPrimeiro() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");

		assertEquals("Pedro", lista.obtem(0));
	}

	@Test
	public void obtemPrimeiroESegundo() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");
		lista = lista.adiciona("Maria");

		assertEquals("Maria", lista.obtem(1));
		assertEquals("Pedro", lista.obtem(0));
	}

	@Test
	public void obtemPrimeiroSegundoETerceiro() {
		Lista<String> lista = new Lista<>();
		lista = lista.adiciona("Pedro");
		lista = lista.adiciona("Maria");
		lista = lista.adiciona("João");

		assertEquals("João", lista.obtem(2));
		assertEquals("Maria", lista.obtem(1));
		assertEquals("Pedro", lista.obtem(0));
	}
}
