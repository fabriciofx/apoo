package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public final class TesteTransacao {
	@Test
	public void ok() throws IOException {
		final Conexao conexao = new Conexao(new H2(), "logdb",
				new Usuario("sa", ""));
		final Transacao transacao = new Transacao(
				new Insert("INSERT INTO log (id, info) VALUES(?, ?)",
						new Date().getTime(), "Mensagem 1"),
				new Insert("INSERT INTO log (id, info) VALUES(?, ?)",
						new Date().getTime(), "Mensagem 2"));
		transacao.execute(conexao);
		conexao.fecha();
	}
}
