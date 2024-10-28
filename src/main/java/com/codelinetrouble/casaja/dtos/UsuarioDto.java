package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.enums.TipoUsuario;

public record UsuarioDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	PessoaDto pessoa,
	TipoUsuario tipo,
	String login,
	String senha) {

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
			+ "', 'tipo': '"
			+ tipo.getDescricao()
			+ "', 'login': '"
			+ login
			+ "', 'senha': '"
			+ senha
			+ "'}";
	}
}
