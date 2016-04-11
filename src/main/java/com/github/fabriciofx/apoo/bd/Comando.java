package com.github.fabriciofx.apoo.bd;

import java.io.IOException;

public interface Comando<R> {
	R executa(String sql, Object... args) throws IOException;
}
