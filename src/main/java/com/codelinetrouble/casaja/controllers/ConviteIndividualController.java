package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.ConviteIndividualDto;
import main.java.com.codelinetrouble.casaja.services.ConviteIndividualService;

public class ConviteIndividualController implements ICrudController<ConviteIndividualDto, Integer>{
	private final ConviteIndividualService conviteIndividualService;

	public ConviteIndividualController(ConviteIndividualService conviteIndividualService) {
		this.conviteIndividualService = conviteIndividualService;
	}

	@Override
	public Boolean create(ConviteIndividualDto dto) {
		return conviteIndividualService.create(dto);
	}

	@Override
	public Integer create(List<ConviteIndividualDto> dtos) {
		return conviteIndividualService.create(dtos);
	}

	@Override
	public ConviteIndividualDto find(Integer id) {
		return conviteIndividualService.find(id);
	}

	@Override
	public List<ConviteIndividualDto> find(List<Integer> ids) {
		return conviteIndividualService.find(ids);
	}

	@Override
	public List<ConviteIndividualDto> find() {
		return conviteIndividualService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return conviteIndividualService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return conviteIndividualService.remove(ids);
	}

	@Override
	public Boolean update(ConviteIndividualDto dto, Integer id) {
		return conviteIndividualService.update(dto, id);
	}
}
