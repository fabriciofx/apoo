package com.github.fabriciofx.apoo.bd;

public final class Insert extends Alteracao implements Comando {
	public Insert(final String sql, final Object... args) {
		super(sql, args);
	}
}
