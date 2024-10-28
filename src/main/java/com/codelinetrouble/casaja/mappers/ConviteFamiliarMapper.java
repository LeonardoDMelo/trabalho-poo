package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.ConviteFamiliarDto;
import main.java.com.codelinetrouble.casaja.entities.ConviteFamiliar;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class ConviteFamiliarMapper implements IMapper<ConviteFamiliar, ConviteFamiliarDto>{
	private static final PessoaMapper pessoaMapper = new PessoaMapper();
	
	@Override
	public ConviteFamiliar mapToEntity(ConviteFamiliarDto dto) {
		return new ConviteFamiliar(
			dto.dataCriacao(),
			dto.dataModificacao(),
			pessoaMapper.mapToEntity(dto.pessoa()),
			dto.familia(),
			dto.acesso()
		);
	}

	@Override
	public ConviteFamiliarDto mapToDto(ConviteFamiliar entity) {
		return new ConviteFamiliarDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			pessoaMapper.mapToDto(entity.getPessoa()),
			entity.getFamilia(),
			entity.getAcesso()
		);
	}
}
