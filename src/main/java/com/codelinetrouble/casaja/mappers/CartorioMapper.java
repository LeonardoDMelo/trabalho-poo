package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.CartorioDto;
import main.java.com.codelinetrouble.casaja.entities.Cartorio;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class CartorioMapper implements IMapper<Cartorio, CartorioDto>{
	@Override
	public Cartorio mapToEntity(CartorioDto dto) {
		return new Cartorio(
			dto.dataCriacao(),
			dto.dataModificacao()
		);
	}

	@Override
	public CartorioDto mapToDto(Cartorio entity) {
		return new CartorioDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao()
		);
	}
}
