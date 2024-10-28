package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class Cartorio extends BaseEntity {
	private static Integer serialId = 0;

	public Cartorio() {

		super();
		this.id = Cartorio.serialId++;
	}

	public Cartorio(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao) {

		super(dataCriacao, dataModificacao);
		this.id = Cartorio.serialId++;
	}
}
