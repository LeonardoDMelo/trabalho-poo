package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.EventoDto;
import main.java.com.codelinetrouble.casaja.entities.Evento;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class EventoMapper implements IMapper<Evento, EventoDto>{
	private static final PessoaMapper pessoaMapper = new PessoaMapper();
	private static final CerimonialMapper cerimonialMapper = new CerimonialMapper();
	private static final IgrejaMapper igrejaMapper = new IgrejaMapper();
	private static final CartorioMapper cartorioMapper = new CartorioMapper();
	
	@Override
	public Evento mapToEntity(EventoDto dto) {
		return new Evento(
			dto.dataCriacao(),
			dto.dataModificacao(),
			dto.data(),
			cerimonialMapper.mapToEntity(dto.cerimonial()),
			igrejaMapper.mapToEntity(dto.igreja()),
			cartorioMapper.mapToEntity(dto.cartorio()),
			pessoaMapper.mapToEntity(dto.noiva()),
			pessoaMapper.mapToEntity(dto.noivo())
		);
	}

	@Override
	public EventoDto mapToDto(Evento entity) {
		return new EventoDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			entity.getData(),
			cerimonialMapper.mapToDto(entity.getCerimonial()),
			igrejaMapper.mapToDto(entity.getIgreja()),
			cartorioMapper.mapToDto(entity.getCartorio()),
			pessoaMapper.mapToDto(entity.getNoiva()),
			pessoaMapper.mapToDto(entity.getNoivo())
		);
	}
}
