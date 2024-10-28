package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.CerimonialDao;
import main.java.com.codelinetrouble.casaja.dtos.CerimonialDto;
import main.java.com.codelinetrouble.casaja.entities.Cerimonial;
import main.java.com.codelinetrouble.casaja.mappers.CerimonialMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class CerimonialService implements ICrudService<CerimonialDto, Integer> {
	private final CerimonialDao cerimonialDao;
	private final CerimonialMapper cerimonialMapper;

	public CerimonialService(
		CerimonialDao cerimonialDao,
		CerimonialMapper cerimonialMapper) {

		this.cerimonialDao = cerimonialDao;
		this.cerimonialMapper = cerimonialMapper;
	}

	@Override
	public Boolean create(CerimonialDto dto) {
		Cerimonial cerimonial = cerimonialMapper.mapToEntity(dto);

		return cerimonialDao.create(cerimonial).equals(1);
	}

	@Override
	public Integer create(List<CerimonialDto> dtos) {
		List<Cerimonial> cerimoniais = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> cerimoniais.add(cerimonialMapper.mapToEntity(dto)));

		return cerimonialDao.create(cerimoniais);
	}

	@Override
	public CerimonialDto find(Integer id) {
		Cerimonial cerimonial = cerimonialDao.find(id);

		if (cerimonial == null) {
			return null;
		}
		
		return cerimonialMapper.mapToDto(cerimonial);
	}
	
	@Override
	public List<CerimonialDto> find(List<Integer> ids) {
		List<CerimonialDto> cerimoniaisDto = new ArrayList<>();
		List<Cerimonial> cerimoniais = cerimonialDao.find(ids);

		cerimoniais
			.stream()
			.forEach(entity -> cerimoniaisDto.add(cerimonialMapper.mapToDto(entity)));

		return cerimoniaisDto;
	}

	@Override
	public List<CerimonialDto> find() {
		List<Cerimonial> cerimoniais = cerimonialDao.find();
		List<CerimonialDto> cerimoniaisDto = new ArrayList<>();

		cerimoniais
			.stream()
			.forEach(entity -> cerimoniaisDto.add(cerimonialMapper.mapToDto(entity)));

		return cerimoniaisDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return cerimonialDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return cerimonialDao.remove(ids);
	}

	@Override
	public Boolean update(CerimonialDto dto, Integer id) {
		return cerimonialDao.update(cerimonialMapper.mapToEntity(dto), id).equals(1);
	}
}
