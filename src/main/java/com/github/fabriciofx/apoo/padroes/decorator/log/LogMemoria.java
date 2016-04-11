package com.github.fabriciofx.apoo.padroes.decorator.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class LogMemoria implements Log {
	private final List<String> mensagens;

	public LogMemoria() {
		mensagens = new ArrayList<>();
	}

	@Override
	public Log adiciona(String mensagem) throws IOException {
		mensagens.add(mensagem);
		return this;
	}

	@Override
	public String mensagem() {
		return mensagens.stream().collect(Collectors.joining());
	}

	@Override
	public Log salva() throws IOException {
		mensagens.clear();
		return this;
	}

	@Override
	public List<String> mensagens() throws IOException {
		return mensagens;
	}
}
