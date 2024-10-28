package main.java.com.codelinetrouble.casaja.mappers;

import main.java.com.codelinetrouble.casaja.dtos.UsuarioDto;
import main.java.com.codelinetrouble.casaja.entities.Usuario;
import main.java.com.codelinetrouble.casaja.mappers.interfaces.IMapper;

public final class UsuarioMapper implements IMapper<Usuario, UsuarioDto>{
	private final PessoaMapper pessoaMapper = new PessoaMapper();

	@Override
	public Usuario mapToEntity(UsuarioDto dto) {
		return new Usuario(
			dto.dataCriacao(),
			dto.dataModificacao(),
			pessoaMapper.mapToEntity(dto.pessoa()),
			dto.tipo().getCodigo(),
			dto.login(),
			dto.senha()
		);
	}

	@Override
	public UsuarioDto mapToDto(Usuario entity) {
		return new UsuarioDto(
			entity.getId(),
			entity.getDataCriacao(),
			entity.getDataModificacao(),
			pessoaMapper.mapToDto(entity.getPessoa()),
			entity.getTipo(),
			entity.getLogin(),
			entity.getSenha()
		);
	}
}
