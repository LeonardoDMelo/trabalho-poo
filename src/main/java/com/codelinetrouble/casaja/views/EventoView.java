package main.java.com.codelinetrouble.casaja.views;

import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.EventoController;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class EventoView implements IView {
	private final EventoController eventoController;
	private final Scanner scanner;

	public EventoView(EventoController eventoController) {
		this.eventoController = eventoController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
	}
}
