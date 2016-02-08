package com.github.fabriciofx.apoo.ed.lista;

public final class Lista<T> {
	private final No<T> ultimo;

	public Lista() {
		this(new No.Vazio<T>());
	}

	public Lista(final No<T> ultimo) {
		this.ultimo = ultimo;
	}

	public Lista<T> adiciona(final T dado) {
		final No<T> no = new No.Padrao<>(dado, ultimo);

		return new Lista<T>(no);
	}

	public int tamanho() {
		int tamanho = 0;
		try {
			No<T> tmp = ultimo;
			while (true) {
				tmp = tmp.prox();
				tamanho++;
			}
		} catch (final UnsupportedOperationException e) {
			return tamanho;
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("[");

		try {
			for (No<T> tmp = ultimo; ; tmp = tmp.prox()) {
				final T dado = tmp.dado();
				sb.append(dado.toString()).append(",");
			}
		} catch (final UnsupportedOperationException e) {
			return sb.length() > 1
					? sb.replace(sb.length() - 1, sb.length(), "]").toString()
					: "[]";
		}
	}
}
