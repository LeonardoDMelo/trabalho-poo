package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PagamentoDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	PessoaDto pessoa,
	LocalDate data,
	String descricao,
	FornecedorDto fornecedor,
	Double valor,
	Integer parcelas) {

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
			+ "', 'data': '"
			+ data
			+ "', 'descricao': '"
			+ descricao
			+ "', 'fornecedor': '"
			+ fornecedor.toString()
			+ "', 'valor': '"
			+ valor
			+ "', 'parcelas': '"
			+ parcelas
			+ "'}";
	}
}
