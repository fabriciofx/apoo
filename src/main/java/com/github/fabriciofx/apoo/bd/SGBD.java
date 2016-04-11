package com.github.fabriciofx.apoo.bd;

import java.io.IOException;

public interface SGBD {
	String driver();

	int porta();
	
	String url();
	
	BancoDados bd();
	
	Conexao conexao() throws IOException;
	
	void apaga() throws IOException;
}
