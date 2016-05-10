package com.github.fabriciofx.apoo.bd;

import java.io.IOException;

public interface Consulta {
	Dados execute(final Conexao conexao) throws IOException;
}
