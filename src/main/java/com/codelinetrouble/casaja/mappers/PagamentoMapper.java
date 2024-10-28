package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.PagamentoDto;
import main.java.com.codelinetrouble.casaja.entities.Pagamento;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class PagamentoMapper implements IMapper<Pagamento, PagamentoDto> {
	private static final FornecedorMapper fornecedorMapper = new FornecedorMapper();
	private static final PessoaMapper pessoaMapper = new PessoaMapper();
	
	@Override
	public Pagamento mapToEntity(PagamentoDto dto) {
		return new Pagamento(
			dto.dataCriacao(),
			dto.dataModificacao(),
			pessoaMapper.mapToEntity(dto.pessoa()),
			dto.data(),
			dto.descricao(),
			fornecedorMapper.mapToEntity(dto.fornecedor()),
			dto.valor(),
			dto.parcelas()
		);
	}

	@Override
	public PagamentoDto mapToDto(Pagamento entity) {
		return new PagamentoDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			pessoaMapper.mapToDto(entity.getPessoa()),
			entity.getData(),
			entity.getDescricao(),
			fornecedorMapper.mapToDto(entity.getFornecedor()),
			entity.getValor(),
			entity.getParcelas()
		);
	}
}
