package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.ConviteIndividual;

public class ConviteIndividualDao implements IDao<ConviteIndividual, Integer>{
	private List<ConviteIndividual> convitesIndividuais;

	public ConviteIndividualDao() {
		this.convitesIndividuais = new ArrayList<>();
	}

	@Override
	public Integer create(ConviteIndividual entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (convitesIndividuais.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<ConviteIndividual> entities) {
		Integer counter = 0;
		
		for(ConviteIndividual entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (convitesIndividuais.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public ConviteIndividual find(Integer id) {
		for(ConviteIndividual conviteIndividual: convitesIndividuais) {
			if (conviteIndividual.getId().equals(id)) {
				return conviteIndividual;
			}
		}

		return null;
	}

	@Override
	public List<ConviteIndividual> find(List<Integer> ids) {
		List<ConviteIndividual> entities = new ArrayList<>();

		for(ConviteIndividual conviteIndividual: convitesIndividuais) {
			if (ids.contains(conviteIndividual.getId())) {
				ids.remove(conviteIndividual.getId());
				entities.add(conviteIndividual);
			}
		}

		return entities;
	}

	@Override
	public List<ConviteIndividual> find() {
		return convitesIndividuais;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(ConviteIndividual conviteIndividual: convitesIndividuais) {
			if (conviteIndividual.getId().equals(id)) {
				convitesIndividuais.remove(conviteIndividual);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<ConviteIndividual> it = convitesIndividuais.iterator();
		while(it.hasNext()) {
			ConviteIndividual conviteIndividual = it.next();

			if (ids.contains(conviteIndividual.getId())) {
				ids.remove(conviteIndividual.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(ConviteIndividual entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(ConviteIndividual conviteIndividual: convitesIndividuais) {
			if (conviteIndividual.getId().equals(id)) {
				convitesIndividuais.remove(conviteIndividual);
				convitesIndividuais.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
