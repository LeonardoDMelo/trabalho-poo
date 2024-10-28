package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.IgrejaDao;
import main.java.com.codelinetrouble.casaja.dtos.IgrejaDto;
import main.java.com.codelinetrouble.casaja.entities.Igreja;
import main.java.com.codelinetrouble.casaja.mappers.IgrejaMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class IgrejaService implements ICrudService<IgrejaDto, Integer> {
	private final IgrejaDao igrejaDao;
	private final IgrejaMapper igrejaMapper;

	public IgrejaService(
		IgrejaDao igrejaDao,
		IgrejaMapper igrejaMapper) {

		this.igrejaDao = igrejaDao;
		this.igrejaMapper = igrejaMapper;
	}

	@Override
	public Boolean create(IgrejaDto dto) {
		Igreja igreja = igrejaMapper.mapToEntity(dto);

		return igrejaDao.create(igreja).equals(1);
	}

	@Override
	public Integer create(List<IgrejaDto> dtos) {
		List<Igreja> igrejas = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> igrejas.add(igrejaMapper.mapToEntity(dto)));

		return igrejaDao.create(igrejas);
	}

	@Override
	public IgrejaDto find(Integer id) {
		Igreja igreja = igrejaDao.find(id);

		if (igreja == null) {
			return null;
		}
		
		return igrejaMapper.mapToDto(igreja);
	}
	
	@Override
	public List<IgrejaDto> find(List<Integer> ids) {
		List<IgrejaDto> igrejasDto = new ArrayList<>();
		List<Igreja> igrejas = igrejaDao.find(ids);

		igrejas
			.stream()
			.forEach(entity -> igrejasDto.add(igrejaMapper.mapToDto(entity)));

		return igrejasDto;
	}

	@Override
	public List<IgrejaDto> find() {
		List<Igreja> igrejas = igrejaDao.find();
		List<IgrejaDto> igrejasDto = new ArrayList<>();

		igrejas
			.stream()
			.forEach(entity -> igrejasDto.add(igrejaMapper.mapToDto(entity)));

		return igrejasDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return igrejaDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return igrejaDao.remove(ids);
	}

	@Override
	public Boolean update(IgrejaDto dto, Integer id) {
		return igrejaDao.update(igrejaMapper.mapToEntity(dto), id).equals(1);
	}
}
