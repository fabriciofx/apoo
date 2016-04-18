package com.github.fabriciofx.apoo.bd;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public final class TesteTransacao {
	@Test
	public void ok() throws IOException {
		final Conexao conexao = new Conexao(new H2(), "logdb",
				new Usuario("sa", ""));
		new Transacao(conexao)
				.com(new Insert("INSERT INTO log (id, info) VALUES(?, ?)",
						new Date().getTime(), "Mensagem 1"));
		conexao.fecha();
	}
}
