package main.java.com.codelinetrouble.casaja.controllers;

import java.util.List;

import main.java.com.codelinetrouble.casaja.controllers.interfaces.ICrudController;
import main.java.com.codelinetrouble.casaja.dtos.CartorioDto;
import main.java.com.codelinetrouble.casaja.services.CartorioService;

public class CartorioController implements ICrudController<CartorioDto, Integer>{
	private final CartorioService cartorioService;

	public CartorioController(CartorioService cartorioService) {
		this.cartorioService = cartorioService;
	}

	@Override
	public Boolean create(CartorioDto dto) {
		return cartorioService.create(dto);
	}

	@Override
	public Integer create(List<CartorioDto> dtos) {
		return cartorioService.create(dtos);
	}

	@Override
	public CartorioDto find(Integer id) {
		return cartorioService.find(id);
	}

	@Override
	public List<CartorioDto> find(List<Integer> ids) {
		return cartorioService.find(ids);
	}

	@Override
	public List<CartorioDto> find() {
		return cartorioService.find();
	}

	@Override
	public Boolean remove(Integer id) {
		return cartorioService.remove(id);
	}

	@Override
	public Integer remove(List<Integer> ids) {
		return cartorioService.remove(ids);
	}

	@Override
	public Boolean update(CartorioDto dto, Integer id) {
		return cartorioService.update(dto, id);
	}
}
