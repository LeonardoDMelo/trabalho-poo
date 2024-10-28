package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.PagamentoDao;
import main.java.com.codelinetrouble.casaja.dtos.PagamentoDto;
import main.java.com.codelinetrouble.casaja.entities.Pagamento;
import main.java.com.codelinetrouble.casaja.mappers.PagamentoMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class PagamentoService implements ICrudService<PagamentoDto, Integer> {
	private final PagamentoDao pagamentoDao;
	private final PagamentoMapper pagamentoMapper;

	public PagamentoService(PagamentoDao pagamentoDao, PagamentoMapper pagamentoMapper) {
		this.pagamentoDao = pagamentoDao;
		this.pagamentoMapper = pagamentoMapper;
	}

	@Override
	public Boolean create(PagamentoDto dto) {
		Pagamento pagamento = pagamentoMapper.mapToEntity(dto);

		return pagamentoDao.create(pagamento).equals(1);
	}

	@Override
	public Integer create(List<PagamentoDto> dtos) {
		List<Pagamento> pagamentos = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> pagamentos.add(pagamentoMapper.mapToEntity(dto)));

		return pagamentoDao.create(pagamentos);
	}

	@Override
	public PagamentoDto find(Integer id) {
		Pagamento pagamento = pagamentoDao.find(id);

		if (pagamento == null) {
			return null;
		}
		
		return pagamentoMapper.mapToDto(pagamento);
	}
	
	@Override
	public List<PagamentoDto> find(List<Integer> ids) {
		List<PagamentoDto> pagamentosDto = new ArrayList<>();
		List<Pagamento> pagamentos = pagamentoDao.find(ids);

		pagamentos
			.stream()
			.forEach(entity -> pagamentosDto.add(pagamentoMapper.mapToDto(entity)));

		return pagamentosDto;
	}

	@Override
	public List<PagamentoDto> find() {
		List<Pagamento> pagamentos = pagamentoDao.find();
		List<PagamentoDto> pagamentosDto = new ArrayList<>();

		pagamentos
			.stream()
			.forEach(entity -> pagamentosDto.add(pagamentoMapper.mapToDto(entity)));

		return pagamentosDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return pagamentoDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return pagamentoDao.remove(ids);
	}

	@Override
	public Boolean update(PagamentoDto dto, Integer id) {
		return pagamentoDao.update(pagamentoMapper.mapToEntity(dto), id).equals(1);
	}
}
