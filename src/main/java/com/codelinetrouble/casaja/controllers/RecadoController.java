package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.RecadoDto;
import main.java.com.codelinetrouble.casaja.services.RecadoService;

public class RecadoController implements ICrudController<RecadoDto, Integer>{
	private final RecadoService recadoService;

	public RecadoController(RecadoService recadoService) {
		this.recadoService = recadoService;
	}

	@Override
	public Boolean create(RecadoDto dto) {
		return recadoService.create(dto);
	}

	@Override
	public Integer create(List<RecadoDto> dtos) {
		return recadoService.create(dtos);
	}

	@Override
	public RecadoDto find(Integer id) {
		return recadoService.find(id);
	}

	@Override
	public List<RecadoDto> find(List<Integer> ids) {
		return recadoService.find(ids);
	}

	@Override
	public List<RecadoDto> find() {
		return recadoService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return recadoService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return recadoService.remove(ids);
	}

	@Override
	public Boolean update(RecadoDto dto, Integer id) {
		return recadoService.update(dto, id);
	}
}
