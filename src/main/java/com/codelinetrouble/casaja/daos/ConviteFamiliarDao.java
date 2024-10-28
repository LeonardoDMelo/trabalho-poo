package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.ConviteFamiliar;

public class ConviteFamiliarDao implements IDao<ConviteFamiliar, Integer>{
	private List<ConviteFamiliar> convitesFamiliares;

	public ConviteFamiliarDao() {
		this.convitesFamiliares = new ArrayList<>();
	}

	@Override
	public Integer create(ConviteFamiliar entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (convitesFamiliares.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<ConviteFamiliar> entities) {
		Integer counter = 0;
		
		for(ConviteFamiliar entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (convitesFamiliares.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public ConviteFamiliar find(Integer id) {
		for(ConviteFamiliar conviteFamiliar: convitesFamiliares) {
			if (conviteFamiliar.getId().equals(id)) {
				return conviteFamiliar;
			}
		}

		return null;
	}

	@Override
	public List<ConviteFamiliar> find(List<Integer> ids) {
		List<ConviteFamiliar> entities = new ArrayList<>();

		for(ConviteFamiliar conviteFamiliar: convitesFamiliares) {
			if (ids.contains(conviteFamiliar.getId())) {
				ids.remove(conviteFamiliar.getId());
				entities.add(conviteFamiliar);
			}
		}

		return entities;
	}

	@Override
	public List<ConviteFamiliar> find() {
		return convitesFamiliares;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(ConviteFamiliar conviteFamiliar: convitesFamiliares) {
			if (conviteFamiliar.getId().equals(id)) {
				convitesFamiliares.remove(conviteFamiliar);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<ConviteFamiliar> it = convitesFamiliares.iterator();
		while(it.hasNext()) {
			ConviteFamiliar conviteFamiliar = it.next();

			if (ids.contains(conviteFamiliar.getId())) {
				ids.remove(conviteFamiliar.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(ConviteFamiliar entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(ConviteFamiliar conviteFamiliar: convitesFamiliares) {
			if (conviteFamiliar.getId().equals(id)) {
				convitesFamiliares.remove(conviteFamiliar);
				convitesFamiliares.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
