package com.github.fabriciofx.apoo.unix.comando;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public final class TesteLs {
	@Test
	public void podeListarComPath() throws IOException {
		final SistemaArquivo sa = new SistemaArquivo();
		final Comando ls = new Ls(sa.dir());
		assertEquals(sa.arquivos(), ls.execute());
	}
}
