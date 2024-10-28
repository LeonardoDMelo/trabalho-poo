package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PessoaDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	String nome,
	LocalDate nascimento,
	String telefone) {

	@Override
	public String toString() {
		return "{ 'id': '"
			+ id
			+ "', 'dataCriacao': '"
			+ dataCriacao
			+ "', 'dataModificacao': '"
			+ dataModificacao
			+ "', 'nome': '"
			+ nome
			+ "', 'nascimento': '"
			+ nascimento
			+ "', 'telefone': '"
			+ telefone
			+ "'}";
	}
}
