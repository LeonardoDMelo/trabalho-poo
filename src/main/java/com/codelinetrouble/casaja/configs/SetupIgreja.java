package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.IgrejaController;
import main.java.com.codelinetrouble.casaja.daos.IgrejaDao;
import main.java.com.codelinetrouble.casaja.mappers.IgrejaMapper;
import main.java.com.codelinetrouble.casaja.services.IgrejaService;
import main.java.com.codelinetrouble.casaja.views.IgrejaView;

public class SetupIgreja implements ISetup<IgrejaView> {
	@Override
	public IgrejaView setup() {
		IgrejaDao igrejaDao = new IgrejaDao();
		IgrejaMapper igrejaMapper = new IgrejaMapper();
		IgrejaService igrejaService = new IgrejaService(igrejaDao, igrejaMapper);
		IgrejaController igrejaController = new IgrejaController(igrejaService);

		return new IgrejaView(igrejaController);
	}
}
