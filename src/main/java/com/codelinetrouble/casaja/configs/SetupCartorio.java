package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.CartorioController;
import main.java.com.codelinetrouble.casaja.daos.CartorioDao;
import main.java.com.codelinetrouble.casaja.mappers.CartorioMapper;
import main.java.com.codelinetrouble.casaja.services.CartorioService;
import main.java.com.codelinetrouble.casaja.views.CartorioView;

public class SetupCartorio implements ISetup<CartorioView> {
	@Override
	public CartorioView setup() {
		CartorioDao cartorioDao = new CartorioDao();
		CartorioMapper cartorioMapper = new CartorioMapper();
		CartorioService cartorioService = new CartorioService(cartorioDao, cartorioMapper);
		CartorioController cartorioController = new CartorioController(cartorioService);

		return new CartorioView(cartorioController);
	}
}
