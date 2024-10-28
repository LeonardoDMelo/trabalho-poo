package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class Cerimonial extends BaseEntity {
	private static Integer serialId = 0;

	public Cerimonial() {

		super();
		this.id = Cerimonial.serialId++;
	}

	public Cerimonial(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao) {

		super(dataCriacao, dataModificacao);
		this.id = Cerimonial.serialId++;
	}
}
