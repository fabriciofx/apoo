package com.github.fabriciofx.apoo.ed.lista;

public final class Lista<T> {
	private final No<T> ultimo;
	private final int tamanho;

	public Lista() {
		this(new No.Vazio<T>(), 0);
	}

	public Lista(final No<T> ultimo, final int tamanho) {
		this.ultimo = ultimo;
		this.tamanho = tamanho;
	}

	public Lista<T> adiciona(final T dado) {
		final No<T> no = new No.Padrao<>(dado, ultimo);

		return new Lista<T>(no, tamanho + 1);
	}

	public int tamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("[");

		try {
			for (No<T> tmp = ultimo;; tmp = tmp.prox()) {
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
