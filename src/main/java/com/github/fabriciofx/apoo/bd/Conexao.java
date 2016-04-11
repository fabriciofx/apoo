package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Conexao {
	private final transient Connection conn;

	public Conexao(final SGBD sgbd) throws IOException {
		try {
			Class.forName(sgbd.driver());
			this.conn = connection(sgbd);
		} catch (final ClassNotFoundException e) {
			throw new IOException(e);
		}
	}

	public PreparedStatement statement(final String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	public void efetiva() throws SQLException {
		conn.commit();
	}

	public void fecha() throws IOException {
		try {
			if (conn.isClosed()) {
				throw new IllegalStateException(
						"não é possível fechar uma conexão já fechada");
			} else {
				conn.close();
			}
		} catch (final SQLException e) {
			throw new IOException(e);
		}
	}

	private Connection connection(final SGBD sgbd) throws IOException {
		try {
			return DriverManager.getConnection(sgbd.url(),
					sgbd.bd().usuario().nome(), sgbd.bd().usuario().senha());
		} catch (final SQLException e) {
			throw new IOException(e);
		}
	}
}
