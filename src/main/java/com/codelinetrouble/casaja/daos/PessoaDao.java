package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Pessoa;

public class PessoaDao implements IDao<Pessoa, Integer>{
	private List<Pessoa> pessoas;

	public PessoaDao() {
		this.pessoas = new ArrayList<>();
	}

	@Override
	public Integer create(Pessoa entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (pessoas.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Pessoa> entities) {
		Integer counter = 0;
		
		for(Pessoa entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (pessoas.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Pessoa find(Integer id) {
		for(Pessoa pessoa: pessoas) {
			if (pessoa.getId().equals(id)) {
				return pessoa;
			}
		}

		return null;
	}

	@Override
	public List<Pessoa> find(List<Integer> ids) {
		List<Pessoa> entities = new ArrayList<>();

		for(Pessoa pessoa: pessoas) {
			if (ids.contains(pessoa.getId())) {
				ids.remove(pessoa.getId());
				entities.add(pessoa);
			}
		}

		return entities;
	}

	@Override
	public List<Pessoa> find() {
		return pessoas;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Pessoa pessoa: pessoas) {
			if (pessoa.getId().equals(id)) {
				pessoas.remove(pessoa);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Pessoa> it = pessoas.iterator();
		while(it.hasNext()) {
			Pessoa pessoa = it.next();

			if (ids.contains(pessoa.getId())) {
				ids.remove(pessoa.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Pessoa entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Pessoa pessoa: pessoas) {
			if (pessoa.getId().equals(id)) {
				pessoas.remove(pessoa);
				pessoas.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
