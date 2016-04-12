package com.github.fabriciofx.apoo.bd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class TesteSgbd {
	private Conexao conexao;

	@Before
	public void inicializa() throws IOException {
		conexao = new Conexao(new H2(), "logdb", new Usuario("sa", ""));
	}

	@After
	public void finaliza() {
		try {
			final Update update = new Update(conexao);
			update.executa("DROP TABLE IF EXISTS log");
			conexao.fecha();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void novo() {
		final Path path = Paths.get(".").toAbsolutePath().normalize();
		assertEquals("jdbc:h2:" + path + "\\logdb", conexao.url());
	}

	@Test
	public void cria() throws IOException {
		final Update update = new Update(conexao);
		update.executa("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))");
	}

	@Test
	public void insertUm() throws IOException {
		final long id = new Date().getTime();
		final String msg = "Uma mensagem de log qualquer";
		final Update update = new Update(conexao);
		final Insert insert = new Insert(conexao);
		final Select select = new Select(conexao);
		update.executa("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))");
		insert.executa("INSERT INTO log (id, info) VALUES(?, ?)", id, msg);
		final Dados logs = select.executa("SELECT * FROM log");
		assertEquals(logs.elemento(0, "id"), id);
		assertEquals(logs.elemento(0, "info"), msg);
	}

	@Test
	public void insertTres() throws IOException {
		final long id = new Date().getTime();
		final String msg = "Uma mensagem de log qualquer";
		final Update update = new Update(conexao);
		final Insert insert = new Insert(conexao);
		final Select select = new Select(conexao);
		update.executa("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))");
		insert.executa("INSERT INTO log (id, info) VALUES(?, ?)", id, msg)
		      .executa("INSERT INTO log (id, info) VALUES(?, ?)", id + 1, msg + "1")
		      .executa("INSERT INTO log (id, info) VALUES(?, ?)", id + 2, msg + "2");
		final Dados logs = select.executa("SELECT * FROM log");
		assertEquals(logs.elemento(0, "id"), id);
		assertEquals(logs.elemento(0, "info"), msg);
		assertEquals(logs.elemento(1, "id"), id + 1);
		assertEquals(logs.elemento(1, "info"), msg + "1");
		assertEquals(logs.elemento(2, "id"), id + 2);
		assertEquals(logs.elemento(2, "info"), msg + "2");
	}
}
