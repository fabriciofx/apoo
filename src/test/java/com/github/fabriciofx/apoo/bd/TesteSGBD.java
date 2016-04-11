package com.github.fabriciofx.apoo.bd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class TesteSGBD {
	private SGBD sgbd;

	@Before
	public void inicializa() {
		sgbd = new H2(new BancoDados("logdb", new Usuario("sa", "")));
	}

	@After
	public void finaliza() {
		try {
			sgbd.apaga();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void novo() {
		final Path path = Paths.get(".").toAbsolutePath().normalize();
		assertEquals("jdbc:h2:" + path + "\\logdb", sgbd.url());
	}

	@Test
	public void cria() throws IOException {
		final Conexao conexao = sgbd.conexao();
		final Update update = new Update(conexao);
		update.executa("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))");
		conexao.fecha();
	}

	@Test
	public void insertUm() throws IOException {
		final long id = new Date().getTime();
		final String msg = "Uma mensagem de log qualquer";
		final Conexao conexao = sgbd.conexao();
		final Update update = new Update(conexao);
		final Insert insert = new Insert(conexao);
		final Select select = new Select(conexao);
		update.executa("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))");
		insert.executa("INSERT INTO log (id, info) VALUES(?, ?)", id, msg);
		final List<Map<String, Object>> logs = select
				.executa("SELECT * FROM log");
		conexao.fecha();
		assertEquals(logs.get(0).get("id"), id);
		assertEquals(logs.get(0).get("info"), msg);
	}

	@Test
	public void insertTres() throws IOException {
		final long id = new Date().getTime();
		final String msg = "Uma mensagem de log qualquer";
		final Conexao conexao = sgbd.conexao();
		final Update update = new Update(conexao);
		final Insert insert = new Insert(conexao);
		final Select select = new Select(conexao);
		update.executa("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))");
		insert.executa("INSERT INTO log (id, info) VALUES(?, ?)", id, msg);
		insert.executa("INSERT INTO log (id, info) VALUES(?, ?)", id + 1,
				msg + "1");
		insert.executa("INSERT INTO log (id, info) VALUES(?, ?)", id + 2,
				msg + "2");
		final List<Map<String, Object>> logs = select
				.executa("SELECT * FROM log");
		conexao.fecha();
		assertEquals(logs.get(0).get("id"), id);
		assertEquals(logs.get(0).get("info"), msg);
		assertEquals(logs.get(1).get("id"), id + 1);
		assertEquals(logs.get(1).get("info"), msg + "1");
		assertEquals(logs.get(2).get("id"), id + 2);
		assertEquals(logs.get(2).get("info"), msg + "2");
	}
}
