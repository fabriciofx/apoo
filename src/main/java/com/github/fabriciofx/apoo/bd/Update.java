package com.github.fabriciofx.apoo.bd;

public final class Update extends Alteracao implements Comando {
	public Update(final String sql, final Object... args) {
		super(sql, args);
	}
}
