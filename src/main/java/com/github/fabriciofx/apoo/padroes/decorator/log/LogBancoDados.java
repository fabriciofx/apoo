package com.github.fabriciofx.apoo.padroes.decorator.log;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.github.fabriciofx.apoo.bd.Conexao;
import com.github.fabriciofx.apoo.bd.Dados;
import com.github.fabriciofx.apoo.bd.Insert;
import com.github.fabriciofx.apoo.bd.Sgbd;
import com.github.fabriciofx.apoo.bd.Select;
import com.github.fabriciofx.apoo.bd.Update;
import com.github.fabriciofx.apoo.bd.Usuario;

public final class LogBancoDados implements Log {
	private final Log origem;
	private final Sgbd sgbd;

	public LogBancoDados(final Log origem, final Sgbd sgbd) throws IOException {
		this.origem = origem;
		this.sgbd = sgbd;
		final Conexao conexao = new Conexao(sgbd, "logdb",
				new Usuario("sa", ""));
		new Update("CREATE TABLE IF NOT EXISTS"
				+ " log(id LONG PRIMARY KEY, info VARCHAR(255))")
						.execute(conexao);
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
		final Conexao conexao = new Conexao(sgbd, "logdb",
				new Usuario("sa", ""));
		final Dados logs = new Select("SELECT * FROM log").execute(conexao);
		conexao.fecha();
		final List<String> mensagens = new LinkedList<>();
		for (final Object info : logs.itens("info")) {
			mensagens.add(info.toString());
		}
		return mensagens;
	}

	@Override
	public Log salva() throws IOException {
		final Conexao conexao = new Conexao(sgbd, "logdb",
				new Usuario("sa", ""));
		final Insert insert = new Insert(
				"INSERT INTO log (id, info) VALUES(?, ?)", new Date().getTime(),
				mensagem()).execute(conexao);
		conexao.fecha();
		origem.salva();
		return this;
	}
}
