package com.github.fabriciofx.apoo.bd;

public interface Sgbd {
	String driver();

	int porta();
	
	String url(String banco);
}
