package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.ConviteIndividualDao;
import main.java.com.codelinetrouble.casaja.dtos.ConviteIndividualDto;
import main.java.com.codelinetrouble.casaja.entities.ConviteIndividual;
import main.java.com.codelinetrouble.casaja.mappers.ConviteIndividualMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class ConviteIndividualService implements ICrudService<ConviteIndividualDto, Integer> {
	private final ConviteIndividualDao conviteIndividualDao;
	private final ConviteIndividualMapper conviteIndividualMapper;

	public ConviteIndividualService(
		ConviteIndividualDao conviteIndividualDao,
		ConviteIndividualMapper conviteIndividualMapper) {

		this.conviteIndividualDao = conviteIndividualDao;
		this.conviteIndividualMapper = conviteIndividualMapper;
	}

	@Override
	public Boolean create(ConviteIndividualDto dto) {
		ConviteIndividual conviteIndividual = conviteIndividualMapper.mapToEntity(dto);

		return conviteIndividualDao.create(conviteIndividual).equals(1);
	}

	@Override
	public Integer create(List<ConviteIndividualDto> dtos) {
		List<ConviteIndividual> convitesIndividuais = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> convitesIndividuais.add(conviteIndividualMapper.mapToEntity(dto)));

		return conviteIndividualDao.create(convitesIndividuais);
	}

	@Override
	public ConviteIndividualDto find(Integer id) {
		ConviteIndividual conviteIndividual = conviteIndividualDao.find(id);

		if (conviteIndividual == null) {
			return null;
		}
		
		return conviteIndividualMapper.mapToDto(conviteIndividual);
	}
	
	@Override
	public List<ConviteIndividualDto> find(List<Integer> ids) {
		List<ConviteIndividualDto> convitesIndividuaisDto = new ArrayList<>();
		List<ConviteIndividual> convitesIndividuais = conviteIndividualDao.find(ids);

		convitesIndividuais
			.stream()
			.forEach(entity -> convitesIndividuaisDto.add(conviteIndividualMapper.mapToDto(entity)));

		return convitesIndividuaisDto;
	}

	@Override
	public List<ConviteIndividualDto> find() {
		List<ConviteIndividual> convitesIndividuais = conviteIndividualDao.find();
		List<ConviteIndividualDto> convitesIndividuaisDto = new ArrayList<>();

		convitesIndividuais
			.stream()
			.forEach(entity -> convitesIndividuaisDto.add(conviteIndividualMapper.mapToDto(entity)));

		return convitesIndividuaisDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return conviteIndividualDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return conviteIndividualDao.remove(ids);
	}

	@Override
	public Boolean update(ConviteIndividualDto dto, Integer id) {
		return conviteIndividualDao.update(conviteIndividualMapper.mapToEntity(dto), id).equals(1);
	}
}
