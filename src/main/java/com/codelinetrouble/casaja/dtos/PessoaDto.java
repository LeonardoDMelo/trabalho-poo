package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDate;

public record PessoaDto(
	Integer id,
	LocalDate dataCriacao,
	LocalDate dataModificacao,
	String nome,
	LocalDate nascimento,
	String telefone) {

	@Override
	public String toString() {
		return "'Pessoa': { 'id': "
			+ id
			+ ", 'dataCriacao': "
			+ dataCriacao
			+ ", 'dataModificacao': "
			+ dataModificacao
			+ ", 'nome': "
			+ nome
			+ ", 'nascimento':"
			+ nascimento
			+ ", 'telefone':"
			+ telefone
			+ "}";
	}
}
