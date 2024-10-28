package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.PresenteDto;
import main.java.com.codelinetrouble.casaja.entities.Presente;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class PresenteMapper implements IMapper<Presente, PresenteDto>{
	private static final PessoaMapper pessoaMapper = new PessoaMapper();
	
	@Override
	public Presente mapToEntity(PresenteDto dto) {
		return new Presente(
			dto.dataCriacao(),
			dto.dataModificacao(),
			dto.nome(),
			dto.tipo(),
			dto.valor(),
			pessoaMapper.mapToEntity(dto.pessoa())
		);
	}

	@Override
	public PresenteDto mapToDto(Presente entity) {
		return new PresenteDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			entity.getNome(),
			entity.getTipo(),
			entity.getValor(),
			pessoaMapper.mapToDto(entity.getPessoa())
		);
	}
}
