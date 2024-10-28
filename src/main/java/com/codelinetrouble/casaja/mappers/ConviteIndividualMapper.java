package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.ConviteIndividualDto;
import main.java.com.codelinetrouble.casaja.entities.ConviteIndividual;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class ConviteIndividualMapper implements IMapper<ConviteIndividual, ConviteIndividualDto>{
	private static final PessoaMapper pessoaMapper = new PessoaMapper();
	
	@Override
	public ConviteIndividual mapToEntity(ConviteIndividualDto dto) {
		return new ConviteIndividual(
			dto.dataCriacao(),
			dto.dataModificacao(),
			pessoaMapper.mapToEntity(dto.pessoa()),
			dto.familia(),
			dto.parentesco(),
			dto.confirmacao()
		);
	}

	@Override
	public ConviteIndividualDto mapToDto(ConviteIndividual entity) {
		return new ConviteIndividualDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			pessoaMapper.mapToDto(entity.getPessoa()),
			entity.getFamilia(),
			entity.getParentesco(),
			entity.getConfirmacao()
		);
	}
}
