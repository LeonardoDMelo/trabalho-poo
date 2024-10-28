package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.PresenteController;
import main.java.com.codelinetrouble.casaja.daos.PresenteDao;
import main.java.com.codelinetrouble.casaja.mappers.PresenteMapper;
import main.java.com.codelinetrouble.casaja.services.PresenteService;
import main.java.com.codelinetrouble.casaja.views.PresenteView;

public class SetupPresente implements ISetup<PresenteView>{
	@Override
	public PresenteView setup() {
		PresenteDao presenteDao = new PresenteDao();
		PresenteMapper presenteMapper = new PresenteMapper();
		PresenteService presenteService = new PresenteService(presenteDao, presenteMapper);
		PresenteController presenteController = new PresenteController(presenteService);

		return new PresenteView(presenteController);
	}
}
