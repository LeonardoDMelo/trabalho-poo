package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.ConviteIndividualController;
import main.java.com.codelinetrouble.casaja.daos.ConviteIndividualDao;
import main.java.com.codelinetrouble.casaja.mappers.ConviteIndividualMapper;
import main.java.com.codelinetrouble.casaja.services.ConviteIndividualService;
import main.java.com.codelinetrouble.casaja.views.ConviteIndividualView;

public class SetupConviteIndividual implements ISetup<ConviteIndividualView> {
	@Override
	public ConviteIndividualView setup() {
		ConviteIndividualDao conviteIndividualDao = new ConviteIndividualDao();
		ConviteIndividualMapper conviteIndividualMapper = new ConviteIndividualMapper();
		ConviteIndividualService conviteIndividualService = new ConviteIndividualService(conviteIndividualDao, conviteIndividualMapper);
		ConviteIndividualController conviteIndividualController = new ConviteIndividualController(conviteIndividualService);

		return new ConviteIndividualView(conviteIndividualController);
}
}
