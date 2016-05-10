package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public final class Transacao implements Comando<Void> {
	private final transient List<Comando<?>> comandos;

	public Transacao(final Comando<?>... comandos) {
		this(Arrays.asList(comandos));
	}

	public Transacao(final List<Comando<?>> comandos) {
		this.comandos = comandos;
	}

	private void inicio(final Conexao conexao) throws IOException {
		new Update("START TRANSACTION").execute(conexao);
	}

	private void fim(final Conexao conexao) {
		try {
			conexao.efetiva();
		} catch (final SQLException e) {
			new IOException(e);
		}
	}

	private void rollback(final Conexao conexao) throws IOException {
		new Update("ROLLBACK").execute(conexao);
	}

	@Override
	public Void execute(final Conexao conexao) throws IOException {
		try {
			inicio(conexao);
			for (final Comando<?> comando : comandos) {
				comando.execute(conexao);
			}
		} catch (final Exception e) {
			rollback(conexao);
		} finally {
			fim(conexao);
		}
		return null;
	}
}
