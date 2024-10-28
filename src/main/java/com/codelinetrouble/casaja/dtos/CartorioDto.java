package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;

public record CartorioDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao) {

	@Override
	public String toString() {
		return "{ 'id': '"
			+ id
			+ "', 'dataCriacao': '"
			+ dataCriacao
			+ "', 'dataModificacao': '"
			+ dataModificacao
			+ "'}";
	}
}
