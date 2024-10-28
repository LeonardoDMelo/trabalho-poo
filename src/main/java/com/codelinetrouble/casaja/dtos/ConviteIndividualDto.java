package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;

public record ConviteIndividualDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	PessoaDto pessoa,
	String familia,
	String parentesco,
	Boolean confirmacao) {

	@Override
	public String toString() {
		return "{ 'id': '"
			+ id
			+ "', 'dataCriacao': '"
			+ dataCriacao
			+ "', 'dataModificacao': '"
			+ dataModificacao
			+ "', 'pessoa': '"
			+ pessoa.toString()
			+ "', 'familia': '"
			+ familia
			+ "', 'parentesco': '"
			+ parentesco
			+ "', 'confirmacao': '"
			+ confirmacao
			+ "'}";
	}
}
