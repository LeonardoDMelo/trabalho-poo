package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.FornecedorDto;
import main.java.com.codelinetrouble.casaja.services.FornecedorService;

public class FornecedorController implements ICrudController<FornecedorDto, Integer>{
	private final FornecedorService fornecedorService;

	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@Override
	public Boolean create(FornecedorDto dto) {
		return fornecedorService.create(dto);
	}

	@Override
	public Integer create(List<FornecedorDto> dtos) {
		return fornecedorService.create(dtos);
	}

	@Override
	public FornecedorDto find(Integer id) {
		return fornecedorService.find(id);
	}

	@Override
	public List<FornecedorDto> find(List<Integer> ids) {
		return fornecedorService.find(ids);
	}

	@Override
	public List<FornecedorDto> find() {
		return fornecedorService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return fornecedorService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return fornecedorService.remove(ids);
	}

	@Override
	public Boolean update(FornecedorDto dto, Integer id) {
		return fornecedorService.update(dto, id);
	}
}
