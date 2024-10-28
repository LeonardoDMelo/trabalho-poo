package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.EventoDto;
import main.java.com.codelinetrouble.casaja.services.EventoService;

public class EventoController implements ICrudController<EventoDto, Integer>{
	private final EventoService eventoService;

	public EventoController(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@Override
	public Boolean create(EventoDto dto) {
		return eventoService.create(dto);
	}

	@Override
	public Integer create(List<EventoDto> dtos) {
		return eventoService.create(dtos);
	}

	@Override
	public EventoDto find(Integer id) {
		return eventoService.find(id);
	}

	@Override
	public List<EventoDto> find(List<Integer> ids) {
		return eventoService.find(ids);
	}

	@Override
	public List<EventoDto> find() {
		return eventoService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return eventoService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return eventoService.remove(ids);
	}

	@Override
	public Boolean update(EventoDto dto, Integer id) {
		return eventoService.update(dto, id);
	}
}
