package com.github.fabriciofx.apoo.padrao.decorator.log;

import java.io.IOException;

import org.junit.Test;

import com.github.fabriciofx.apoo.bd.H2;
import com.github.fabriciofx.apoo.padrao.decorator.log.Log;
import com.github.fabriciofx.apoo.padrao.decorator.log.LogBancoDados;
import com.github.fabriciofx.apoo.padrao.decorator.log.LogMemoria;

public final class TesteLog {
	@Test
	public void insere() throws IOException {
		final Log log = new LogBancoDados(new LogMemoria(), new H2());
		log.adiciona("uma mensagem de teste");
		log.salva();
	}
}
