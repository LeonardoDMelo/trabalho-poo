package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.CerimonialDto;
import main.java.com.codelinetrouble.casaja.entities.Cerimonial;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class CerimonialMapper implements IMapper<Cerimonial, CerimonialDto>{
	@Override
	public Cerimonial mapToEntity(CerimonialDto dto) {
		return new Cerimonial(
			dto.dataCriacao(),
			dto.dataModificacao()
		);
	}

	@Override
	public CerimonialDto mapToDto(Cerimonial entity) {
		return new CerimonialDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao()
		);
	}
}
