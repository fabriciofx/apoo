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

	public Lista<T> limpa() {
		return new Lista<T>();
	}

	public boolean contem(final Object o) {
		try {
			for (No<T> tmp = ultimo;; tmp = tmp.prox()) {
				final T dado = tmp.dado();

				if (dado.equals(o)) {
					return true;
				}
			}
		} catch (final UnsupportedOperationException e) {
			return false;
		}
	}

	public T obtem(final int indice) {
		if (indice < 0 || indice >= tamanho) {
			throw new IndexOutOfBoundsException();
		}

		int pos = tamanho - 1;
		No<T> tmp = ultimo;

		while (pos > indice) {
			tmp = tmp.prox();
			pos--;
		}

		return tmp.dado();
	}

	public int indice(final Object o) {
		int pos = tamanho - 1;
		for (No<T> tmp = ultimo; pos >= 0; tmp = tmp.prox()) {
			final T dado = tmp.dado();

			if (dado.equals(o)) {
				return pos;
			}
			
			pos--;
		}

		return -1;
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
