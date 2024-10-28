package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.PagamentoDto;
import main.java.com.codelinetrouble.casaja.services.PagamentoService;

public class PagamentoController implements ICrudController<PagamentoDto, Integer>{
	private final PagamentoService pagamentoService;

	public PagamentoController(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

	@Override
	public Boolean create(PagamentoDto dto) {
		return pagamentoService.create(dto);
	}

	@Override
	public Integer create(List<PagamentoDto> dtos) {
		return pagamentoService.create(dtos);
	}

	@Override
	public PagamentoDto find(Integer id) {
		return pagamentoService.find(id);
	}

	@Override
	public List<PagamentoDto> find(List<Integer> ids) {
		return pagamentoService.find(ids);
	}

	@Override
	public List<PagamentoDto> find() {
		return pagamentoService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return pagamentoService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return pagamentoService.remove(ids);
	}

	@Override
	public Boolean update(PagamentoDto dto, Integer id) {
		return pagamentoService.update(dto, id);
	}
}
