package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;

public record PresenteDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	String nome,
	String tipo,
	Double valor,
	PessoaDto pessoa) {

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
			+ "', 'tipo': '"
			+ tipo
			+ "', 'valor': '"
			+ valor
			+ "', 'pessoa': '"
			+ pessoa.toString()
			+ "'}";
	}
}
