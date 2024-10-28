package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.ConviteFamiliarController;
import main.java.com.codelinetrouble.casaja.daos.ConviteFamiliarDao;
import main.java.com.codelinetrouble.casaja.entities.ConviteFamiliar;
import main.java.com.codelinetrouble.casaja.mappers.ConviteFamiliarMapper;
import main.java.com.codelinetrouble.casaja.services.ConviteFamiliarService;
import main.java.com.codelinetrouble.casaja.views.ConviteFamiliarView;

public class SetupConviteFamiliar implements ISetup<ConviteFamiliarView> {
	@Override
	public ConviteFamiliarView setup() {
		ConviteFamiliarDao conviteFamiliarDao = new ConviteFamiliarDao();
		ConviteFamiliarMapper conviteFamiliarMapper = new ConviteFamiliarMapper();
		ConviteFamiliarService conviteFamiliarService = new ConviteFamiliarService(conviteFamiliarDao, conviteFamiliarMapper);
		ConviteFamiliarController conviteFamiliarController = new ConviteFamiliarController(conviteFamiliarService);

		return new ConviteFamiliarView(conviteFamiliarController);
	}
}
