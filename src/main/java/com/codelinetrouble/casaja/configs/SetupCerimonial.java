package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.CerimonialController;
import main.java.com.codelinetrouble.casaja.daos.CerimonialDao;
import main.java.com.codelinetrouble.casaja.mappers.CerimonialMapper;
import main.java.com.codelinetrouble.casaja.services.CerimonialService;
import main.java.com.codelinetrouble.casaja.views.CerimonialView;

public class SetupCerimonial implements ISetup<CerimonialView> {
	@Override
	public CerimonialView setup() {
		CerimonialDao cerimonialDao = new CerimonialDao();
		CerimonialMapper cerimonialMapper = new CerimonialMapper();
		CerimonialService cerimonialService = new CerimonialService(cerimonialDao, cerimonialMapper);
		CerimonialController cerimonialController = new CerimonialController(cerimonialService);

		return new CerimonialView(cerimonialController);
	}
}
