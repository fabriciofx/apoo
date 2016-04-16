package com.github.fabriciofx.apoo.bd;

import java.io.IOException;

public interface Comando<R> {
	R execute(Conexao conexao) throws IOException;
}
