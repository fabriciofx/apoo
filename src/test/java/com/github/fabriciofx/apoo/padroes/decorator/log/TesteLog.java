package com.github.fabriciofx.apoo.padroes.decorator.log;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.fabriciofx.apoo.bd.BancoDados;
import com.github.fabriciofx.apoo.bd.H2;
import com.github.fabriciofx.apoo.bd.SGBD;
import com.github.fabriciofx.apoo.bd.Usuario;

public final class TesteLog {
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
	public void insere() throws IOException {
		final Log log = new LogBancoDados(new LogMemoria(), sgbd);
		log.adiciona("uma mensagem de teste");
		log.salva();
	}
}
