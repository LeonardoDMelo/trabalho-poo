package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.FornecedorController;
import main.java.com.codelinetrouble.casaja.daos.FornecedorDao;
import main.java.com.codelinetrouble.casaja.mappers.FornecedorMapper;
import main.java.com.codelinetrouble.casaja.services.FornecedorService;
import main.java.com.codelinetrouble.casaja.views.FornecedorView;

public class SetupFornecedor implements ISetup<FornecedorView> {
	@Override
	public FornecedorView setup() {
		FornecedorDao fornecedorDao = new FornecedorDao();
		FornecedorMapper fornecedorMapper = new FornecedorMapper();
		FornecedorService fornecedorService = new FornecedorService(fornecedorDao, fornecedorMapper);
		FornecedorController fornecedorController = new FornecedorController(fornecedorService);

		return new FornecedorView(fornecedorController);
	}
}
