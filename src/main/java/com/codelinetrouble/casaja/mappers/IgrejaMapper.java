package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.IgrejaDto;
import main.java.com.codelinetrouble.casaja.entities.Igreja;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class IgrejaMapper implements IMapper<Igreja, IgrejaDto>{
	@Override
	public Igreja mapToEntity(IgrejaDto dto) {
		return new Igreja(
			dto.dataCriacao(),
			dto.dataModificacao()
		);
	}

	@Override
	public IgrejaDto mapToDto(Igreja entity) {
		return new IgrejaDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao()
		);
	}
}
