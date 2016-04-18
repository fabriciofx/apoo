package com.github.fabriciofx.apoo.padroes.decorator.comando;

import java.io.IOException;

public final class Cut implements Comando {
	private final transient Fluxo fluxo;
	private final transient String delimitador;
	private final transient int campo;

	public Cut(final String dados, final int campo) {
		this(new Fluxo.Dados(dados), campo);
	}

	public Cut(final String dados, final String delimitador, final int campo)
			throws IOException {
		this(new Fluxo.Dados(dados), delimitador, campo);
	}

	public Cut(final Comando comando, final int campo) {
		this(new Fluxo.Executavel(comando), campo);
	}

	public Cut(final Comando comando, final String delimitador, final int campo)
			throws IOException {
		this(new Fluxo.Executavel(comando), delimitador, campo);
	}

	public Cut(final Fluxo fluxo, final int campo) {
		this(fluxo, " ", campo);
	}

	public Cut(final Fluxo fluxo, final String delimitador, final int campo) {
		this.fluxo = fluxo;
		this.delimitador = delimitador;
		this.campo = campo;
	}

	@Override
	public String execute() throws IOException {
		final String[] campos = fluxo.dados().split(delimitador);
		if (campos.length < campo) {
			throw new IllegalArgumentException("campo inválido");
		}
		return campos[campo - 1];
	}
}
