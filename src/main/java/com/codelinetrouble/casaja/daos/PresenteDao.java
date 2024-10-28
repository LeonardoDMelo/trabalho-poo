package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Presente;

public class PresenteDao implements IDao<Presente, Integer>{
	private List<Presente> presentes;

	public PresenteDao() {
		this.presentes = new ArrayList<>();
	}

	@Override
	public Integer create(Presente entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (presentes.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Presente> entities) {
		Integer counter = 0;
		
		for(Presente entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (presentes.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Presente find(Integer id) {
		for(Presente presente: presentes) {
			if (presente.getId().equals(id)) {
				return presente;
			}
		}

		return null;
	}

	@Override
	public List<Presente> find(List<Integer> ids) {
		List<Presente> entities = new ArrayList<>();

		for(Presente presente: presentes) {
			if (ids.contains(presente.getId())) {
				ids.remove(presente.getId());
				entities.add(presente);
			}
		}

		return entities;
	}

	@Override
	public List<Presente> find() {
		return presentes;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Presente presente: presentes) {
			if (presente.getId().equals(id)) {
				presentes.remove(presente);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Presente> it = presentes.iterator();
		while(it.hasNext()) {
			Presente presente = it.next();

			if (ids.contains(presente.getId())) {
				ids.remove(presente.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Presente entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Presente presente: presentes) {
			if (presente.getId().equals(id)) {
				presentes.remove(presente);
				presentes.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
