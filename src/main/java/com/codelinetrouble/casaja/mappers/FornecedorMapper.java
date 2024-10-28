package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.FornecedorDto;
import main.java.com.codelinetrouble.casaja.entities.Fornecedor;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class FornecedorMapper implements IMapper<Fornecedor, FornecedorDto>{
	@Override
	public Fornecedor mapToEntity(FornecedorDto dto) {
		return new Fornecedor(
			dto.dataCriacao(),
			dto.dataModificacao(),
			dto.nome(),
			dto.cnpj(),
			dto.telefone(),
			dto.valorAPagar(),
			dto.parcelas(),
			dto.estado().getCodigo()
		);
	}

	@Override
	public FornecedorDto mapToDto(Fornecedor entity) {
		return new FornecedorDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			entity.getNome(),
			entity.getCnpj(),
			entity.getTelefone(),
			entity.getValorAPagar(),
			entity.getParcelas(),
			entity.getEstado()
		);
	}
}
