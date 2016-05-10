package com.github.fabriciofx.apoo.bd;

import java.io.IOException;

public interface Comando {
	void execute(Conexao conexao) throws IOException;
}
