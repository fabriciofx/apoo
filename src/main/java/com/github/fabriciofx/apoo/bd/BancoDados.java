package com.github.fabriciofx.apoo.bd;

public final class BancoDados {
	private final transient String nome;
	private final transient Usuario usuario;

	public BancoDados(final String nome, final Usuario usuario) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException(
					"nome do banco de dados inválido");
		}
		if (usuario == null) {
			throw new IllegalArgumentException("usuário inválido");
		}
		this.nome = nome;
		this.usuario = usuario;
	}

	public String nome() {
		return nome;
	}

	public Usuario usuario() {
		return usuario;
	}
}
