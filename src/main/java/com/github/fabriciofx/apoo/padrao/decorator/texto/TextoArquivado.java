package com.github.fabriciofx.apoo.padrao.decorator.texto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class TextoArquivado implements Texto {
	private final File arquivo;

	public TextoArquivado(final File arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public String conteudo() throws IOException {
		try {
			return new String(Files.readAllBytes(arquivo.toPath()), "UTF-8");
		} catch (final Exception e) {
			throw new IOException(e);
		}
	}
}
