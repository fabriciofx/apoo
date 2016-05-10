package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public final class Transacao implements Comando {
	private final transient List<Alteracao> alteracoes;

	public Transacao(final Alteracao... alteracoes) {
		this(Arrays.asList(alteracoes));
	}

	public Transacao(final List<Alteracao> alteracoes) {
		this.alteracoes = alteracoes;
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
	public void execute(final Conexao conexao) throws IOException {
		try {
			inicio(conexao);
			for (final Alteracao alteracao : alteracoes) {
				alteracao.execute(conexao);
			}
		} catch (final Exception e) {
			rollback(conexao);
		} finally {
			fim(conexao);
		}
	}
}
