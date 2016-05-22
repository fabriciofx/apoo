package com.github.fabriciofx.apoo.padrao.decorator.numeros;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.common.io.Files;

public final class IntervaloDoArquivo implements Sequencia {
	private final File arquivo;

	public IntervaloDoArquivo(final File arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public int[] numeros() {
		try {
			return Files.readLines(arquivo, StandardCharsets.UTF_8).stream()
					.mapToInt(Integer::parseInt).toArray();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
