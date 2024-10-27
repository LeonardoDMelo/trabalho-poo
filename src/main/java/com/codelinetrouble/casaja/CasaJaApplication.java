package main.java.com.codelinetrouble.casaja;

import main.java.com.codelinetrouble.casaja.controllers.PessoaController;
import main.java.com.codelinetrouble.casaja.daos.PessoaDao;
import main.java.com.codelinetrouble.casaja.mappers.PessoaMapper;
import main.java.com.codelinetrouble.casaja.services.PessoaService;
import main.java.com.codelinetrouble.casaja.views.PessoaView;

public class CasaJaApplication {
	public static void main(String[] args) {
		//	Setup Pessoa

		PessoaDao pessoaDao = new PessoaDao();
		PessoaMapper pessoaMapper = new PessoaMapper();
		PessoaService pessoaService = new PessoaService(pessoaDao, pessoaMapper);
		PessoaController pessoaController = new PessoaController(pessoaService);
		PessoaView pessoaView = new PessoaView(pessoaController);

		pessoaView.menu();
	}
}
