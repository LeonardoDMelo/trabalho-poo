package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.CerimonialDto;
import main.java.com.codelinetrouble.casaja.services.CerimonialService;

public class CerimonialController implements ICrudController<CerimonialDto, Integer>{
	private final CerimonialService cerimonialService;

	public CerimonialController(CerimonialService cerimonialService) {
		this.cerimonialService = cerimonialService;
	}

	@Override
	public Boolean create(CerimonialDto dto) {
		return cerimonialService.create(dto);
	}

	@Override
	public Integer create(List<CerimonialDto> dtos) {
		return cerimonialService.create(dtos);
	}

	@Override
	public CerimonialDto find(Integer id) {
		return cerimonialService.find(id);
	}

	@Override
	public List<CerimonialDto> find(List<Integer> ids) {
		return cerimonialService.find(ids);
	}

	@Override
	public List<CerimonialDto> find() {
		return cerimonialService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return cerimonialService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return cerimonialService.remove(ids);
	}

	@Override
	public Boolean update(CerimonialDto dto, Integer id) {
		return cerimonialService.update(dto, id);
	}
}
