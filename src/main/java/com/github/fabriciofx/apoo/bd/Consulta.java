package com.github.fabriciofx.apoo.bd;

import java.io.IOException;

public interface Consulta<T> {
	T execute(final Conexao conexao) throws IOException;
}
