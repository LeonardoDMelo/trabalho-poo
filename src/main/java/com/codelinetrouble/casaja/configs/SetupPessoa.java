package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.PessoaController;
import main.java.com.codelinetrouble.casaja.daos.PessoaDao;
import main.java.com.codelinetrouble.casaja.mappers.PessoaMapper;
import main.java.com.codelinetrouble.casaja.services.PessoaService;
import main.java.com.codelinetrouble.casaja.views.PessoaView;

public class SetupPessoa implements ISetup<PessoaView> {
	@Override
	public PessoaView setup() {
		PessoaDao pessoaDao = new PessoaDao();
		PessoaMapper pessoaMapper = new PessoaMapper();
		PessoaService pessoaService = new PessoaService(pessoaDao, pessoaMapper);
		PessoaController pessoaController = new PessoaController(pessoaService);

		return new PessoaView(pessoaController);
	}
}
