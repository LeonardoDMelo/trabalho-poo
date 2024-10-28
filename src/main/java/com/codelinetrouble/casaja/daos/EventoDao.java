package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Evento;

public class EventoDao implements IDao<Evento, Integer>{
	private List<Evento> eventos;

	public EventoDao() {
		this.eventos = new ArrayList<>();
	}

	@Override
	public Integer create(Evento entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (eventos.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Evento> entities) {
		Integer counter = 0;
		
		for(Evento entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (eventos.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Evento find(Integer id) {
		for(Evento evento: eventos) {
			if (evento.getId().equals(id)) {
				return evento;
			}
		}

		return null;
	}

	@Override
	public List<Evento> find(List<Integer> ids) {
		List<Evento> entities = new ArrayList<>();

		for(Evento evento: eventos) {
			if (ids.contains(evento.getId())) {
				ids.remove(evento.getId());
				entities.add(evento);
			}
		}

		return entities;
	}

	@Override
	public List<Evento> find() {
		return eventos;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Evento evento: eventos) {
			if (evento.getId().equals(id)) {
				eventos.remove(evento);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()) {
			Evento evento = it.next();

			if (ids.contains(evento.getId())) {
				ids.remove(evento.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Evento entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Evento evento: eventos) {
			if (evento.getId().equals(id)) {
				eventos.remove(evento);
				eventos.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
