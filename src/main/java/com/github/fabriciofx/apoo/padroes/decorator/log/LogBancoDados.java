package com.github.fabriciofx.apoo.padroes.decorator.log;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.github.fabriciofx.apoo.bd.Conexao;
import com.github.fabriciofx.apoo.bd.Insert;
import com.github.fabriciofx.apoo.bd.SGBD;
import com.github.fabriciofx.apoo.bd.Select;
import com.github.fabriciofx.apoo.bd.Update;

public final class LogBancoDados implements Log {
	private final Log origem;
	private final SGBD sgbd;

	public LogBancoDados(final Log origem, final SGBD sgbd) throws IOException {
		this.origem = origem;
		this.sgbd = sgbd;
		final Conexao conexao = sgbd.conexao();
		final Update update = new Update(conexao);
		update.executa("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))");
		conexao.fecha();
	}

	@Override
	public Log adiciona(String mensagem) throws IOException {
		origem.adiciona(mensagem);
		return this;
	}

	@Override
	public String mensagem() {
		return origem.mensagem();
	}

	@Override
	public List<String> mensagens() throws IOException {
		final Conexao conexao = sgbd.conexao();
		final Select select = new Select(conexao);
		final List<Map<String, Object>> tabela = select
				.executa("SELECT * FROM log");
		conexao.fecha();
		final List<String> logs = new LinkedList<>();
		for (final Map<String, Object> linha : tabela) {
			logs.add(linha.get("info").toString());
		}
		return logs;
	}

	@Override
	public Log salva() throws IOException {
		final Conexao conexao = sgbd.conexao();
		final Insert insert = new Insert(conexao);
		insert.executa("INSERT INTO log (id, info) VALUES(?, ?)",
				new Date().getTime(), mensagem());
		conexao.fecha();
		origem.salva();
		return this;
	}
}
