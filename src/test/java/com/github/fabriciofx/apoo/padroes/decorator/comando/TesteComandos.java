package com.github.fabriciofx.apoo.padroes.decorator.comando;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.github.fabriciofx.apoo.padroes.decorator.comando.Comando;
import com.github.fabriciofx.apoo.padroes.decorator.comando.Cut;
import com.github.fabriciofx.apoo.padroes.decorator.comando.Grep;
import com.github.fabriciofx.apoo.padroes.decorator.comando.Ls;
import com.github.fabriciofx.apoo.padroes.decorator.comando.Wc;

public final class TesteComandos {
	private SistemaArquivo sa;

	@Before
	public void inicializa() throws IOException {
		sa = new SistemaArquivo();
	}

	@Test
	public void lsGrep() throws IOException {
		final Comando lsGrep = new Grep(new Ls(sa.dir()), ".*a.*");
		assertEquals("/tmp/a.txt", lsGrep.execute());
	}

	@Test
	public void lsGrepCut() throws IOException {
		final Comando lsGrepCut = new Cut(
				new Grep(
					new Ls(sa.dir()),
					".*a.*"
				),
			"\\.", 2
		);
		assertEquals("txt", lsGrepCut.execute());
	}

	@Test
	public void lsWc() throws IOException {
		final Comando lsWc = new Wc(new Ls(sa.dir()));
		assertEquals("4 4 40", lsWc.execute());
	}
}
