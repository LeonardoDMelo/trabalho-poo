package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.RecadoDao;
import main.java.com.codelinetrouble.casaja.dtos.RecadoDto;
import main.java.com.codelinetrouble.casaja.entities.Recado;
import main.java.com.codelinetrouble.casaja.mappers.RecadoMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class RecadoService implements ICrudService<RecadoDto, Integer> {
	private final RecadoDao recadoDao;
	private final RecadoMapper recadoMapper;

	public RecadoService(RecadoDao recadoDao, RecadoMapper recadoMapper) {
		this.recadoDao = recadoDao;
		this.recadoMapper = recadoMapper;
	}

	@Override
	public Boolean create(RecadoDto dto) {
		Recado recado = recadoMapper.mapToEntity(dto);

		return recadoDao.create(recado).equals(1);
	}

	@Override
	public Integer create(List<RecadoDto> dtos) {
		List<Recado> recados = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> recados.add(recadoMapper.mapToEntity(dto)));

		return recadoDao.create(recados);
	}

	@Override
	public RecadoDto find(Integer id) {
		Recado recado = recadoDao.find(id);

		if (recado == null) {
			return null;
		}
		
		return recadoMapper.mapToDto(recado);
	}
	
	@Override
	public List<RecadoDto> find(List<Integer> ids) {
		List<RecadoDto> recadosDto = new ArrayList<>();
		List<Recado> recados = recadoDao.find(ids);

		recados
			.stream()
			.forEach(entity -> recadosDto.add(recadoMapper.mapToDto(entity)));

		return recadosDto;
	}

	@Override
	public List<RecadoDto> find() {
		List<Recado> recados = recadoDao.find();
		List<RecadoDto> recadosDto = new ArrayList<>();

		recados
			.stream()
			.forEach(entity -> recadosDto.add(recadoMapper.mapToDto(entity)));

		return recadosDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return recadoDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return recadoDao.remove(ids);
	}

	@Override
	public Boolean update(RecadoDto dto, Integer id) {
		return recadoDao.update(recadoMapper.mapToEntity(dto), id).equals(1);
	}
}
