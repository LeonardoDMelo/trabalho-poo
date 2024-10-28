package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.ConviteFamiliarDto;
import main.java.com.codelinetrouble.casaja.services.ConviteFamiliarService;

public class ConviteFamiliarController implements ICrudController<ConviteFamiliarDto, Integer>{
	private final ConviteFamiliarService conviteFamiliarService;

	public ConviteFamiliarController(ConviteFamiliarService conviteFamiliarService) {
		this.conviteFamiliarService = conviteFamiliarService;
	}

	@Override
	public Boolean create(ConviteFamiliarDto dto) {
		return conviteFamiliarService.create(dto);
	}

	@Override
	public Integer create(List<ConviteFamiliarDto> dtos) {
		return conviteFamiliarService.create(dtos);
	}

	@Override
	public ConviteFamiliarDto find(Integer id) {
		return conviteFamiliarService.find(id);
	}

	@Override
	public List<ConviteFamiliarDto> find(List<Integer> ids) {
		return conviteFamiliarService.find(ids);
	}

	@Override
	public List<ConviteFamiliarDto> find() {
		return conviteFamiliarService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return conviteFamiliarService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return conviteFamiliarService.remove(ids);
	}

	@Override
	public Boolean update(ConviteFamiliarDto dto, Integer id) {
		return conviteFamiliarService.update(dto, id);
	}
}
