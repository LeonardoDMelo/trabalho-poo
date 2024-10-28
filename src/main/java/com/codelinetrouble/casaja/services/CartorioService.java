package main.java.com.codelinetrouble.casaja.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.CartorioDao;
import main.java.com.codelinetrouble.casaja.dtos.CartorioDto;
import main.java.com.codelinetrouble.casaja.entities.Cartorio;
import main.java.com.codelinetrouble.casaja.mappers.CartorioMapper;
import main.java.com.codelinetrouble.casaja.services.interfaces.ICrudService;

public class CartorioService implements ICrudService<CartorioDto, Integer> {
	private final CartorioDao cartorioDao;
	private final CartorioMapper cartorioMapper;

	public CartorioService(
		CartorioDao cartorioDao,
		CartorioMapper cartorioMapper) {

		this.cartorioDao = cartorioDao;
		this.cartorioMapper = cartorioMapper;
	}

	@Override
	public Boolean create(CartorioDto dto) {
		Cartorio cartorio = cartorioMapper.mapToEntity(dto);

		return cartorioDao.create(cartorio).equals(1);
	}

	@Override
	public Integer create(List<CartorioDto> dtos) {
		List<Cartorio> cartorios = new ArrayList<>();
		
		dtos
			.stream()
			.forEach(dto -> cartorios.add(cartorioMapper.mapToEntity(dto)));

		return cartorioDao.create(cartorios);
	}

	@Override
	public CartorioDto find(Integer id) {
		Cartorio cartorio = cartorioDao.find(id);

		if (cartorio == null) {
			return null;
		}
		
		return cartorioMapper.mapToDto(cartorio);
	}
	
	@Override
	public List<CartorioDto> find(List<Integer> ids) {
		List<CartorioDto> cartoriosDto = new ArrayList<>();
		List<Cartorio> cartorios = cartorioDao.find(ids);

		cartorios
			.stream()
			.forEach(entity -> cartoriosDto.add(cartorioMapper.mapToDto(entity)));

		return cartoriosDto;
	}

	@Override
	public List<CartorioDto> find() {
		List<Cartorio> cartorios = cartorioDao.find();
		List<CartorioDto> cartoriosDto = new ArrayList<>();

		cartorios
			.stream()
			.forEach(entity -> cartoriosDto.add(cartorioMapper.mapToDto(entity)));

		return cartoriosDto;
	}

	@Override
	public Boolean remove(Integer id) {
		return cartorioDao.remove(id).equals(1);
	}
	
	@Override
	public Integer remove(List<Integer> ids) {
		return cartorioDao.remove(ids);
	}

	@Override
	public Boolean update(CartorioDto dto, Integer id) {
		return cartorioDao.update(cartorioMapper.mapToEntity(dto), id).equals(1);
	}
}
