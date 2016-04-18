package com.github.fabriciofx.apoo.padroes.decorator.comando;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Ls implements Comando {
	private final transient Path path;

	public Ls() {
		this(".");
	}
	
	public Ls(final String path) {
		this(Paths.get(path));
	}

	public Ls(final Path path) {
		this.path = path;
	}

	@Override
	public String execute() throws IOException {
		final StringBuilder sb = new StringBuilder();
		try (final DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
			for (final Path p : ds) {
				sb.append(p.toString()).append("\n");
			}
		} catch (final IOException e) {
			throw e;
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
