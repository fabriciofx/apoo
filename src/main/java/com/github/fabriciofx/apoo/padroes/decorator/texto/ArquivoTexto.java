package com.github.fabriciofx.apoo.padroes.decorator.texto;

import java.io.File;
import java.nio.file.Files;

public final class ArquivoTexto implements Texto {
	private final File arquivo;

	public ArquivoTexto(final File arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public String leia() {
		try {
			return new String(Files.readAllBytes(arquivo.toPath()), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new String();
	}
}
