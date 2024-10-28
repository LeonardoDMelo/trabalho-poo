package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class Igreja extends BaseEntity {
	private static Integer serialId = 0;

	public Igreja() {

		super();
		this.id = Igreja.serialId++;
	}

	public Igreja(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao) {

		super(dataCriacao, dataModificacao);
		this.id = Igreja.serialId++;
	}
}
