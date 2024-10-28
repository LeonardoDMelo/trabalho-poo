package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.IgrejaDto;
import main.java.com.codelinetrouble.casaja.services.IgrejaService;

public class IgrejaController implements ICrudController<IgrejaDto, Integer>{
	private final IgrejaService igrejaService;

	public IgrejaController(IgrejaService igrejaService) {
		this.igrejaService = igrejaService;
	}

	@Override
	public Boolean create(IgrejaDto dto) {
		return igrejaService.create(dto);
	}

	@Override
	public Integer create(List<IgrejaDto> dtos) {
		return igrejaService.create(dtos);
	}

	@Override
	public IgrejaDto find(Integer id) {
		return igrejaService.find(id);
	}

	@Override
	public List<IgrejaDto> find(List<Integer> ids) {
		return igrejaService.find(ids);
	}

	@Override
	public List<IgrejaDto> find() {
		return igrejaService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return igrejaService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return igrejaService.remove(ids);
	}

	@Override
	public Boolean update(IgrejaDto dto, Integer id) {
		return igrejaService.update(dto, id);
	}
}
