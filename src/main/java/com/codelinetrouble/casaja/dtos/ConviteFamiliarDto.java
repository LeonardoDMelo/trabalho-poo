package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;

public record ConviteFamiliaDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	PessoaDto pessoa,
	String familia,
	String acesso) {

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
			+ "', 'acesso': '"
			+ acesso
			+ "'}";
	}
}
