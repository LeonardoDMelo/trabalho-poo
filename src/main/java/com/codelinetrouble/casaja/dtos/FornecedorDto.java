package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.enums.EstadoPagamento;

public record FornecedorDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	String nome,
	String cnpj,
	String telefone,
	Double valorAPagar,
	Integer parcelas,
	EstadoPagamento estado) {

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
			+ "', 'cnpj': '"
			+ cnpj
			+ "', 'telefone': '"
			+ telefone
			+ "', 'valorAPagar': '"
			+ valorAPagar
			+ "', 'parcelas': '"
			+ parcelas
			+ "', 'estado': '"
			+ estado.getDescricao()
			+ "'}";
	}
}
