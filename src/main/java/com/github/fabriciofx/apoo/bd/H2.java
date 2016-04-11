package com.github.fabriciofx.apoo.bd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class H2 implements SGBD {
	private final transient BancoDados bd;

	public H2(final BancoDados bd) {
		this.bd = bd;
	}

	@Override
	public String driver() {
		return "org.h2.Driver";
	}

	@Override
	public int porta() {
		return 5432;
	}

	@Override
	public BancoDados bd() {
		return bd;
	}

	@Override
	public String url() {
		final Path path = Paths.get(".").toAbsolutePath().normalize();
		return String.format("jdbc:h2:%s%s%s", path.toString(), File.separator,
				bd.nome());
	}

	@Override
	public Conexao conexao() throws IOException {
		return new Conexao(this);
	}

	@Override
	public void apaga() throws IOException {
		final Path path = Paths.get(".").toAbsolutePath().normalize();
		final String nomeArquivo = String.format("%s%s%s%s", path.toString(),
				File.separator, bd.nome(), ".mv.db");
		final Path arquivo = Paths.get(nomeArquivo);
		Files.deleteIfExists(arquivo);
	}
}
