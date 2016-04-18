package com.github.fabriciofx.apoo.unix.comando;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface Fluxo {
	String dados() throws IOException;

	class Dados implements Fluxo {
		private final transient String dados;

		public Dados(final String dados) {
			this.dados = dados;
		}

		@Override
		public String dados() throws IOException {
			return dados;
		}
	}

	class Arquivo implements Fluxo {
		private final transient Path path;

		public Arquivo(final String nome) {
			this(Paths.get(nome));
		}

		public Arquivo(final Path path) {
			this.path = path;
		}

		@Override
		public String dados() throws IOException {
			return String.join("\n", Files.readAllLines(path));
		}
	}

	class Executavel implements Fluxo {
		private final transient Comando comando;

		public Executavel(final Comando comando) {
			this.comando = comando;
		}

		@Override
		public String dados() throws IOException {
			return comando.execute();
		}
	}
}
