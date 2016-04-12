package com.github.fabriciofx.apoo.ed.lista;

public final class Lista<T> {
	private final No<T> ultimo;
	private final int tamanho;

	public Lista() {
		this(new No.Terminal<T>(), 0);
	}

	public Lista(final No<T> ultimo, final int tamanho) {
		this.ultimo = ultimo;
		this.tamanho = tamanho;
	}

	public Lista<T> adiciona(final T dado) {
		final No<T> no = new No.Simples<>(dado, ultimo);
		return new Lista<T>(no, tamanho + 1);
	}

	public Lista<T> limpa() {
		return new Lista<T>();
	}

	public T primeiro() {
		return no(0).dado();
	}
	
	public T ultimo() {
		return ultimo.dado();
	}

	public int tamanho() {
		return tamanho;
	}

	public boolean vazia() {
		return tamanho == 0;
	}
	
	public boolean contem(final Object o) {
		return indice(o) != -1;
	}
	
	public T obtem(final int indice) {
		return no(indice).dado();
	}

	public Lista<T> remove(final Object o) {
		return remove(indice(o));
	}

	private No<T> no(final int indice) {
		if (indice < 0 || indice >= tamanho) {
			throw new IndexOutOfBoundsException();
		}
		No<T> tmp = ultimo;
		for (int pos = tamanho - 1; pos > indice; pos--) {
			tmp = tmp.prox();			
		}
		return tmp;		
	}
	
	public int indice(final Object o) {
		No<T> tmp = ultimo;
		for (int pos = tamanho - 1; pos >= 0; pos--) {
			final T dado = tmp.dado();
			if (dado.equals(o)) {
				return pos;
			}
			tmp = tmp.prox();
		}
		return -1;
	}

	public Lista<T> remove(final int indice) {
		Lista<T> novaLista = new Lista<>();
		for (int pos = 0; pos <= tamanho - 1; pos++) {
			if (pos == indice) {
				continue;
			}
			final No<T> no = no(pos);
			novaLista = novaLista.adiciona(no.dado());
		}
		return novaLista;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder().append("[");
		No<T> tmp = ultimo;
		for (int pos = tamanho - 1; pos >= 0; pos--) {
			final T dado = tmp.dado();
			sb.append(dado.toString()).append(",");
			tmp = tmp.prox();
		}
		return sb.length() > 1
				? sb.replace(sb.length() - 1, sb.length(), "]").toString()
				: "[]";
	}
}
