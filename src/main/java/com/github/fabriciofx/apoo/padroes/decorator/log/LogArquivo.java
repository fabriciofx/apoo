package com.github.fabriciofx.apoo.padroes.decorator.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class LogArquivo implements Log {
	private final Log origem;
	private final Path path;

	public LogArquivo(final Log origem, final String arquivo)
			throws IOException {
		this.origem = origem;
		this.path = Paths.get(arquivo);
	}

	@Override
	public Log adiciona(String mensagem) throws IOException {
		origem.adiciona(mensagem);
		Files.write(path, mensagem.getBytes());
		return this;
	}

	@Override
	public String mensagem() {
		return origem.mensagem();
	}

	@Override
	public List<String> mensagens() throws IOException {
		return Files.readAllLines(path);
	}

	@Override
	public Log salva() throws IOException {
		origem.salva();
		return this;
	}
}
