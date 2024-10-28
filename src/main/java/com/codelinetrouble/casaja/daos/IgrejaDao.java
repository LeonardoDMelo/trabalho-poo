package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Igreja;

public class IgrejaDao implements IDao<Igreja, Integer>{
	private List<Igreja> igrejas;

	public IgrejaDao() {
		this.igrejas = new ArrayList<>();
	}

	@Override
	public Integer create(Igreja entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (igrejas.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Igreja> entities) {
		Integer counter = 0;
		
		for(Igreja entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (igrejas.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Igreja find(Integer id) {
		for(Igreja igreja: igrejas) {
			if (igreja.getId().equals(id)) {
				return igreja;
			}
		}

		return null;
	}

	@Override
	public List<Igreja> find(List<Integer> ids) {
		List<Igreja> entities = new ArrayList<>();

		for(Igreja igreja: igrejas) {
			if (ids.contains(igreja.getId())) {
				ids.remove(igreja.getId());
				entities.add(igreja);
			}
		}

		return entities;
	}

	@Override
	public List<Igreja> find() {
		return igrejas;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Igreja igreja: igrejas) {
			if (igreja.getId().equals(id)) {
				igrejas.remove(igreja);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Igreja> it = igrejas.iterator();
		while(it.hasNext()) {
			Igreja igreja = it.next();

			if (ids.contains(igreja.getId())) {
				ids.remove(igreja.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Igreja entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Igreja igreja: igrejas) {
			if (igreja.getId().equals(id)) {
				igrejas.remove(igreja);
				igrejas.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
