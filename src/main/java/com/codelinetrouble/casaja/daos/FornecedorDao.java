package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Fornecedor;

public class FornecedorDao implements IDao<Fornecedor, Integer>{
	private List<Fornecedor> fornecedores;

	public FornecedorDao() {
		this.fornecedores = new ArrayList<>();
	}

	@Override
	public Integer create(Fornecedor entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (fornecedores.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Fornecedor> entities) {
		Integer counter = 0;
		
		for(Fornecedor entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (fornecedores.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Fornecedor find(Integer id) {
		for(Fornecedor fornecedor: fornecedores) {
			if (fornecedor.getId().equals(id)) {
				return fornecedor;
			}
		}

		return null;
	}

	@Override
	public List<Fornecedor> find(List<Integer> ids) {
		List<Fornecedor> entities = new ArrayList<>();

		for(Fornecedor fornecedor: fornecedores) {
			if (ids.contains(fornecedor.getId())) {
				ids.remove(fornecedor.getId());
				entities.add(fornecedor);
			}
		}

		return entities;
	}

	@Override
	public List<Fornecedor> find() {
		return fornecedores;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Fornecedor fornecedor: fornecedores) {
			if (fornecedor.getId().equals(id)) {
				fornecedores.remove(fornecedor);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Fornecedor> it = fornecedores.iterator();
		while(it.hasNext()) {
			Fornecedor fornecedor = it.next();

			if (ids.contains(fornecedor.getId())) {
				ids.remove(fornecedor.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Fornecedor entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Fornecedor fornecedor: fornecedores) {
			if (fornecedor.getId().equals(id)) {
				fornecedores.remove(fornecedor);
				fornecedores.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
