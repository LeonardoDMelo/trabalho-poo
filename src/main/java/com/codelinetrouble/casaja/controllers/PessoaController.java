package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.services.PessoaService;

public class PessoaController implements ICrudController<PessoaDto, Integer>{
	private final PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@Override
	public Boolean create(PessoaDto dto) {
		return pessoaService.create(dto);
	}

	@Override
	public Integer create(List<PessoaDto> dtos) {
		return pessoaService.create(dtos);
	}

	@Override
	public PessoaDto find(Integer id) {
		return pessoaService.find(id);
	}

	@Override
	public List<PessoaDto> find(List<Integer> ids) {
		return pessoaService.find(ids);
	}

	@Override
	public List<PessoaDto> find() {
		return pessoaService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return pessoaService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return pessoaService.remove(ids);
	}

	@Override
	public Boolean update(PessoaDto dto, Integer id) {
		return pessoaService.update(dto, id);
	}
}
