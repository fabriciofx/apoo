package com.github.fabriciofx.apoo.padrao.decorator.comando;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.github.fabriciofx.apoo.padrao.decorator.comando.Comando;
import com.github.fabriciofx.apoo.padrao.decorator.comando.Ls;

public final class TesteLs {
	@Test
	public void podeListarComPath() throws IOException {
		final SistemaArquivo sa = new SistemaArquivo();
		final Comando ls = new Ls(sa.dir());
		assertEquals(sa.arquivos(), ls.execute());
	}
}
