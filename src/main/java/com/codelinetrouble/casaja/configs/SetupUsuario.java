package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.UsuarioController;
import main.java.com.codelinetrouble.casaja.daos.UsuarioDao;
import main.java.com.codelinetrouble.casaja.mappers.UsuarioMapper;
import main.java.com.codelinetrouble.casaja.services.UsuarioService;
import main.java.com.codelinetrouble.casaja.views.UsuarioView;

public class SetupUsuario implements ISetup<UsuarioView>{
	@Override
	public UsuarioView setup() {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioMapper usuarioMapper = new UsuarioMapper();
		UsuarioService usuarioService = new UsuarioService(usuarioDao, usuarioMapper);
		UsuarioController usuarioController = new UsuarioController(usuarioService);

		return new UsuarioView(usuarioController);
	}
}
