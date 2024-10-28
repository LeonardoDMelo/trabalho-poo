package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.PagamentoController;
import main.java.com.codelinetrouble.casaja.daos.PagamentoDao;
import main.java.com.codelinetrouble.casaja.mappers.PagamentoMapper;
import main.java.com.codelinetrouble.casaja.services.PagamentoService;
import main.java.com.codelinetrouble.casaja.views.PagamentoView;

public class SetupPagamento implements ISetup<PagamentoView> {
	@Override
	public PagamentoView setup() {
		PagamentoDao pagamentoDao = new PagamentoDao();
		PagamentoMapper pagamentoMapper = new PagamentoMapper();
		PagamentoService pagamentoService = new PagamentoService(pagamentoDao, pagamentoMapper);
		PagamentoController pagamentoController = new PagamentoController(pagamentoService);

		return new PagamentoView(pagamentoController);
	}
}
