package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.sql.SQLException;

public final class Transacao {
	private final transient Conexao conexao;

	public Transacao(final Conexao conexao) {
		this.conexao = conexao;
	}

	private void inicio() throws IOException {
		new Update("START TRANSACTION").execute(conexao);
	}

	private void fim() {
		try {
			conexao.efetiva();
		} catch (final SQLException e) {
			new IOException(e);
		}
	}

	private void rollback() throws IOException {
		new Update("ROLLBACK").execute(conexao);
	}

	public Transacao com(final Comando<?>... comandos) throws IOException {
		try {
			inicio();
			for (final Comando<?> comando : comandos) {
				comando.execute(conexao);
			}
		} catch (final Exception e) {
			rollback();
		} finally {
			fim();
		}

		return this;
	}
}
