package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;

public record RecadoDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	PessoaDto pessoa,
	String comentario) {

	@Override
	public String toString() {
		return "{ 'id': '"
			+ id
			+ "', 'dataCriacao': '"
			+ dataCriacao
			+ "', 'dataModificacao': '"
			+ dataModificacao
			+ "', 'pessoa': '"
			+ pessoa
			+ "', 'comentario': '"
			+ comentario
			+ "'}";
	}
}
