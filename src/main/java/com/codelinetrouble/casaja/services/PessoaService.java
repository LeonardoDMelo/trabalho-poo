package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.PessoaDao;
import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.entities.Pessoa;
import main.java.com.codelinetrouble.casaja.mappers.PessoaMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class PessoaService implements ICrudService<PessoaDto, Integer> {
	private final PessoaDao pessoaDao;
	private final PessoaMapper pessoaMapper;

	public PessoaService(PessoaDao pessoaDao, PessoaMapper pessoaMapper) {
		this.pessoaDao = pessoaDao;
		this.pessoaMapper = pessoaMapper;
	}

	@Override
	public Boolean create(PessoaDto dto) {
		Pessoa pessoa = pessoaMapper.mapToEntity(dto);

		return pessoaDao.create(pessoa).equals(1);
	}

	@Override
	public Integer create(List<PessoaDto> dtos) {
		List<Pessoa> pessoas = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> pessoas.add(pessoaMapper.mapToEntity(dto)));

		return pessoaDao.create(pessoas);
	}

	@Override
	public PessoaDto find(Integer id) {
		Pessoa pessoa = pessoaDao.find(id);

		if (pessoa == null) {
			return null;
		}
		
		return pessoaMapper.mapToDto(pessoa);
	}
	
	@Override
	public List<PessoaDto> find(List<Integer> ids) {
		List<PessoaDto> pessoasDto = new ArrayList<>();
		List<Pessoa> pessoas = pessoaDao.find(ids);

		pessoas
			.stream()
			.forEach(entity -> pessoasDto.add(pessoaMapper.mapToDto(entity)));

		return pessoasDto;
	}

	@Override
	public List<PessoaDto> find() {
		List<Pessoa> pessoas = pessoaDao.find();
		List<PessoaDto> pessoasDto = new ArrayList<>();

		pessoas
			.stream()
			.forEach(entity -> pessoasDto.add(pessoaMapper.mapToDto(entity)));

		return pessoasDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return pessoaDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return pessoaDao.remove(ids);
	}

	@Override
	public Boolean update(PessoaDto dto, Integer id) {
		return pessoaDao.update(pessoaMapper.mapToEntity(dto), id).equals(1);
	}
	
}
