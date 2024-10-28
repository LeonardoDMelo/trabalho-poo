package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.RecadoController;
import main.java.com.codelinetrouble.casaja.daos.RecadoDao;
import main.java.com.codelinetrouble.casaja.mappers.RecadoMapper;
import main.java.com.codelinetrouble.casaja.services.RecadoService;
import main.java.com.codelinetrouble.casaja.views.RecadoView;

public class SetupRecado implements ISetup<RecadoView>{
	@Override
	public RecadoView setup() {
		RecadoDao recadoDao = new RecadoDao();
		RecadoMapper recadoMapper = new RecadoMapper();
		RecadoService recadoService = new RecadoService(recadoDao, recadoMapper);
		RecadoController recadoController = new RecadoController(recadoService);

		return new RecadoView(recadoController);
	}
}
