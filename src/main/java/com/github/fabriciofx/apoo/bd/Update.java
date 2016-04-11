package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Update implements Comando<Update> {
	private final transient Conexao conexao;

	public Update(final Conexao conexao) {
		this.conexao = conexao;
	}

	@Override
	public Update executa(final String sql, final Object... args)
			throws IOException {
		try {
			final PreparedStatement pstmt = conexao.statement(sql);
			pstmt.executeUpdate();
			conexao.efetiva();
			pstmt.close();
		} catch (final SQLException e) {
			throw new IOException(e);
		}

		return this;
	}
}
