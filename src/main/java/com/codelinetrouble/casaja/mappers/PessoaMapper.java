package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.entities.Pessoa;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class PessoaMapper implements IMapper<Pessoa, PessoaDto>{
	@Override
	public Pessoa mapToEntity(PessoaDto dto) {
		return new Pessoa(
			dto.dataCriacao(),
			dto.dataModificacao(),
			dto.nome(),
			dto.nascimento(),
			dto.telefone());
	}

	@Override
	public PessoaDto mapToDto(Pessoa entity) {
		return new PessoaDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			entity.getNome(),
			entity.getNascimento(),
			entity.getTelefone());
	}
}
