package com.github.fabriciofx.apoo.padrao.decorator.comando;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

public final class SistemaArquivo {
	private final transient FileSystem fs;
	private final transient Path dir;
	private final transient Map<String, Path> arquivos = new TreeMap<>();
	private final transient String[] nomes = { "a.txt", "b.txt", "c.doc",
			"d.bin" };

	public SistemaArquivo() throws IOException {
		this.fs = Jimfs.newFileSystem(Configuration.unix());
		this.dir = fs.getPath("/tmp");
		Files.createDirectory(dir);

		for (final String nome : nomes) {
			final Path arquivo = dir.resolve(nome);
			Files.write(arquivo, Arrays.asList(nome), StandardCharsets.UTF_8);
			arquivos.put(arquivo.toString(), arquivo);
		}
	}

	public Path dir() {
		return dir;
	}

	public Path arquivo(final String nome) {
		return arquivos.get(nome);
	}

	public String arquivos() {
		return String.join("\n", arquivos.keySet());
	}
}
