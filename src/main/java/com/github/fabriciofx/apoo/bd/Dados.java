package com.github.fabriciofx.apoo.bd;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Dados {
	private final transient List<Map<String, Object>> tabela;

	public Dados(final List<Map<String, Object>> tabela) {
		this.tabela = tabela;
	}

	public Object elemento(final int numero, final String nome) {
		return tabela.get(numero).get(nome);
	}

	public List<Map<String, Object>> todos() {
		return tabela;
	}
	
	public List<Object> todos(final String nome) {
		final List<Object> todos = new LinkedList<>();
		for (int n = 0; n < tabela.size(); n++) {
			todos.add(tabela.get(n).get(nome));
		}
		return todos;
	}
}
