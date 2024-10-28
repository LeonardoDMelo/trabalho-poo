package main.java.com.codelinetrouble.casaja.configs;

import main.java.com.codelinetrouble.casaja.configs.interfaces.ISetup;
import main.java.com.codelinetrouble.casaja.controllers.EventoController;
import main.java.com.codelinetrouble.casaja.daos.EventoDao;
import main.java.com.codelinetrouble.casaja.mappers.EventoMapper;
import main.java.com.codelinetrouble.casaja.services.EventoService;
import main.java.com.codelinetrouble.casaja.views.EventoView;

public class SetupEvento implements ISetup<EventoView> {
	@Override
	public EventoView setup() {
		EventoDao eventoDao = new EventoDao();
		EventoMapper eventoMapper = new EventoMapper();
		EventoService eventoService = new EventoService(eventoDao, eventoMapper);
		EventoController eventoController = new EventoController(eventoService);

		return new EventoView(eventoController);
	}
}
