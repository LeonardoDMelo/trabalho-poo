package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.ConviteFamiliarDao;
import main.java.com.codelinetrouble.casaja.dtos.ConviteFamiliarDto;
import main.java.com.codelinetrouble.casaja.entities.ConviteFamiliar;
import main.java.com.codelinetrouble.casaja.mappers.ConviteFamiliarMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class ConviteFamiliarService implements ICrudService<ConviteFamiliarDto, Integer> {
	private final ConviteFamiliarDao conviteFamiliarDao;
	private final ConviteFamiliarMapper conviteFamiliarMapper;

	public ConviteFamiliarService(
		ConviteFamiliarDao conviteFamiliarDao,
		ConviteFamiliarMapper conviteFamiliarMapper) {

		this.conviteFamiliarDao = conviteFamiliarDao;
		this.conviteFamiliarMapper = conviteFamiliarMapper;
	}

	@Override
	public Boolean create(ConviteFamiliarDto dto) {
		ConviteFamiliar conviteFamiliar = conviteFamiliarMapper.mapToEntity(dto);

		return conviteFamiliarDao.create(conviteFamiliar).equals(1);
	}

	@Override
	public Integer create(List<ConviteFamiliarDto> dtos) {
		List<ConviteFamiliar> convitesFamiliares = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> convitesFamiliares.add(conviteFamiliarMapper.mapToEntity(dto)));

		return conviteFamiliarDao.create(convitesFamiliares);
	}

	@Override
	public ConviteFamiliarDto find(Integer id) {
		ConviteFamiliar conviteFamiliar = conviteFamiliarDao.find(id);

		if (conviteFamiliar == null) {
			return null;
		}
		
		return conviteFamiliarMapper.mapToDto(conviteFamiliar);
	}
	
	@Override
	public List<ConviteFamiliarDto> find(List<Integer> ids) {
		List<ConviteFamiliarDto> convitesFamiliaresDto = new ArrayList<>();
		List<ConviteFamiliar> convitesFamiliares = conviteFamiliarDao.find(ids);

		convitesFamiliares
			.stream()
			.forEach(entity -> convitesFamiliaresDto.add(conviteFamiliarMapper.mapToDto(entity)));

		return convitesFamiliaresDto;
	}

	@Override
	public List<ConviteFamiliarDto> find() {
		List<ConviteFamiliar> conviteFamiliares = conviteFamiliarDao.find();
		List<ConviteFamiliarDto> conviteFamiliaresDto = new ArrayList<>();

		conviteFamiliares
			.stream()
			.forEach(entity -> conviteFamiliaresDto.add(conviteFamiliarMapper.mapToDto(entity)));

		return conviteFamiliaresDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return conviteFamiliarDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return conviteFamiliarDao.remove(ids);
	}

	@Override
	public Boolean update(ConviteFamiliarDto dto, Integer id) {
		return conviteFamiliarDao.update(conviteFamiliarMapper.mapToEntity(dto), id).equals(1);
	}
}
