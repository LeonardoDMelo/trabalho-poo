package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.PresenteDao;
import main.java.com.codelinetrouble.casaja.dtos.PresenteDto;
import main.java.com.codelinetrouble.casaja.entities.Presente;
import main.java.com.codelinetrouble.casaja.mappers.PresenteMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class PresenteService implements ICrudService<PresenteDto, Integer> {
	private final PresenteDao presenteDao;
	private final PresenteMapper presenteMapper;

	public PresenteService(PresenteDao presenteDao, PresenteMapper presenteMapper) {
		this.presenteDao = presenteDao;
		this.presenteMapper = presenteMapper;
	}

	@Override
	public Boolean create(PresenteDto dto) {
		Presente presente = presenteMapper.mapToEntity(dto);

		return presenteDao.create(presente).equals(1);
	}

	@Override
	public Integer create(List<PresenteDto> dtos) {
		List<Presente> presentes = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> presentes.add(presenteMapper.mapToEntity(dto)));

		return presenteDao.create(presentes);
	}

	@Override
	public PresenteDto find(Integer id) {
		Presente presente = presenteDao.find(id);

		if (presente == null) {
			return null;
		}
		
		return presenteMapper.mapToDto(presente);
	}
	
	@Override
	public List<PresenteDto> find(List<Integer> ids) {
		List<PresenteDto> presentesDto = new ArrayList<>();
		List<Presente> presentes = presenteDao.find(ids);

		presentes
			.stream()
			.forEach(entity -> presentesDto.add(presenteMapper.mapToDto(entity)));

		return presentesDto;
	}

	@Override
	public List<PresenteDto> find() {
		List<Presente> presentes = presenteDao.find();
		List<PresenteDto> presentesDto = new ArrayList<>();

		presentes
			.stream()
			.forEach(entity -> presentesDto.add(presenteMapper.mapToDto(entity)));

		return presentesDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return presenteDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return presenteDao.remove(ids);
	}

	@Override
	public Boolean update(PresenteDto dto, Integer id) {
		return presenteDao.update(presenteMapper.mapToEntity(dto), id).equals(1);
	}
	
}
