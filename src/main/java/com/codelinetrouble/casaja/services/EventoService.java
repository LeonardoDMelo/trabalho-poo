package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.EventoDao;
import main.java.com.codelinetrouble.casaja.dtos.EventoDto;
import main.java.com.codelinetrouble.casaja.entities.Evento;
import main.java.com.codelinetrouble.casaja.mappers.EventoMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class EventoService implements ICrudService<EventoDto, Integer> {
	private final EventoDao eventoDao;
	private final EventoMapper eventoMapper;

	public EventoService(
		EventoDao eventoDao,
		EventoMapper eventoMapper) {

		this.eventoDao = eventoDao;
		this.eventoMapper = eventoMapper;
	}

	@Override
	public Boolean create(EventoDto dto) {
		Evento evento = eventoMapper.mapToEntity(dto);

		return eventoDao.create(evento).equals(1);
	}

	@Override
	public Integer create(List<EventoDto> dtos) {
		List<Evento> eventos = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> eventos.add(eventoMapper.mapToEntity(dto)));

		return eventoDao.create(eventos);
	}

	@Override
	public EventoDto find(Integer id) {
		Evento evento = eventoDao.find(id);

		if (evento == null) {
			return null;
		}
		
		return eventoMapper.mapToDto(evento);
	}
	
	@Override
	public List<EventoDto> find(List<Integer> ids) {
		List<EventoDto> eventosDto = new ArrayList<>();
		List<Evento> eventos = eventoDao.find(ids);

		eventos
			.stream()
			.forEach(entity -> eventosDto.add(eventoMapper.mapToDto(entity)));

		return eventosDto;
	}

	@Override
	public List<EventoDto> find() {
		List<Evento> eventos = eventoDao.find();
		List<EventoDto> eventosDto = new ArrayList<>();

		eventos
			.stream()
			.forEach(entity -> eventosDto.add(eventoMapper.mapToDto(entity)));

		return eventosDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return eventoDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return eventoDao.remove(ids);
	}

	@Override
	public Boolean update(EventoDto dto, Integer id) {
		return eventoDao.update(eventoMapper.mapToEntity(dto), id).equals(1);
	}
	
}
