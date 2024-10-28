package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.UsuarioDao;
import main.java.com.codelinetrouble.casaja.dtos.UsuarioDto;
import main.java.com.codelinetrouble.casaja.entities.Usuario;
import main.java.com.codelinetrouble.casaja.mappers.UsuarioMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class UsuarioService implements ICrudService<UsuarioDto, Integer> {
	private final UsuarioDao usuarioDao;
	private final UsuarioMapper usuarioMapper;

	public UsuarioService(UsuarioDao usuarioDao, UsuarioMapper usuarioMapper) {
		this.usuarioDao = usuarioDao;
		this.usuarioMapper = usuarioMapper;
	}

	@Override
	public Boolean create(UsuarioDto dto) {
		Usuario usuario = usuarioMapper.mapToEntity(dto);

		return usuarioDao.create(usuario).equals(1);
	}

	@Override
	public Integer create(List<UsuarioDto> dtos) {
		List<Usuario> usuarios = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> usuarios.add(usuarioMapper.mapToEntity(dto)));

		return usuarioDao.create(usuarios);
	}

	@Override
	public UsuarioDto find(Integer id) {
		Usuario usuario = usuarioDao.find(id);

		if (usuario == null) {
			return null;
		}
		
		return usuarioMapper.mapToDto(usuario);
	}
	
	@Override
	public List<UsuarioDto> find(List<Integer> ids) {
		List<UsuarioDto> usuariosDto = new ArrayList<>();
		List<Usuario> usuarios = usuarioDao.find(ids);

		usuarios
			.stream()
			.forEach(entity -> usuariosDto.add(usuarioMapper.mapToDto(entity)));

		return usuariosDto;
	}

	@Override
	public List<UsuarioDto> find() {
		List<Usuario> usuarios = usuarioDao.find();
		List<UsuarioDto> usuariosDto = new ArrayList<>();

		usuarios
			.stream()
			.forEach(entity -> usuariosDto.add(usuarioMapper.mapToDto(entity)));

		return usuariosDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return usuarioDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return usuarioDao.remove(ids);
	}

	@Override
	public Boolean update(UsuarioDto dto, Integer id) {
		return usuarioDao.update(usuarioMapper.mapToEntity(dto), id).equals(1);
	}
	
}
