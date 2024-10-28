package main.java.com.codelinetrouble.casaja.dtos;

import java.time.LocalDateTime;
import java.time.LocalDate;

public record EventoDto(
	Integer id,
	LocalDateTime dataCriacao,
	LocalDateTime dataModificacao,
	LocalDate data,
	CerimonialDto cerimonial,
	IgrejaDto igreja,
	CartorioDto cartorio,
	PessoaDto noiva,
	PessoaDto noivo) {

	@Override
	public String toString() {
		return "{ 'id': '"
			+ id
			+ "', 'dataCriacao': '"
			+ dataCriacao
			+ "', 'dataModificacao': '"
			+ dataModificacao
			+ "', 'data': '"
			+ data
			+ "', 'cerimonial': '"
			+ cerimonial.toString()
			+ "', 'igreja': '"
			+ igreja.toString()
			+ "', 'cartorio': '"
			+ cartorio.toString()
			+ "', 'noiva': '"
			+ noiva.toString()
			+ "', 'noivo': '"
			+ noivo.toString()
			+ "'}";
	}
}
