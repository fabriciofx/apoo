package com.github.fabriciofx.apoo.padroes.decorator.texto;

import java.io.File;
import java.nio.file.Files;

public final class TextoArquivado implements Texto {
	private final File arquivo;

	public TextoArquivado(final File arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public String conteudo() {
		try {
			return new String(Files.readAllBytes(arquivo.toPath()), "UTF-8");
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return new String();
	}
}
