package com.github.fabriciofx.apoo.padroes.decorator.log;

import java.io.IOException;
import java.util.List;

public interface Log {
	Log adiciona(String mensagem) throws IOException;

	String mensagem();

	List<String> mensagens() throws IOException;
	
	Log salva() throws IOException;
}
