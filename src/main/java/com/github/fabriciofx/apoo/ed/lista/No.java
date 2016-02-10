package com.github.fabriciofx.apoo.ed.lista;

interface No<T> {
	T dado();

	No<T> prox();

	final class Vazio<T> implements No<T> {
		@Override
		public T dado() {
			throw new UnsupportedOperationException();
		}

		@Override
		public No<T> prox() {
			throw new UnsupportedOperationException();
		}
	}

	final class Padrao<T> implements No<T> {
		private final T dado;
		private final No<T> prox;

		public Padrao(final T dado, final No<T> prox) {
			this.dado = dado;
			this.prox = prox;
		}

		@Override
		public T dado() {
			return dado;
		}

		@Override
		public No<T> prox() {
			return prox;
		}
	}
}
