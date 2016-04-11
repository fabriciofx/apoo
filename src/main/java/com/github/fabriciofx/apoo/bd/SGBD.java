package com.github.fabriciofx.apoo.bd;

public interface SGBD {
	String driver();

	int porta();
	
	String url(String banco);
}
