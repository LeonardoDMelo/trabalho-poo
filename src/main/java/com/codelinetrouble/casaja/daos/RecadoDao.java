package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Recado;

public class RecadoDao implements IDao<Recado, Integer>{
	private List<Recado> recados;

	public RecadoDao() {
		this.recados = new ArrayList<>();
	}

	@Override
	public Integer create(Recado entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (recados.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Recado> entities) {
		Integer counter = 0;
		
		for(Recado entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (recados.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Recado find(Integer id) {
		for(Recado recado: recados) {
			if (recado.getId().equals(id)) {
				return recado;
			}
		}

		return null;
	}

	@Override
	public List<Recado> find(List<Integer> ids) {
		List<Recado> entities = new ArrayList<>();

		for(Recado recado: recados) {
			if (ids.contains(recado.getId())) {
				ids.remove(recado.getId());
				entities.add(recado);
			}
		}

		return entities;
	}

	@Override
	public List<Recado> find() {
		return recados;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Recado recado: recados) {
			if (recado.getId().equals(id)) {
				recados.remove(recado);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Recado> it = recados.iterator();
		while(it.hasNext()) {
			Recado recado = it.next();

			if (ids.contains(recado.getId())) {
				ids.remove(recado.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Recado entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Recado recado: recados) {
			if (recado.getId().equals(id)) {
				recados.remove(recado);
				recados.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
