package com.github.fabriciofx.apoo.ed.lista;

import static org.junit.Assert.assertEquals;

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
}
