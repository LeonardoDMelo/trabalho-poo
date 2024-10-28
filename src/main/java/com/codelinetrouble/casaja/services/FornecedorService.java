package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.FornecedorDao;
import main.java.com.codelinetrouble.casaja.dtos.FornecedorDto;
import main.java.com.codelinetrouble.casaja.entities.Fornecedor;
import main.java.com.codelinetrouble.casaja.mappers.FornecedorMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class FornecedorService implements ICrudService<FornecedorDto, Integer> {
	private final FornecedorDao fornecedorDao;
	private final FornecedorMapper fornecedorMapper;

	public FornecedorService(
		FornecedorDao fornecedorDao,
		FornecedorMapper fornecedorMapper) {

		this.fornecedorDao = fornecedorDao;
		this.fornecedorMapper = fornecedorMapper;
	}

	@Override
	public Boolean create(FornecedorDto dto) {
		Fornecedor fornecedor = fornecedorMapper.mapToEntity(dto);

		return fornecedorDao.create(fornecedor).equals(1);
	}

	@Override
	public Integer create(List<FornecedorDto> dtos) {
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> fornecedores.add(fornecedorMapper.mapToEntity(dto)));

		return fornecedorDao.create(fornecedores);
	}

	@Override
	public FornecedorDto find(Integer id) {
		Fornecedor fornecedor = fornecedorDao.find(id);

		if (fornecedor == null) {
			return null;
		}
		
		return fornecedorMapper.mapToDto(fornecedor);
	}
	
	@Override
	public List<FornecedorDto> find(List<Integer> ids) {
		List<FornecedorDto> fornecedoresDto = new ArrayList<>();
		List<Fornecedor> fornecedores = fornecedorDao.find(ids);

		fornecedores
			.stream()
			.forEach(entity -> fornecedoresDto.add(fornecedorMapper.mapToDto(entity)));

		return fornecedoresDto;
	}

	@Override
	public List<FornecedorDto> find() {
		List<Fornecedor> fornecedores = fornecedorDao.find();
		List<FornecedorDto> fornecedoresDto = new ArrayList<>();

		fornecedores
			.stream()
			.forEach(entity -> fornecedoresDto.add(fornecedorMapper.mapToDto(entity)));

		return fornecedoresDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return fornecedorDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return fornecedorDao.remove(ids);
	}

	@Override
	public Boolean update(FornecedorDto dto, Integer id) {
		return fornecedorDao.update(fornecedorMapper.mapToEntity(dto), id).equals(1);
	}
	
}
