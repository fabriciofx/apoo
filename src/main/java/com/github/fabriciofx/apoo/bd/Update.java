package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public final class Update implements Comando<Update> {
	private final transient boolean autocommit;
	private final transient String sql;
	private final transient Object[] args;

	public Update(final String sql, final Object... args) {
		this(false, sql, args);
	}

	public Update(final boolean autocommit, final String sql,
			final Object... args) {
		this.autocommit = autocommit;
		this.sql = sql;
		this.args = Arrays.copyOf(args, args.length);
	}

	@Override
	public Update execute(final Conexao conexao) throws IOException {
		try {
			final PreparedStatement pstmt = conexao.statement(sql);
			pstmt.executeUpdate();
			if (autocommit) {
				conexao.efetiva();
			}
			pstmt.close();
		} catch (final SQLException e) {
			throw new IOException(e);
		}
		return this;
	}
}
