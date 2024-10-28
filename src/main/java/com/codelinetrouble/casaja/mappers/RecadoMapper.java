package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.RecadoDto;
import main.java.com.codelinetrouble.casaja.entities.Recado;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class RecadoMapper implements IMapper<Recado, RecadoDto>{
	private static final PessoaMapper pessoaMapper = new PessoaMapper();
	
	@Override
	public Recado mapToEntity(RecadoDto dto) {
		return new Recado(
			dto.dataCriacao(),
			dto.dataModificacao(),
			pessoaMapper.mapToEntity(dto.pessoa()),
			dto.comentario()
		);
	}

	@Override
	public RecadoDto mapToDto(Recado entity) {
		return new RecadoDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			pessoaMapper.mapToDto(entity.getPessoa()),
			entity.getComentario()
		);
	}
}
