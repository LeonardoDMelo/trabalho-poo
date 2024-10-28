package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.UsuarioDto;
import main.java.com.codelinetrouble.casaja.services.UsuarioService;

public class UsuarioController implements ICrudController<UsuarioDto, Integer>{
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public Boolean create(UsuarioDto dto) {
		return usuarioService.create(dto);
	}

	@Override
	public Integer create(List<UsuarioDto> dtos) {
		return usuarioService.create(dtos);
	}

	@Override
	public UsuarioDto find(Integer id) {
		return usuarioService.find(id);
	}

	@Override
	public List<UsuarioDto> find(List<Integer> ids) {
		return usuarioService.find(ids);
	}

	@Override
	public List<UsuarioDto> find() {
		return usuarioService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return usuarioService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return usuarioService.remove(ids);
	}

	@Override
	public Boolean update(UsuarioDto dto, Integer id) {
		return usuarioService.update(dto, id);
	}
}
