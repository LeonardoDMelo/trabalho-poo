package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.PresenteDto;
import main.java.com.codelinetrouble.casaja.services.PresenteService;

public class PresenteController implements ICrudController<PresenteDto, Integer>{
	private final PresenteService presenteService;

	public PresenteController(PresenteService presenteService) {
		this.presenteService = presenteService;
	}

	@Override
	public Boolean create(PresenteDto dto) {
		return presenteService.create(dto);
	}

	@Override
	public Integer create(List<PresenteDto> dtos) {
		return presenteService.create(dtos);
	}

	@Override
	public PresenteDto find(Integer id) {
		return presenteService.find(id);
	}

	@Override
	public List<PresenteDto> find(List<Integer> ids) {
		return presenteService.find(ids);
	}

	@Override
	public List<PresenteDto> find() {
		return presenteService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return presenteService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return presenteService.remove(ids);
	}

	@Override
	public Boolean update(PresenteDto dto, Integer id) {
		return presenteService.update(dto, id);
	}
}
