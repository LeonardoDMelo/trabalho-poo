package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Pagamento;

public class PagamentoDao implements IDao<Pagamento, Integer>{
	private List<Pagamento> pagamentos;

	public PagamentoDao() {
		this.pagamentos = new ArrayList<>();
	}

	@Override
	public Integer create(Pagamento entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (pagamentos.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Pagamento> entities) {
		Integer counter = 0;
		
		for(Pagamento entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (pagamentos.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Pagamento find(Integer id) {
		for(Pagamento pagamento: pagamentos) {
			if (pagamento.getId().equals(id)) {
				return pagamento;
			}
		}

		return null;
	}

	@Override
	public List<Pagamento> find(List<Integer> ids) {
		List<Pagamento> entities = new ArrayList<>();

		for(Pagamento pagamento: pagamentos) {
			if (ids.contains(pagamento.getId())) {
				ids.remove(pagamento.getId());
				entities.add(pagamento);
			}
		}

		return entities;
	}

	@Override
	public List<Pagamento> find() {
		return pagamentos;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Pagamento pagamento: pagamentos) {
			if (pagamento.getId().equals(id)) {
				pagamentos.remove(pagamento);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Pagamento> it = pagamentos.iterator();
		while(it.hasNext()) {
			Pagamento pagamento = it.next();

			if (ids.contains(pagamento.getId())) {
				ids.remove(pagamento.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Pagamento entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Pagamento pagamento: pagamentos) {
			if (pagamento.getId().equals(id)) {
				pagamentos.remove(pagamento);
				pagamentos.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
