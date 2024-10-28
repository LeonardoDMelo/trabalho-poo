package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Cerimonial;

public class CerimonialDao implements IDao<Cerimonial, Integer>{
	private List<Cerimonial> cerimoniais;

	public CerimonialDao() {
		this.cerimoniais = new ArrayList<>();
	}

	@Override
	public Integer create(Cerimonial entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (cerimoniais.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Cerimonial> entities) {
		Integer counter = 0;
		
		for(Cerimonial entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (cerimoniais.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Cerimonial find(Integer id) {
		for(Cerimonial cerimonial: cerimoniais) {
			if (cerimonial.getId().equals(id)) {
				return cerimonial;
			}
		}

		return null;
	}

	@Override
	public List<Cerimonial> find(List<Integer> ids) {
		List<Cerimonial> entities = new ArrayList<>();

		for(Cerimonial cerimonial: cerimoniais) {
			if (ids.contains(cerimonial.getId())) {
				ids.remove(cerimonial.getId());
				entities.add(cerimonial);
			}
		}

		return entities;
	}

	@Override
	public List<Cerimonial> find() {
		return cerimoniais;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Cerimonial cerimonial: cerimoniais) {
			if (cerimonial.getId().equals(id)) {
				cerimoniais.remove(cerimonial);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Cerimonial> it = cerimoniais.iterator();
		while(it.hasNext()) {
			Cerimonial cerimonial = it.next();

			if (ids.contains(cerimonial.getId())) {
				ids.remove(cerimonial.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Cerimonial entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Cerimonial cerimonial: cerimoniais) {
			if (cerimonial.getId().equals(id)) {
				cerimoniais.remove(cerimonial);
				cerimoniais.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
