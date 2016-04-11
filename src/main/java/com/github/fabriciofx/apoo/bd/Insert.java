package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Insert implements Comando<Insert> {
	private final transient Conexao conexao;

	public Insert(final Conexao conexao) {
		this.conexao = conexao;
	}

	@Override
	public Insert executa(final String sql, final Object... args)
			throws IOException {
		try {
			final PreparedStatement pstmt = conexao.statement(sql);
			prepare(pstmt, args);
			pstmt.executeUpdate();
			conexao.efetiva();
			pstmt.close();
		} catch (final SQLException e) {
			throw new IOException(e);
		}
		return this;
	}

	private void prepare(final PreparedStatement stmt, final Object... args)
			throws SQLException {
		int pos = 1;
		for (final Object arg : args) {
			if (arg == null) {
				stmt.setString(pos, null);
			} else if (arg instanceof Long) {
				stmt.setLong(pos, Long.class.cast(arg));
			} else if (arg instanceof Boolean) {
				stmt.setBoolean(pos, Boolean.class.cast(arg));
			} else if (arg instanceof Date) {
				stmt.setDate(pos, Date.class.cast(arg));
			} else if (arg instanceof Integer) {
				stmt.setInt(pos, Integer.class.cast(arg));
			} else if (arg instanceof byte[]) {
				stmt.setBytes(pos, byte[].class.cast(arg));
			} else {
				stmt.setString(pos, arg.toString());
			}
			++pos;
		}
	}
}
