package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Cartorio;
import main.java.com.codelinetrouble.casaja.entities.Fornecedor;

public class CartorioDao implements IDao<Cartorio, Integer>{
	private List<Cartorio> cartorios;

	public CartorioDao() {
		this.cartorios = new ArrayList<>();
	}

	@Override
	public Integer create(Cartorio entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (cartorios.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Cartorio> entities) {
		Integer counter = 0;
		
		for(Cartorio entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (cartorios.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Cartorio find(Integer id) {
		for(Cartorio cartorio: cartorios) {
			if (cartorio.getId().equals(id)) {
				return cartorio;
			}
		}

		return null;
	}

	@Override
	public List<Cartorio> find(List<Integer> ids) {
		List<Cartorio> entities = new ArrayList<>();

		for(Cartorio cartorio: cartorios) {
			if (ids.contains(cartorio.getId())) {
				ids.remove(cartorio.getId());
				entities.add(cartorio);
			}
		}

		return entities;
	}

	@Override
	public List<Cartorio> find() {
		return cartorios;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Cartorio cartorio: cartorios) {
			if (cartorio.getId().equals(id)) {
				cartorios.remove(cartorio);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Cartorio> it = cartorios.iterator();
		while(it.hasNext()) {
			Cartorio cartorio = it.next();

			if (ids.contains(cartorio.getId())) {
				ids.remove(cartorio.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Cartorio entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Cartorio cartorio: cartorios) {
			if (cartorio.getId().equals(id)) {
				cartorios.remove(cartorio);
				cartorios.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
